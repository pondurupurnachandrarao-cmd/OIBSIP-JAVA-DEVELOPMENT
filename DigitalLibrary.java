import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Scanner sc) {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added successfully");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available");
            return;
        }

        for (Book b : books) {
            System.out.println("ID: " + b.id + " | Title: " + b.title + " | Author: " + b.author + " | Issued: " + b.isIssued);
        }
    }

    public void searchBook(Scanner sc) {
        System.out.print("Enter Book Title: ");
        sc.nextLine();
        String title = sc.nextLine();

        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println("Found -> ID: " + b.id + " Author: " + b.author + " Issued: " + b.isIssued);
                return;
            }
        }
        System.out.println("Book not found");
    }

    public void deleteBook(Scanner sc) {
        System.out.print("Enter Book ID to delete: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                books.remove(b);
                System.out.println("Book deleted");
                return;
            }
        }
        System.out.println("Book not found");
    }

    public void issueBook(Scanner sc) {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book issued");
                } else {
                    System.out.println("Already issued");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }

    public void returnBook(Scanner sc) {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book returned");
                } else {
                    System.out.println("Book was not issued");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }
}

public class DigitalLibrary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n1. Admin Login");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Admin Password: ");
                    String pass = sc.next();
                    if (pass.equals("admin")) {
                        adminLoop:
                        while (true) {
                            System.out.println("\nAdmin Menu");
                            System.out.println("1. Add Book");
                            System.out.println("2. Delete Book");
                            System.out.println("3. View Books");
                            System.out.println("4. Back");
                            int ch = sc.nextInt();

                            switch (ch) {
                                case 1 -> lib.addBook(sc);
                                case 2 -> lib.deleteBook(sc);
                                case 3 -> lib.viewBooks();
                                case 4 -> {
                                    break adminLoop;
                                }
                                default -> System.out.println("Invalid choice");
                            }
                        }
                    } else {
                        System.out.println("Wrong Password");
                    }
                }

                case 2 -> {
                    userLoop:
                    while (true) {
                        System.out.println("\nUser Menu");
                        System.out.println("1. View Books");
                        System.out.println("2. Search Book");
                        System.out.println("3. Issue Book");
                        System.out.println("4. Return Book");
                        System.out.println("5. Back");
                        int ch = sc.nextInt();

                        switch (ch) {
                            case 1 -> lib.viewBooks();
                            case 2 -> lib.searchBook(sc);
                            case 3 -> lib.issueBook(sc);
                            case 4 -> lib.returnBook(sc);
                            case 5 -> {
                                break userLoop;
                            }
                            default -> System.out.println("Invalid choice");
                        }
                    }
                }

                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice");
            }
        }
    }
}
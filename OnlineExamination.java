import java.util.Scanner;

class User {
    String userId = "student";
    String password = "1234";

    public boolean login(Scanner sc) {
        System.out.print("Enter User ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();
        if (id.equals(userId) && pass.equals(password)) {
            System.out.println("Login Successful");
            return true;
        } else {
            System.out.println("Invalid Credentials");
            return false;
        }
    }

    public void updateProfile(Scanner sc) {
        System.out.print("Enter new User ID: ");
        userId = sc.nextLine();
        System.out.println("User ID updated");
    }

    public void updatePassword(Scanner sc) {
        System.out.print("Enter new Password: ");
        password = sc.nextLine();
        System.out.println("Password updated");
    }
}

class Exam {
    String[] questions = {
            "1. Java is a ?\nA. Language\nB. Animal\nC. Car\nD. Food",
            "2. JVM stands for?\nA. Java Virtual Machine\nB. Java Variable Method\nC. Just Very Mad\nD. None",
            "3. Which keyword is used for class?\nA. define\nB. class\nC. struct\nD. object"
    };

    char[] answers = {'A', 'A', 'B'};

    volatile boolean timeUp = false;
    volatile boolean examFinished = false;

    public void startTimer(int totalSeconds) {
        Thread t = new Thread(() -> {
            int seconds = totalSeconds;
            try {
                while (seconds >= 0 && !examFinished) {
                    System.out.print("\rTime Left: " + seconds + " sec   ");
                    seconds--;
                    if (seconds >= 0 && !examFinished) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            break;
                        }
                    }
                }
                if (!examFinished) {
                    timeUp = true;
                    System.out.println("\nTime is up! Auto submitting...");
                }
            } catch (Exception e) {
            }
        });
        t.start();
    }

    public void startExam(Scanner sc) {
        int score = 0;

        startTimer(30);

        for (int i = 0; i < questions.length; i++) {
            if (timeUp) break;

            System.out.println("\n" + questions[i]);
            System.out.print("Enter answer: ");
            char ans = sc.next().toUpperCase().charAt(0);

            if (ans == answers[i]) {
                score++;
            }
        }

        examFinished = true;

        System.out.println("\nExam Finished");
        System.out.println("Your Score: " + score + "/" + questions.length);
    }
}

public class OnlineExamination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        Exam exam = new Exam();

        if (user.login(sc)) {
            while (true) {
                System.out.println("\n1. Update Profile");
                System.out.println("2. Update Password");
                System.out.println("3. Start Exam");
                System.out.println("4. Logout");
                System.out.print("Choose option: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> user.updateProfile(sc);
                    case 2 -> user.updatePassword(sc);
                    case 3 -> exam.startExam(sc);
                    case 4 -> {
                        System.out.println("Logged out successfully");
                        return;
                    }
                    default -> System.out.println("Invalid choice");
                }
            }
        }
    }
}
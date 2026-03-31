import java.util.ArrayList;
import java.util.Scanner;

class ATM {
    private final String userId = "purna123";
    private final String userPin = "987";
    private double balance = 10000.0;
    private final ArrayList<String> transactionHistory = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public boolean login() {
        System.out.print("Enter User ID: ");
        String id = sc.nextLine();
        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();
        if (id.equals(userId) && pin.equals(userPin)) {
            System.out.println("Login Successful");
            return true;
        } else {
            System.out.println("Invalid Credentials");
            return false;
        }
    }

    public void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet");
        } else {
            for (String t : transactionHistory) {
                System.out.println(t);
            }
        }
    }

    public void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn: " + amount);
            System.out.println("Withdrawal successful");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
        System.out.println("Deposit successful");
    }

    public void transfer() {
        System.out.print("Enter recipient account number: ");
        String acc = sc.next();
        System.out.print("Enter amount to transfer: ");
        double amount = sc.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Transferred " + amount + " to " + acc);
            System.out.println("Transfer successful");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\n1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Quit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> showTransactionHistory();
                case 2 -> withdraw();
                case 3 -> deposit();
                case 4 -> transfer();
                case 5 -> System.out.println("Current Balance: " + balance);
                case 6 -> {
                    System.out.println("Thank you for using ATM");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        ATM atm = new ATM();
        if (atm.login()) {
            atm.menu();
        }
    }
}
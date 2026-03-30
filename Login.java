import java.util.Scanner;

public class Login {

    public boolean login() {
        try (Scanner sc = new Scanner(System.in)) {
            String username = "admin";
            String password = "1234";

            System.out.println("===== LOGIN =====");
            System.out.print("Enter Username: ");
            String user = sc.next();

            System.out.print("Enter Password: ");
            String pass = sc.next();

            return user.equals(username) && pass.equals(password);
        }
    }

    public static void main(String[] args) {
        Login l = new Login();

        if (l.login()) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Invalid Login!");
        }
    }
}
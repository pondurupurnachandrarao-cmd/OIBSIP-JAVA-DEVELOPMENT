import java.util.*;

public class ReservationSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> data = new ArrayList<>();
    static ArrayList<Integer> pnrList = new ArrayList<>();

    static void reservation() {

        sc.nextLine();

        System.out.println("\n===== RESERVATION FORM =====");

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Train Number: ");
        int trainNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Train Name: ");
        String trainName = sc.nextLine();

        System.out.print("Class Type: ");
        String classType = sc.nextLine();

        System.out.print("Date: ");
        String date = sc.nextLine();

        System.out.print("From: ");
        String from = sc.nextLine();

        System.out.print("To: ");
        String to = sc.nextLine();

        int pnr = 10000 + new Random().nextInt(90000);

        String record = name + " | " + trainNo + " | " + trainName + " | "
                + classType + " | " + date + " | " + from + " -> " + to;

        data.add(record);
        pnrList.add(pnr);

        System.out.println("Reservation Successful!");
        System.out.println("PNR: " + pnr);
    }

    public static void main(String[] args) {
        reservation();
    }
}
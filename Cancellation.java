import java.util.*;

public class Cancellation {

    static Scanner sc = new Scanner(System.in);

    public static void cancel(ArrayList<String> data, ArrayList<Integer> pnrList) {

        System.out.println("\n===== CANCELLATION FORM =====");

        System.out.print("Enter PNR: ");
        int pnr = sc.nextInt();

        for (int i = 0; i < pnrList.size(); i++) {
            if (pnrList.get(i) == pnr) {

                System.out.println("Details: " + data.get(i));

                System.out.print("Confirm cancel (yes/no): ");
                String confirm = sc.next();

                if (confirm.equalsIgnoreCase("yes")) {
                    data.remove(i);
                    pnrList.remove(i);
                    System.out.println("Cancelled Successfully!");
                } else {
                    System.out.println("Cancellation Aborted");
                }
                return;
            }
        }

        System.out.println("PNR Not Found!");
    }

    public static void main(String[] args) {

        ArrayList<String> data = new ArrayList<>();
        ArrayList<Integer> pnrList = new ArrayList<>();

        data.add("Purna | 12345 | Express | Sleeper | 10-04-2026 | Vizag -> Hyderabad");
        pnrList.add(12345);

        cancel(data, pnrList);
    }
}
import java.util.ArrayList;

public class TransactionHistory {
    ArrayList<String> history = new ArrayList<>();

    public void add(String transaction) {
        history.add(transaction);
    }

    public void show() {
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:");
            for (String t : history) {
                System.out.println(t);
            }
        }
    }
}
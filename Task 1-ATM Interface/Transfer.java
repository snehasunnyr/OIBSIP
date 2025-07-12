public class Transfer {
    public void execute(User user, double amount, TransactionHistory history) {
        if (user.transfer(amount)) {
            System.out.println("Rs." + amount + " transferred successfully.");
            history.add("Transferred Rs." + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
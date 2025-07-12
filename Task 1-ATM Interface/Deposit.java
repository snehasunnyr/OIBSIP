public class Deposit {
    public void execute(User user, double amount, TransactionHistory history) {
        user.deposit(amount);
        System.out.println("Rs." + amount + " deposited successfully.");
        history.add("Deposited Rs." + amount);
    }
}
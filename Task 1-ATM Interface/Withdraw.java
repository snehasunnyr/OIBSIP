public class Withdraw {
    public void execute(User user, double amount, TransactionHistory history) {
        if (user.withdraw(amount)) {
            System.out.println("Rs." + amount + " withdrawn successfully.");
            history.add("Withdrew Rs." + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
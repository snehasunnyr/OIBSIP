import java.util.Scanner;

public class atm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TransactionHistory history = new TransactionHistory();

        System.out.print("Create a User ID: ");
        String userId = sc.nextLine();

        System.out.print("Create a PIN: ");
        String pin = sc.nextLine();

        System.out.print("Enter initial balance: Rs.");
        double initialBalance = sc.nextDouble();
        sc.nextLine();

        User currentUser = new User(userId, pin, initialBalance);

        System.out.print("\nEnter User ID: ");
        String enteredId = sc.nextLine();

        System.out.print("Enter PIN: ");
        String enteredPin = sc.nextLine();

        if (!currentUser.userId.equals(enteredId) || !currentUser.pin.equals(enteredPin)) {


        System.out.println("\nLogin successful.\n");

        Withdraw withdraw = new Withdraw();
        Deposit deposit = new Deposit();
        Transfer transfer = new Transfer();

        while (true) {
            System.out.println("------ ATM Menu ------");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    history.show();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: Rs.");
                    double wAmt = sc.nextDouble();
                    withdraw.execute(currentUser, wAmt, history);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: Rs.");
                    double dAmt = sc.nextDouble();
                    deposit.execute(currentUser, dAmt, history);
                    break;
                case 4:
                    System.out.print("Enter amount to transfer: Rs.");
                    double tAmt = sc.nextDouble();
                    transfer.execute(currentUser, tAmt, history);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }


            System.out.println();
        }
    }
    sc.close();
}
}
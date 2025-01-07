public class ATMService {
    private double balance;

    public ATMService() {
        this.balance = 0.0;  // Initial balance
    }

    public double getBalance() {
        return balance;
    }

    public void depositMoney(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdrawMoney(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Your current balance is: $" + balance);
        } else {
            System.out.println("Withdraw amount must be positive.");
        }
    }
}

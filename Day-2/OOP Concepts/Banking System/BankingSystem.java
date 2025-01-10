import java.util.Scanner;

// Base BankAccount class
class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    // Constructor to initialize account details
    public BankAccount(String accountHolderName, String accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money (with balance validation)
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Method to check the account balance
    public void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    // Getter methods for account details
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}

// Subclass SavingsAccount that extends BankAccount
class SavingsAccount extends BankAccount {
    private static final double MINIMUM_BALANCE = 100.0;

    // Constructor to initialize savings account
    public SavingsAccount(String accountHolderName, String accountNumber, double initialBalance) {
        super(accountHolderName, accountNumber, initialBalance);
    }

    // Overriding withdraw method to enforce minimum balance rule
    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount >= MINIMUM_BALANCE) {
            super.withdraw(amount);
        } else {
            System.out.println("Cannot withdraw. Minimum balance of $" + MINIMUM_BALANCE + " must be maintained.");
        }
    }
}

// Subclass CurrentAccount that extends BankAccount
class CurrentAccount extends BankAccount {
    private static final double OVERDRAFT_LIMIT = 500.0;

    // Constructor to initialize current account
    public CurrentAccount(String accountHolderName, String accountNumber, double initialBalance) {
        super(accountHolderName, accountNumber, initialBalance);
    }

    // Overriding withdraw method to allow overdraft up to a limit
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() - amount >= -OVERDRAFT_LIMIT)) {
            super.withdraw(amount);
        } else {
            System.out.println("Insufficient balance or overdraft limit reached.");
        }
    }
}

// Main class for Banking System
public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create instances of SavingsAccount and CurrentAccount
        SavingsAccount savingsAccount = new SavingsAccount("John Doe", "SA123456", 1000.0);
        CurrentAccount currentAccount = new CurrentAccount("Jane Doe", "CA987654", 200.0);

        while (true) {
            System.out.println("\n--- Banking System ---");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");
            int option = scanner.nextInt();

            if (option == 4) {
                System.out.println("Thank you for using the banking system. Goodbye!");
                break;
            }

            System.out.print("Enter account type (1 for Savings, 2 for Current): ");
            int accountType = scanner.nextInt();
            BankAccount account = (accountType == 1) ? savingsAccount : currentAccount;

            switch (option) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}

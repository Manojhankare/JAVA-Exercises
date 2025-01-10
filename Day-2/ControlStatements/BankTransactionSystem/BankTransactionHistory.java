import java.util.Scanner;

public class BankTransactionHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initial balance
        double balance = 0.0;
        
        // Transaction options
        int transactionOption;
        
        // Do-while loop for transactions
        do {
            System.out.println("\n--- Bank Transaction Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            transactionOption = scanner.nextInt();

            // Process based on user choice
            switch (transactionOption) {
                case 1:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        balance += depositAmount;
                        System.out.printf("Deposited $%.2f. New balance: $%.2f\n", depositAmount, balance);
                    } else {
                        System.out.println("Deposit amount must be positive.");
                    }
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    if (withdrawalAmount > 0) {
                        if (withdrawalAmount <= balance) {
                            balance -= withdrawalAmount;
                            System.out.printf("Withdrew $%.2f. New balance: $%.2f\n", withdrawalAmount, balance);
                        } else {
                            System.out.println("Insufficient balance for the withdrawal.");
                        }
                    } else {
                        System.out.println("Withdrawal amount must be positive.");
                    }
                    break;

                case 3:
                    System.out.printf("Your current balance is: $%.2f\n", balance);
                    break;

                case 4:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid option. Please choose a valid transaction.");
                    break;
            }
        } while (transactionOption != 4);  // Exit when user chooses option 4

        scanner.close();
    }
}

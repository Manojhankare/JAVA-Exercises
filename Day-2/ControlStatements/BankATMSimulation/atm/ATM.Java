import java.util.Scanner;

public class ATM {
    private static Scanner scanner = new Scanner(System.in);
    private static ATMService atmService = new ATMService();

    public static void main(String[] args) {
        int choice;

        while (true) {
            displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    System.out.println("Exiting the ATM. Thank you for using our services!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    // Method to display the ATM menu
    public static void displayMenu() {
        System.out.println("********** Welcome to ATM **********");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Please choose an option (1-4): ");
    }

    // Method to check balance
    public static void checkBalance() {
        System.out.println("Your current balance is: $" + atmService.getBalance());
    }

    // Method to deposit money
    public static void depositMoney() {
        System.out.print("Enter the amount to deposit: $");
        double deposit = scanner.nextDouble();
        atmService.depositMoney(deposit);
    }

    // Method to withdraw money
    public static void withdrawMoney() {
        System.out.print("Enter the amount to withdraw: $");
        double withdraw = scanner.nextDouble();
        atmService.withdrawMoney(withdraw);
    }
}

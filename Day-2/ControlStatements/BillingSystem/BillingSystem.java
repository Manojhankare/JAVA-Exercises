import java.util.Scanner;

public class BillingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of customers: ");
        int numCustomers = scanner.nextInt();
        scanner.nextLine();

        for (int customer = 1; customer <= numCustomers; customer++) {
            double totalBill = 0;
            System.out.println("\nCustomer " + customer + "'s Shopping:");

            while (true) {
                System.out.print("Enter item price (or type 'done' to finish): ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("done")) {
                    break;
                }

                try {
                    double itemPrice = Double.parseDouble(input);
                    totalBill += itemPrice;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid price or 'done'.");
                }
            }

            System.out.println("Total bill for Customer " + customer + ": $" + totalBill);
        }

        scanner.close();
    }
}

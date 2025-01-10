import java.util.Scanner;

public class ProductDiscountFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the number of products
        System.out.print("Enter the number of products: ");
        int numProducts = scanner.nextInt();

        // Loop through each product to process the price and discount
        for (int i = 1; i <= numProducts; i++) {
            System.out.println("\nProduct " + i + ":");

            // Get the price of the product
            System.out.print("Enter the price of the product: ");
            double price = scanner.nextDouble();

            // Get the discount percentage for the product
            System.out.print("Enter the discount percentage for the product: ");
            double discountPercentage = scanner.nextDouble();

            // Calculate the discount amount
            double discountAmount = (price * discountPercentage) / 100;

            // Calculate the discounted price
            double discountedPrice = price - discountAmount;

            // Display the discounted price for the product
            System.out.println("Original Price: $" + price);
            System.out.println("Discounted Price: $" + discountedPrice);
        }

        scanner.close();
    }
}

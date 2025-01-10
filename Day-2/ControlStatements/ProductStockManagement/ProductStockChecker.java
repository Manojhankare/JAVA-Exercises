import java.util.Scanner;

public class ProductStockChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define the number of products
        System.out.print("Enter the number of products: ");
        int numProducts = scanner.nextInt();

        // Define the threshold for reordering
        System.out.print("Enter the reorder threshold: ");
        int reorderThreshold = scanner.nextInt();

        // Arrays to store product names and stock levels
        String[] productNames = new String[numProducts];
        int[] stockLevels = new int[numProducts];

        // Input product names and stock levels
        for (int i = 0; i < numProducts; i++) {
            System.out.print("\nEnter name of product " + (i + 1) + ": ");
            productNames[i] = scanner.next();

            System.out.print("Enter stock level for " + productNames[i] + ": ");
            stockLevels[i] = scanner.nextInt();
        }

        // Check stock levels and display reorder messages if needed
        for (int i = 0; i < numProducts; i++) {
            System.out.println("\nProduct: " + productNames[i]);
            System.out.println("Stock Level: " + stockLevels[i]);

            // Check if stock is below the threshold
            if (stockLevels[i] < reorderThreshold) {
                System.out.println("Stock is below threshold. Reorder required!");
            } else {
                System.out.println("Stock is sufficient.");
            }
        }

        scanner.close();
    }
}

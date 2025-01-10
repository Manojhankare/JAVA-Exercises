import java.util.Scanner;

public class RestaurantMenuOrdering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menu items and prices
        String[] menuItems = {"Burger - $5.99", "Pizza - $8.99", "Pasta - $7.99", "Salad - $4.99", "Soda - $1.99"};
        double[] prices = {5.99, 8.99, 7.99, 4.99, 1.99};
        
        // Variables to track order
        double totalCost = 0.0;
        StringBuilder orderDetails = new StringBuilder();
        
        System.out.println("Welcome to the Restaurant!");
        System.out.println("Here is the menu:");
        
        // Display menu
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println((i + 1) + ". " + menuItems[i]);
        }
        
        while (true) {
            System.out.print("\nEnter the number of the item you want to order (or 0 to finish): ");
            int itemChoice = scanner.nextInt();
            
            if (itemChoice == 0) {
                break; // User is done ordering
            }
            
            // Check if the choice is valid
            if (itemChoice < 1 || itemChoice > menuItems.length) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }
            
            // Add the item to the order
            int index = itemChoice - 1;
            orderDetails.append(menuItems[index]).append("\n");
            totalCost += prices[index];
            
            System.out.println("Item added: " + menuItems[index]);
        }
        
        // Display the order details and total cost
        if (totalCost > 0) {
            System.out.println("\nYour complete order:");
            System.out.println(orderDetails.toString());
            System.out.printf("Total cost: $%.2f\n", totalCost);
        } else {
            System.out.println("No items ordered.");
        }
        
        scanner.close();
    }
}

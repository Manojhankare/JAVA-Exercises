import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// MenuItem class to represent each menu item
class MenuItem {
    private String itemName;
    private double itemPrice;
    private String itemCategory;

    // Constructor to initialize menu item
    public MenuItem(String itemName, double itemPrice, String itemCategory) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCategory = itemCategory;
    }

    // Getter methods
    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    // Method to display menu item details
    public void displayMenuItem() {
        System.out.println(itemName + " - $" + itemPrice + " (" + itemCategory + ")");
    }
}

// Restaurant class to manage menu, take orders, and calculate bill
class Restaurant {
    private List<MenuItem> menu;  // List to store menu items
    private List<MenuItem> customerOrder;  // List to store customer's orders

    // Constructor to initialize the menu and customer orders
    public Restaurant() {
        menu = new ArrayList<>();
        customerOrder = new ArrayList<>();
    }

    // Method to add items to the menu
    public void addMenuItem(String itemName, double itemPrice, String itemCategory) {
        menu.add(new MenuItem(itemName, itemPrice, itemCategory));
    }

    // Method to display the entire menu
    public void displayMenu() {
        System.out.println("\n----- Menu -----");
        for (MenuItem item : menu) {
            item.displayMenuItem();
        }
        System.out.println("----------------");
    }

    // Method to take a customer's order
    public void takeOrder(int itemNumber) {
        if (itemNumber > 0 && itemNumber <= menu.size()) {
            customerOrder.add(menu.get(itemNumber - 1));
            System.out.println(menu.get(itemNumber - 1).getItemName() + " has been added to your order.");
        } else {
            System.out.println("Invalid item number. Please try again.");
        }
    }

    // Method to calculate and display the total bill
    public void calculateBill() {
        double total = 0;
        System.out.println("\n----- Your Order -----");
        for (MenuItem item : customerOrder) {
            System.out.println(item.getItemName() + " - $" + item.getItemPrice());
            total += item.getItemPrice();
        }
        System.out.println("----------------------");
        System.out.println("Total Bill: $" + total);
    }
}

public class RestaurantOrderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();

        // Add menu items to the restaurant
        restaurant.addMenuItem("Burger", 5.99, "Main Course");
        restaurant.addMenuItem("Pizza", 8.99, "Main Course");
        restaurant.addMenuItem("Salad", 4.99, "Appetizer");
        restaurant.addMenuItem("Soda", 1.99, "Beverage");
        restaurant.addMenuItem("Ice Cream", 2.99, "Dessert");

        while (true) {
            System.out.println("\nWelcome to the Restaurant!");
            System.out.println("1. View Menu");
            System.out.println("2. Order Item");
            System.out.println("3. Calculate Bill");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    restaurant.displayMenu();  // Display the menu
                    break;

                case 2:
                    System.out.print("Enter item number to order: ");
                    int itemNumber = scanner.nextInt();
                    restaurant.takeOrder(itemNumber);  // Take the customer's order
                    break;

                case 3:
                    restaurant.calculateBill();  // Calculate and display the total bill
                    break;

                case 4:
                    System.out.println("Thank you for dining with us. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

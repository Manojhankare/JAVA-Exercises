import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// Customer class to store customer details
class Customer {
    private int customerId;
    private String name;
    private String address;

    // Constructor to initialize customer details
    public Customer(int customerId, String name, String address) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
    }

    // Method to display customer details
    public void displayCustomerDetails() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Customer Name: " + name);
        System.out.println("Customer Address: " + address);
    }

    // Getter methods
    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}

// Order class to manage order details
class Order {
    private int orderId;
    private Date orderDate;
    private List<String> orderedItems;

    // Constructor to initialize order details
    public Order(int orderId) {
        this.orderId = orderId;
        this.orderDate = new Date(); // current date
        this.orderedItems = new ArrayList<>();
    }

    // Method to add an item to the order
    public void addItem(String item) {
        orderedItems.add(item);
    }

    // Method to display order details
    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.print("Ordered Items: ");
        for (String item : orderedItems) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // Getter method
    public int getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public List<String> getOrderedItems() {
        return orderedItems;
    }
}

public class ECommerceOrderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input customer details
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer address: ");
        String address = scanner.nextLine();

        // Create a Customer object
        Customer customer = new Customer(customerId, name, address);

        // Display customer details
        customer.displayCustomerDetails();

        // Input order details
        System.out.print("\nEnter order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Create an Order object
        Order order = new Order(orderId);

        // Add items to the order
        while (true) {
            System.out.print("Enter item name to add to the order (or type 'done' to finish): ");
            String item = scanner.nextLine();

            if (item.equalsIgnoreCase("done")) {
                break; // Exit the loop if user types 'done'
            }
            order.addItem(item); // Add item to order
        }

        // Display order details
        System.out.println("\nOrder Details:");
        order.displayOrderDetails();

        scanner.close();
    }
}

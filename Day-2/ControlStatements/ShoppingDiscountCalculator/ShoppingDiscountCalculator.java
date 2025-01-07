import java.util.Scanner;

public class ShoppingDiscountCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total price of items in the cart: $");
        double totalPrice = scanner.nextDouble();
        
        double discount = 0;
        if (totalPrice > 500) {
            discount = 0.10; 
        } else if (totalPrice >= 200) {
            discount = 0.05; 
        } else {
            discount = 0; 
        }

        
        double discountAmount = totalPrice * discount;
        
        double finalPrice = totalPrice - discountAmount;

        System.out.println("Original Price: $" + totalPrice);
        System.out.println("Discount: $" + discountAmount);
        System.out.println("Final Price after Discount: $" + finalPrice);

        scanner.close();
    }
}

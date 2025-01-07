import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        String originalString = input.toLowerCase();
        String reversedString = new StringBuilder(originalString).reverse().toString();
        
        if (originalString.equals(reversedString)) {
            System.out.println("\nThe string is a palindrome.");
        } else {
            System.out.println("\nThe string is not a palindrome.");
        }
        scanner.close();
    }
}

import java.util.Scanner;

public class PasswordValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        
        // Check if password is valid
        if (password.length() >= 8 && containsLettersAndNumbers(password)) {
            System.out.println("\nPassword is valid.");
        } else {
            System.out.println("\nPassword is invalid. It must be at least 8 characters long and contain both letters and numbers.");
        }
    }

    // Helper method to check if the password contains both letters and numbers
    public static boolean containsLettersAndNumbers(String password) {
        boolean hasLetter = false;
        boolean hasDigit = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isLetter(ch)) {
                hasLetter = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }

        return hasLetter && hasDigit;
    }
}

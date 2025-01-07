import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        System.out.print("Are you a citizen of the country? (true/false): ");
        boolean isCitizen = scanner.nextBoolean();
        
        // Check voting eligibility
        if (age >= 18 && isCitizen) {
            System.out.println("\nYou are eligible to vote.");
        } else {
            System.out.println("\nYou are not eligible to vote.");
        }
        scanner.close();
    }
}

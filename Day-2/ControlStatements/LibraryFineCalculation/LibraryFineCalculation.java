import java.util.Scanner;

public class LibraryFineCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Number of books
        System.out.print("Enter the number of books: ");
        int numBooks = scanner.nextInt();
        
        // Fine calculation for each book
        for (int i = 1; i <= numBooks; i++) {
            System.out.println("\nBook " + i + ":");
            
            // Enter the overdue days for each book
            System.out.print("Enter the number of overdue days: ");
            int overdueDays = scanner.nextInt();
            
            // Calculate the fine
            double fine = 0.0;
            if (overdueDays <= 7) {
                fine = overdueDays * 1.0; // $1 per day for the first 7 days
            } else {
                fine = 7 * 1.0 + (overdueDays - 7) * 2.0; // $1 for first 7 days, $2 for remaining days
            }
            
            // Display the fine for the book
            System.out.printf("The fine for Book %d is: $%.2f\n", i, fine);
        }
        
        scanner.close();
    }
}

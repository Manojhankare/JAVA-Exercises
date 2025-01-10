import java.util.Scanner;

public class CinemaSeatReservation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define the cinema seats (5 rows, 10 seats per row)
        String[][] seats = new String[5][10];

        // Initialize all seats as available
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = "Available";
            }
        }

        // Loop for seat reservations
        while (true) {
            // Display the cinema seats
            System.out.println("\nCinema Seats:");
            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < seats[i].length; j++) {
                    System.out.print(seats[i][j] + "\t");
                }
                System.out.println();
            }

            // Ask for user input to reserve a seat
            System.out.println("\nEnter the row number (1-5) and seat number (1-10) to reserve a seat.");
            System.out.print("Row: ");
            int row = scanner.nextInt() - 1; // Convert to 0-based index
            System.out.print("Seat: ");
            int seat = scanner.nextInt() - 1; // Convert to 0-based index

            // Check if the seat is available
            if (row >= 0 && row < 5 && seat >= 0 && seat < 10) {
                if (seats[row][seat].equals("Available")) {
                    seats[row][seat] = "Reserved";
                    System.out.println("Seat reserved successfully!");
                } else {
                    System.out.println("Sorry, that seat is already reserved.");
                }
            } else {
                System.out.println("Invalid seat selection. Please choose a valid row and seat.");
            }

            // Ask the user if they want to reserve another seat
            System.out.print("\nDo you want to reserve another seat? (yes/no): ");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("no")) {
                break; // Exit the loop if the user is done
            }
        }

        // Display final cinema seats status
        System.out.println("\nFinal Cinema Seats:");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + "\t");
            }
            System.out.println();
        }

        scanner.close();
    }
}

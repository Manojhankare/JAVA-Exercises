import java.util.Scanner;

public class CinemaSeatReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define the number of rows and columns for the cinema seating arrangement
        int rows = 5;
        int cols = 5;

        // Create a 2D array to represent the seats, initialized to "Available"
        String[][] seats = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seats[i][j] = "Available";
            }
        }

        // Variable to control the loop for reservation
        boolean continueReserving = true;

        while (continueReserving) {
            // Display the current seating arrangement
            System.out.println("\nCinema Seating Arrangement:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(seats[i][j] + "\t");
                }
                System.out.println();
            }

            // Ask the user for a seat to reserve
            System.out.print("\nEnter the row number (1 to " + rows + "): ");
            int rowChoice = scanner.nextInt() - 1; // Adjust for 0-based index

            System.out.print("Enter the column number (1 to " + cols + "): ");
            int colChoice = scanner.nextInt() - 1; // Adjust for 0-based index

            // Check if the seat is available
            if (rowChoice >= 0 && rowChoice < rows && colChoice >= 0 && colChoice < cols) {
                if (seats[rowChoice][colChoice].equals("Available")) {
                    seats[rowChoice][colChoice] = "Reserved";
                    System.out.println("Seat at row " + (rowChoice + 1) + ", column " + (colChoice + 1) + " has been reserved.");
                } else {
                    System.out.println("Sorry, that seat is already reserved.");
                }
            } else {
                System.out.println("Invalid seat choice. Please try again.");
            }

            // Ask if the user wants to reserve another seat
            System.out.print("\nWould you like to reserve another seat? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (response.equals("no")) {
                continueReserving = false;
            }
        }

        // Display final seating arrangement
        System.out.println("\nFinal Cinema Seating Arrangement:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(seats[i][j] + "\t");
            }
            System.out.println();
        }

        scanner.close();
    }
}

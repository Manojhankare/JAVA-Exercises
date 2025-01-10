import java.util.Scanner;

public class ParkingLotFeeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for the number of vehicles
        System.out.print("Enter the number of vehicles: ");
        int numVehicles = scanner.nextInt();

        // Loop through each vehicle to calculate the parking fee
        for (int i = 1; i <= numVehicles; i++) {
            System.out.println("\nVehicle " + i + ":");

            // Get the number of hours parked for the current vehicle
            System.out.print("Enter the number of hours parked: ");
            int hoursParked = scanner.nextInt();

            // Calculate the parking fee based on the fee rules
            double fee = 0.0;
            if (hoursParked <= 5) {
                fee = hoursParked * 2;  // $2 per hour for the first 5 hours
            } else {
                fee = (5 * 2) + ((hoursParked - 5) * 1);  // $2 per hour for the first 5 hours, $1 per hour for additional hours
            }

            // Display the parking fee for the current vehicle
            System.out.println("Parking fee for " + hoursParked + " hours: $" + fee);
        }

        scanner.close();
    }
}

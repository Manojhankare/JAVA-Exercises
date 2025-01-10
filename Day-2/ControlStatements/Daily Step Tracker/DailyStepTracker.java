import java.util.Scanner;

public class DailyStepTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array for days of the week
        String[] daysOfWeek = {
            "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
        };

        // Array to store steps taken for each day
        int[] steps = new int[7];

        int totalSteps = 0;

        // Loop to input steps for each day of the week
        for (int i = 0; i < daysOfWeek.length; i++) {
            System.out.print("Enter the number of steps taken on " + daysOfWeek[i] + ": ");
            steps[i] = scanner.nextInt();
            totalSteps += steps[i];
        }

        // Calculate the average steps
        double averageSteps = totalSteps / (double) daysOfWeek.length;

        // Display the total and average steps
        System.out.println("\nTotal steps taken during the week: " + totalSteps);
        System.out.println("Average steps per day: " + averageSteps);

        scanner.close();
    }
}

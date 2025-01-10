import java.util.Scanner;

public class OnlineExamTimer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Set the exam duration (e.g., 60 minutes)
        System.out.print("Enter the exam duration in minutes: ");
        int examDuration = scanner.nextInt();

        // Convert the exam duration to seconds for countdown
        int remainingTime = examDuration * 60;

        // Countdown loop
        while (remainingTime > 0) {
            // Calculate minutes and seconds
            int minutes = remainingTime / 60;
            int seconds = remainingTime % 60;

            // Display the remaining time every minute
            System.out.println("Time Remaining: " + minutes + " minutes " + seconds + " seconds");

            // Wait for 1 second
            try {
                Thread.sleep(1000);  // Delay for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Decrease the remaining time by 1 second
            remainingTime--;
        }

        // When time is up
        System.out.println("Time is up! The exam has ended.");
        
        scanner.close();
    }
}

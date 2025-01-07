import java.util.Scanner;

public class TrafficLightSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the traffic light color (Green, Yellow, Red): ");
        String lightColor = scanner.nextLine().toLowerCase();
        
        System.out.print("Is there an obstacle? (yes or no): ");
        String obstacle = scanner.nextLine().toLowerCase();
        
        // Check for obstacle
        if (obstacle.equals("yes")) {
            System.out.println("\nYou cannot move because there's an obstacle.");
        } else {
            // Handle traffic light conditions
            switch (lightColor) {
                case "green":
                    System.out.println("\nGo.");
                    break;
                case "yellow":
                    System.out.println("\nSlow Down.");
                    break;
                case "red":
                    System.out.println("\nStop.");
                    break;
                default:
                    System.out.println("\nInvalid traffic light color.");
            }
        }
        scanner.close();
    }
}

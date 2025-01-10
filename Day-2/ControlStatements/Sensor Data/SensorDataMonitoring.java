import java.util.Random;

public class SensorDataMonitoring {
    public static void main(String[] args) {
        int threshold = 75;  
        int readingsCount = 0;
        int highestValue = Integer.MIN_VALUE;
        
        Random random = new Random();
        
        while (true) {
            int sensorValue = random.nextInt(100) + 1;  // Generate random sensor value between 1 and 100
            readingsCount++;
            
            if (sensorValue > highestValue) {
                highestValue = sensorValue;
            }

            System.out.println("Sensor Reading #" + readingsCount + ": " + sensorValue);

            if (sensorValue > threshold) {
                System.out.println("\nThreshold exceeded! Stopping sensor readings.");
                break;
            }
        }
        
        System.out.println("\nTotal readings taken: " + readingsCount);
        System.out.println("Highest value recorded: " + highestValue);
    }
}

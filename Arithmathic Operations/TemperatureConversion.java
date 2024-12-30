import java.util.Scanner;

public class TemperatureConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();
        
        System.out.print("Enter the unit (C for Celsius, F for Fahrenheit): ");
        char unit = scanner.next().charAt(0);
        
        if (unit == 'C' || unit == 'c') {
            // Convert Celsius to Fahrenheit
            double fahrenheit = (temperature * 9/5) + 32;
            System.out.println("\nTemperature in Fahrenheit: " + fahrenheit);
        } else if (unit == 'F' || unit == 'f') {
            // Convert Fahrenheit to Celsius
            double celsius = (temperature - 32) * 5/9;
            System.out.println("\nTemperature in Celsius: " + celsius);
        } else {
            System.out.println("\nInvalid unit entered.");
        }
    }
}

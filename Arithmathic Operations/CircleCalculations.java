import java.util.Scanner;

public class CircleCalculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();
        
        // Constants
        double pi = Math.PI;
        
        // Calculate circumference and area
        double circumference = 2 * pi * radius;
        double area = pi * radius * radius;
        
        System.out.println("\nCircumference of the circle: " + circumference);
        System.out.println("Area of the circle: " + area);
    }
}

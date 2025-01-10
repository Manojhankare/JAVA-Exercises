import java.util.Scanner;

public class StudentGradingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input the number of students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        
        // Variables to store total grade and track failures
        double totalGrades = 0.0;
        boolean hasFailed = false;
        
        // Loop to input grades for each student
        for (int i = 1; i <= numStudents; i++) {
            System.out.print("Enter grade for student " + i + ": ");
            double grade = scanner.nextDouble();
            
            // Check if the grade is below 40
            if (grade < 40) {
                System.out.println("Student " + i + " has failed.");
                hasFailed = true;
            }
            
            // Accumulate total grades for average calculation
            totalGrades += grade;
        }
        
        // Calculate and display the average grade
        double averageGrade = totalGrades / numStudents;
        System.out.printf("The average grade for all students is: %.2f\n", averageGrade);
        
        // Check if any student has failed
        if (!hasFailed) {
            System.out.println("All students have passed.");
        }
        
        scanner.close();
    }
}

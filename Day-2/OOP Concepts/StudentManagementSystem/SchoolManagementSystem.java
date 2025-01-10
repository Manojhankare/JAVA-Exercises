import java.util.Scanner;

class Student {
    // Attributes of the Student class
    private String name;
    private int rollNumber;
    private double[] grades;
    private boolean[] attendance;

    // Constructor to initialize the student details
    public Student(String name, int rollNumber, int numSubjects) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grades = new double[numSubjects];
        this.attendance = new boolean[7]; // Assume 7 days in a week
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.print("Grades: ");
        for (double grade : grades) {
            System.out.print(grade + " ");
        }
        System.out.println();
        System.out.print("Attendance: ");
        for (boolean present : attendance) {
            System.out.print((present ? "Present " : "Absent ") + " ");
        }
        System.out.println();
    }

    // Method to calculate the average grade
    public double calculateAverageGrade() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    // Method to mark attendance for a particular day (0 to 6 for Monday to Sunday)
    public void markAttendance(int day, boolean isPresent) {
        if (day >= 0 && day < attendance.length) {
            attendance[day] = isPresent;
        } else {
            System.out.println("Invalid day. Please enter a day between 0 (Monday) and 6 (Sunday).");
        }
    }

    // Method to set grades for the student (this can be extended to add specific subject grades)
    public void setGrades(double[] grades) {
        this.grades = grades;
    }
}

public class SchoolManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input student details
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();

        System.out.print("Enter number of subjects: ");
        int numSubjects = scanner.nextInt();
        
        // Create a new student object
        Student student = new Student(name, rollNumber, numSubjects);
        
        // Input grades for the student
        double[] grades = new double[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter grade for subject " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
        }
        student.setGrades(grades);

        // Mark attendance for the student
        System.out.println("Mark attendance for the student (Enter 1 for Present and 0 for Absent for each day of the week):");
        for (int i = 0; i < 7; i++) {
            System.out.print("Day " + (i + 1) + " (1 = Present, 0 = Absent): ");
            int attendanceInput = scanner.nextInt();
            student.markAttendance(i, attendanceInput == 1);
        }

        // Display student details
        student.displayStudentDetails();

        // Calculate and display the average grade
        double averageGrade = student.calculateAverageGrade();
        System.out.println("Average Grade: " + averageGrade);

        // Closing the scanner
        scanner.close();
    }
}

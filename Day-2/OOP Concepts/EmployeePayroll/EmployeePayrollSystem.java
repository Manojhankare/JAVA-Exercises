
class Employee {
    private String name;
    private String id;
    private String designation;
    private double basicSalary;

    // Constructor to initialize employee details
    public Employee(String name, String id, String designation, double basicSalary) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        this.basicSalary = basicSalary;
    }

    // Method to calculate salary (Base class method)
    public double calculateSalary() {
        return basicSalary;
    }

    // Getter methods for employee details
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Designation: " + designation);
        System.out.println("Basic Salary: $" + basicSalary);
    }
}

class FullTimeEmployee extends Employee {
    private double hra; // House Rent Allowance
    private double da;  // Dearness Allowance

    // Constructor to initialize FullTimeEmployee details
    public FullTimeEmployee(String name, String id, String designation, double basicSalary, double hra, double da) {
        super(name, id, designation, basicSalary);
        this.hra = hra;
        this.da = da;
    }

    @Override
    public double calculateSalary() {
        double grossSalary = getBasicSalary() + hra + da;
        return grossSalary;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("HRA: $" + hra);
        System.out.println("DA: $" + da);
    }
}


class PartTimeEmployee extends Employee {
    private double hourlyWage;
    private int hoursWorked;

    public PartTimeEmployee(String name, String id, String designation, double hourlyWage, int hoursWorked) {
        super(name, id, designation, 0); 
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyWage * hoursWorked;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Hourly Wage: $" + hourlyWage);
        System.out.println("Hours Worked: " + hoursWorked);
    }
}

public class EmployeePayrollSystem {
    public static void main(String[] args) {
        
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("John Doe", "FT123", "Software Engineer", 5000, 1000, 500);
        
        
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("Jane Smith", "PT456", "Content Writer", 20, 100);

        
        System.out.println("Full-Time Employee Details:");
        fullTimeEmployee.displayDetails();
        System.out.println("Total Salary: $" + fullTimeEmployee.calculateSalary());

        System.out.println("\n------------------------------------\n");

        System.out.println("Part-Time Employee Details:");
        partTimeEmployee.displayDetails();
        System.out.println("Total Salary: $" + partTimeEmployee.calculateSalary());
    }
}

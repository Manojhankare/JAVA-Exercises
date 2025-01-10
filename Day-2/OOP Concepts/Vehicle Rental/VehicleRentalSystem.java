
class Vehicle {
    private String vehicleType;
    private String numberPlate;
    private double rentalPricePerDay;

    
    public Vehicle(String vehicleType, String numberPlate, double rentalPricePerDay) {
        this.vehicleType = vehicleType;
        this.numberPlate = numberPlate;
        this.rentalPricePerDay = rentalPricePerDay;
    }

    
    public double calculateRentalCost(int daysRented) {
        return rentalPricePerDay * daysRented;
    }

    
    public String getVehicleType() {
        return vehicleType;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public void displayDetails() {
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Number Plate: " + numberPlate);
        System.out.println("Rental Price per Day: $" + rentalPricePerDay);
    }
}


class Car extends Vehicle {
    private int numberOfDoors;

    
    public Car(String numberPlate, double rentalPricePerDay, int numberOfDoors) {
        super("Car", numberPlate, rentalPricePerDay);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Doors: " + numberOfDoors);
    }
}


class Bike extends Vehicle {
    private boolean hasSideCar;

    
    public Bike(String numberPlate, double rentalPricePerDay, boolean hasSideCar) {
        super("Bike", numberPlate, rentalPricePerDay);
        this.hasSideCar = hasSideCar;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Has Side Car: " + (hasSideCar ? "Yes" : "No"));
    }
}


class Truck extends Vehicle {
    private double loadCapacity;

    
    public Truck(String numberPlate, double rentalPricePerDay, double loadCapacity) {
        super("Truck", numberPlate, rentalPricePerDay);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}


public class VehicleRentalSystem {
    public static void main(String[] args) {
        
        Vehicle car = new Car("ABC123", 50, 4); // Car with 4 doors
        Vehicle bike = new Bike("XYZ456", 20, true); // Bike with a sidecar
        Vehicle truck = new Truck("LMN789", 100, 10); // Truck with 10 tons capacity

        
        int daysRentedCar = 5;
        int daysRentedBike = 3;
        int daysRentedTruck = 7;
        
        System.out.println("Car Rental Details:");
        car.displayDetails();
        System.out.println("Total Rental Cost for " + daysRentedCar + " days: $" + car.calculateRentalCost(daysRentedCar));

        System.out.println("\n----------------------------------------\n");

        
        System.out.println("Bike Rental Details:");
        bike.displayDetails();
        System.out.println("Total Rental Cost for " + daysRentedBike + " days: $" + bike.calculateRentalCost(daysRentedBike));

        System.out.println("\n----------------------------------------\n");

        
        System.out.println("Truck Rental Details:");
        truck.displayDetails();
        System.out.println("Total Rental Cost for " + daysRentedTruck + " days: $" + truck.calculateRentalCost(daysRentedTruck));
    }
}

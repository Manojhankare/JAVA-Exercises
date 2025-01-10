import java.util.Scanner;

class Room {
    private int roomNumber;
    private String roomType;
    private boolean isAvailable;
    private double pricePerNight;

    // Constructor to initialize room details
    public Room(int roomNumber, String roomType, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isAvailable = true;  // Initially, the room is available
        this.pricePerNight = pricePerNight;
    }

    // Method to book the room
    public void bookRoom() {
        if (isAvailable) {
            isAvailable = false; // Mark the room as booked
            System.out.println("Room " + roomNumber + " has been successfully booked.");
        } else {
            System.out.println("Room " + roomNumber + " is not available.");
        }
    }

    // Method to check room availability
    public boolean checkAvailability() {
        return isAvailable;
    }

    // Method to calculate total charges for the room based on the number of nights
    public double calculateTotalCharges(int numberOfNights) {
        return numberOfNights * pricePerNight;
    }

    // Getter methods
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }
}

// Hotel class to manage room bookings and room availability
class Hotel {
    private Room[] rooms;  // Array of rooms in the hotel

    // Constructor to initialize hotel with a set number of rooms
    public Hotel(int numberOfRooms) {
        rooms = new Room[numberOfRooms];
    }

    // Method to add a room to the hotel
    public void addRoom(int roomNumber, String roomType, double pricePerNight) {
        rooms[roomNumber - 1] = new Room(roomNumber, roomType, pricePerNight);
    }

    // Method to check and display available rooms
    public void displayAvailableRooms() {
        boolean anyAvailable = false;
        System.out.println("Available rooms:");
        for (Room room : rooms) {
            if (room != null && room.checkAvailability()) {
                System.out.println("Room Number: " + room.getRoomNumber() + ", Type: " + room.getRoomType() +
                        ", Price per Night: $" + room.getPricePerNight());
                anyAvailable = true;
            }
        }
        if (!anyAvailable) {
            System.out.println("No rooms available at the moment.");
        }
    }

    // Method to book a room by room number
    public void bookRoom(int roomNumber) {
        if (roomNumber > 0 && roomNumber <= rooms.length && rooms[roomNumber - 1] != null) {
            rooms[roomNumber - 1].bookRoom();
        } else {
            System.out.println("Invalid room number.");
        }
    }

    // Method to calculate the total charges for a room booking
    public double calculateTotalCharges(int roomNumber, int numberOfNights) {
        if (roomNumber > 0 && roomNumber <= rooms.length && rooms[roomNumber - 1] != null) {
            return rooms[roomNumber - 1].calculateTotalCharges(numberOfNights);
        } else {
            System.out.println("Invalid room number.");
            return 0;
        }
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a hotel with 5 rooms
        Hotel hotel = new Hotel(5);

        // Add rooms to the hotel
        hotel.addRoom(1, "Single", 100.0);
        hotel.addRoom(2, "Double", 150.0);
        hotel.addRoom(3, "Suite", 250.0);
        hotel.addRoom(4, "Single", 100.0);
        hotel.addRoom(5, "Double", 150.0);

        while (true) {
            System.out.println("\nWelcome to the Hotel Reservation System");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Calculate Total Charges");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    hotel.displayAvailableRooms();  // Display available rooms
                    break;

                case 2:
                    System.out.print("Enter room number to book: ");
                    int roomNumber = scanner.nextInt();
                    hotel.bookRoom(roomNumber);  // Book the selected room
                    break;

                case 3:
                    System.out.print("Enter room number to calculate total charges: ");
                    roomNumber = scanner.nextInt();
                    System.out.print("Enter number of nights: ");
                    int nights = scanner.nextInt();
                    double totalCharges = hotel.calculateTotalCharges(roomNumber, nights);
                    if (totalCharges > 0) {
                        System.out.println("Total charges for room " + roomNumber + " for " + nights + " nights: $" + totalCharges);
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

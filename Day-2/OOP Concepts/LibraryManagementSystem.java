import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean availability;  
    
    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.availability = true;
    }

    public void borrowBook() {
        if (availability) {
            availability = false;
            System.out.println("You have successfully borrowed: " + title);
        } else {
            System.out.println("Sorry, the book is currently unavailable.");
        }
    }

    public void returnBook() {
        if (!availability) {
            availability = true;
            System.out.println("You have successfully returned: " + title);
        } else {
            System.out.println("This book was not borrowed.");
        }
    }

    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Availability: " + (availability ? "Available" : "Borrowed"));
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return availability;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }
    
    public void addBook(Book book) {
        books.add(book);
    }

    
    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.borrowBook();
                return;
            }
        }
        System.out.println("Book with title \"" + title + "\" not found.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Book with title \"" + title + "\" not found.");
    }

    
    public void displayAvailableBooks() {
        boolean found = false;
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                book.displayBookDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available books in the library.");
        }
    }

    
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("\nAll Books in the Library:");
        for (Book book : books) {
            book.displayBookDetails();
            System.out.println("---------");
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        Library library = new Library();

        
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084"));
        library.addBook(new Book("1984", "George Orwell", "978-0451524935"));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565"));
        library.addBook(new Book("Great Minds", "Herman Melville", "978-1503280786"));

        boolean running = true;

        while (running) {
            
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display all books");
            System.out.println("2. Display available books");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    library.displayAllBooks();
                    break;
                case 2:
                    library.displayAvailableBooks();
                    break;
                case 3:
                    System.out.print("Enter the title of the book you want to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    library.borrowBook(borrowTitle);
                    break;
                case 4:
                    System.out.print("Enter the title of the book you want to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 5:
                    System.out.println("Exiting the system...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

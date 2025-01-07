import java.util.Scanner;

public class SearchElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the element to search for: ");
        int target = scanner.nextInt();
        
        int position = -1; // Default if not found
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                position = i;
                break;
            }
        }
        
        if (position == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Element found at position: " + position);
        }
        
        scanner.close();
    }
}

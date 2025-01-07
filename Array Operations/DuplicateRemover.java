import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        Set<Integer> uniqueElements = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            uniqueElements.add(arr[i]);
        }
        
        System.out.println("Array without duplicates: " + uniqueElements);
        
        scanner.close();
    }
}

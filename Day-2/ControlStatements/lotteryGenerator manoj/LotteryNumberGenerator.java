import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class LotteryNumberGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of lottery numbers to generate: ");
        int n = scanner.nextInt();
        
        int minNumber = 1;
        int maxNumber = 50;

        HashSet<Integer> lotteryNumbers = new HashSet<>();
        
        Random random = new Random();

        while (lotteryNumbers.size() < n) {
            int number = random.nextInt(maxNumber - minNumber + 1) + minNumber;
            lotteryNumbers.add(number);
        }

        System.out.println("\nGenerated Lottery Numbers:");
        for (int number : lotteryNumbers) {
            System.out.print(number + " ");
        }

        scanner.close();
    }
}

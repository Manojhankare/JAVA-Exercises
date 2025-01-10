import java.util.Scanner;

public class QuizApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array of questions and correct answers
        String[] questions = {
            "What is the capital of France?",
            "What is 2 + 2?",
            "Which planet is known as the Red Planet?",
            "What is the largest ocean on Earth?"
        };

        String[] answers = {
            "Paris",
            "4",
            "Mars",
            "Pacific"
        };

        // Variable to track the score
        int score = 0;

        // Iterate through the questions
        for (int i = 0; i < questions.length; i++) {
            System.out.println((i + 1) + ". " + questions[i]);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            // Check if the answer is correct
            if (userAnswer.equalsIgnoreCase(answers[i])) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is: " + answers[i]);
            }
            System.out.println(); // Empty line for readability
        }

        // Display the score
        System.out.println("Your total score: " + score + "/" + questions.length);

        scanner.close();
    }
}

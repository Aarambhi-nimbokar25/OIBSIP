import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        char playAgain;
        do {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 5;
            int guess;
            boolean guessedCorrectly = false;
            System.out.println("\n=== Number Guessing Game ===");
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have 5 attempts!");
            for (int i = 1; i <= attempts; i++) {
                System.out.print("Attempt " + i + ": ");
                guess = sc.nextInt();
                if (guess == numberToGuess) {
                    System.out.println("Correct! You guessed the number.");
                    totalScore += (attempts - i + 1) * 10; // scoring logic
                    guessedCorrectly = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too Low!");
                } else {
                    System.out.println("Too High!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! The number was: " + numberToGuess);
            }

            System.out.println("Your Total Score: " + totalScore);

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("Thank you for playing!");
        sc.close();
    }
}
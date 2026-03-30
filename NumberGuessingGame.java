import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalScore = 0;
        int rounds = 0;

        System.out.println("🎮 Welcome to Number Guessing Game!");

        while (true) {
            rounds++;
            int numberToGuess = rand.nextInt(100) + 1; 
            int attempts = 0;
            int maxAttempts = 5;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + rounds);
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println(" Correct! You guessed the number!");
                    guessedCorrectly = true;

                    int roundScore = (maxAttempts - attempts + 1) * 10;
                    totalScore += roundScore;

                    System.out.println("Score for this round: " + roundScore);
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println(" Too low!");
                } else {
                    System.out.println(" Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println(" Out of attempts! The number was: " + numberToGuess);
            }

            System.out.println("Total Score: " + totalScore);

           System.out.print("Do you want to play another round? (yes/no): ");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("\n Game Over!");
        System.out.println("Total Rounds Played: " + rounds);
        System.out.println("Final Score: " + totalScore);

        sc.close();
    }
}

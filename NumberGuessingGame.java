package project;
import java.util.*;
				// Task - 1 "Number Game"
public class NumberGuessingGame {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int score = 0;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfAttempts = 0;
            int maxAttempts = 10;
            boolean hasGuessedCorrectly = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have generated a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            while (numberOfAttempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfAttempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the correct number!");
                    hasGuessedCorrectly = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                System.out.println("Attempts left: " + (maxAttempts - numberOfAttempts));
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all attempts. The number was " + numberToGuess + ".");
            } else {
                score += (maxAttempts - numberOfAttempts);
            }

            System.out.println("Your current score: " + score);

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Your final score is " + score + ".");
        scanner.close();
    }
}

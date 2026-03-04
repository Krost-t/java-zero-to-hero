import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int secretNumber = ThreadLocalRandom.current().nextInt(-100, 100 + 1);
        int chances = 10;

        System.out.println("Welcome to the Guess Game!");
        System.out.println("You have " + chances + " chances to find the secret number between " + -100 + " and " + 100 + ".");
        System.out.println("After each guess, you'll get a hint to help you.");

        for (int i = 1; i <= chances; i++) {
            System.out.println("\nAttempt " + i + " / " + chances);
            System.out.print("Enter your guess: ");

            int guess = scanner.nextInt();

            if (guess == secretNumber) {
                System.out.println("Congratulations! You found the secret number!");
                scanner.close();
                return;
            }


            int diff = guess - secretNumber;
            if (diff > 20) {
                System.out.println(" X Much too high!");
            } else if (diff > 5) {
                System.out.println(" X Too high!");
            } else if (diff < -20) {
                System.out.println(" X Much too low!");
            } else if (diff < -5) {
                System.out.println(" X Too low!");
            } else {
                System.out.println(" X Close!");
            }

            System.out.println("Chances left: " + (chances - i));
        }

        System.out.println("\nGame Over! The secret number was: " + secretNumber);
        scanner.close();
    }
}
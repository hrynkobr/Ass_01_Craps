import java.util.Random;
import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        boolean playAgain;

        do {
            int die1 = rand.nextInt(6) + 1; // Roll first die (1-6)
            int die2 = rand.nextInt(6) + 1; // Roll second die (1-6)
            int sum = die1 + die2;
            System.out.printf("You rolled: %d + %d = %d\n", die1, die2, sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            } else {
                int point = sum;
                System.out.printf("The point is now: %d\n", point);
                boolean rolling = true;
                while (rolling) {
                    die1 = rand.nextInt(6) + 1; // Roll first die (1-6)
                    die2 = rand.nextInt(6) + 1; // Roll second die (1-6)
                    sum = die1 + die2;
                    System.out.printf("You rolled: %d + %d = %d\n", die1, die2, sum);
                    if (sum == point) {
                        System.out.println("You made the point! You win.");
                        rolling = false;
                    } else if (sum == 7) {
                        System.out.println("Got a seven! You lose.");
                        rolling = false;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            playAgain = getYNConfirm(in, "Do you want to play again?");
        } while (playAgain);

        System.out.println("Thanks for playing!");
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response;
        boolean validInput = false;
        boolean result = false;
        do {
            System.out.print(prompt + " [y/n]: ");
            response = pipe.nextLine().trim().toLowerCase();
            if (response.equals("y")) {
                validInput = true;
                result = true;
            } else if (response.equals("n")) {
                validInput = true;
                result = false;
            } else {
                System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
            }
        } while (!validInput);
        return result;
    }
}
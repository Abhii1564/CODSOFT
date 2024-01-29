import java.util.*;

public class Number_game {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("Welcome to the Number guessing Game :) ");
            System.out.println(
                    "I have guessed one number between " + minRange + "&" + maxRange + "Try To Gussing Same Number!");

            int attempts = 0;
            while (attempts < maxAttempts) {
                System.out.println("Enter Your Number :) ");
                int userguess = scanner.nextInt();
                attempts++;
                if (userguess < targetNumber) {
                    System.out.println("Too low (: Plz Try Again.");
                } else if (userguess > targetNumber) {
                    System.out.println("Too high (: Plz Try Again.");
                } else {
                    System.out.println(
                            "Ohh Congratulations user you did it you guessed the number " + targetNumber + "in"
                                    + attempts);
                    score += maxAttempts - attempts + 1;
                    break;
                }
            }
            if (attempts == maxAttempts) {
                System.out.println("Sorry (: user  you reached the maximum numbers of attempts. the right number is ");
            }
            System.out.println("Do you want play again ? (yes/no): ");
            String playAgainRespons = scanner.next().toLowerCase();
            scanner.close();
            playAgain = playAgainRespons.equals("Yes");
        }
        System.out.println("Thanks for playing  the number gussing game & your total score is :" + score);
    }
}
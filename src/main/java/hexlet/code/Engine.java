package hexlet.code;
import java.util.Scanner;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Greet;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import hexlet.code.games.Calculator;

public class Engine {
    public static void gameManagement() {
        Scanner words = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calculator");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        String choice = (words.nextLine());
        System.out.println("Your choice: " + choice);

        switch (choice) {
            case "0":
                System.out.println("Goodbye!");
                break;
            case "1":
                Greet.getGreet();
                break;
            case "2":
                Even.guessEvenOrOddNumber();
                break;
            case "3":
                Calculator.calculation();
                break;
            case "4":
                GCD.findGreatestCommonDivisor();
                break;
            case "5":
                Progression.arithmeticProgressionNumbers();
                break;
            case "6":
                Prime.primeNumber();
                break;
            default:
                System.out.println("You have entered a number outside the range.");
        }

    }
}

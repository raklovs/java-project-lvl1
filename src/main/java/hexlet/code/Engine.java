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
        Greet.getGreet();

        switch (choice) {
            case "0" -> System.out.println("Goodbye!");
            case "1" -> Greet.getGreet();
            case "2" -> {

                System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
                Even.guessEvenOrOddNumber();
            }
            case "3" -> {

                System.out.println("What is the result of the expression?");
                Calculator.calculation();
            }
            case "4" -> {

                System.out.println("Find the greatest common divisor of given numbers.");
                GCD.findGreatestCommonDivisor();
            }
            case "5" -> {

                System.out.println("What number is missing in the progression?");
                Progression.arithmeticProgressionNumbers();
            }
            case "6" -> {

                System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
                Prime.primeNumber();
            }
            default -> System.out.println("You have entered a number outside the range.");
        }

    }


    private static String getAnswer;
    public static final int NUMBER_OF_QUESTION = 3;

    public static String getAnswer() {
        return getAnswer;
    }

    public static void yourAnswer() {
        Scanner words = new Scanner(System.in);
        getAnswer = words.nextLine();
        System.out.println("Your answer: " + getAnswer);
    }

    public static void congratulations() {
        System.out.println("Congratulations, " + Greet.getName() + "!");
    }
}

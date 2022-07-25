package hexlet.code.games;

import java.util.Scanner;

public class Prime {

    private static boolean isPrime(final int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void primeNumber() {
        Scanner words = new Scanner(System.in);
        Greet.getGreet();
        String getName = Greet.getName();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        var count = 0;
        final var multiplier1 = 10;
        final int numberOfQuestions = 3;

        for (var i = 0; i < numberOfQuestions; i++) {
            int randomNumber = (int) (Math.random() * multiplier1) + 1;
            System.out.println("Question: " + randomNumber);
            String result = "";

            boolean isPrime = isPrime(randomNumber);
            Scanner answerScan = new Scanner(System.in);
            String answer = answerScan.nextLine();
            System.out.println("Your answer: " + answer);

            if (isPrime) {
                result = "yes";
            } else {
                result = "no";
            }

            if (isPrime && answer.equals("yes")) {
                System.out.println("Correct!");
                result = "yes";
                count++;
            } else if (!isPrime && answer.equals("no")) {
                System.out.println("Correct!");
                result = "no";
                count++;
            } else {
                System.out.println(answer + " is wrong answer ;(. Correct answer was " + result + ".");
                System.out.println("Let's try again, " + getName + "!");
                break;
            }

        }
        if (count == numberOfQuestions) {
            System.out.println("Congratulations, " + getName + "!");
        }
    }
}

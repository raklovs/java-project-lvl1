package hexlet.code.games;

import java.util.Scanner;

public class GCD {

    public static int algorithmGreatestCommonDivisor(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        }
        return algorithmGreatestCommonDivisor(number2, number1 % number2);
    }

    public static void findGreatestCommonDivisor() {
        Scanner words = new Scanner(System.in);
        Greet.getGreet();
        String getName = Greet.getName();

        System.out.println("Find the greatest common divisor of given numbers.");
        var count = 0;
        final var multiplier = 100;
        final int numberOfQuestions = 3;

        for (int i = 0; i < numberOfQuestions; i++) {
            var randomNumber1 = (int) (multiplier * Math.random());
            var randomNumber2 = (int) (multiplier * Math.random());
            var answer = GCD.algorithmGreatestCommonDivisor(randomNumber1, randomNumber2);

            System.out.println("Question: " + randomNumber1 + " " + randomNumber2);
            String choice = words.nextLine();
            System.out.println("Your answer: " + choice);

            if (String.valueOf(answer).equals(choice)) {
                System.out.println("Correct!");
                count++;
            } else {
                System.out.println(choice + " is wrong answer ;(. Correct answer was " + answer + ".");
                System.out.println("Let's try again, " + getName + "!");
                break;
            }

        }
        if (count == numberOfQuestions) {
            System.out.println("Congratulations, " + getName + "!");
        }

    }
}

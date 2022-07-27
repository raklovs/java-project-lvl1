package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {

    public static int algorithmGreatestCommonDivisor(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        }
        return algorithmGreatestCommonDivisor(number2, number1 % number2);
    }

    public static void findGreatestCommonDivisor() {

        Greet.getGreet();
        System.out.println("Find the greatest common divisor of given numbers.");
        final var multiplier = 100;

        for (int i = 0; i < Engine.NUMBER_OF_QUESTION; i++) {
            var randomNumber1 = (int) (multiplier * Math.random());
            var randomNumber2 = (int) (multiplier * Math.random());
            var answer = GCD.algorithmGreatestCommonDivisor(randomNumber1, randomNumber2);

            System.out.println("Question: " + randomNumber1 + " " + randomNumber2);
            Engine.yourAnswer();

            if (String.valueOf(answer).equals(Engine.getAnswer())) {
                System.out.println("Correct!");
            } else {
                System.out.println(Engine.getAnswer() + " is wrong answer ;(. Correct answer was " + answer + ".");
                System.out.println("Let's try again, " + Greet.getName() + "!");
                break;
            }

        }
        Engine.congratulations();
    }
}

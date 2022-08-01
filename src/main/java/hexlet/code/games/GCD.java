package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {

    static final int MULTIPLIER = 100;

    public static int algorithmGreatestCommonDivisor(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        }
        return algorithmGreatestCommonDivisor(number2, number1 % number2);
    }

    public static void findGreatestCommonDivisor() {
        String[][] response = new String[Engine.NUMBER_OF_QUESTION][2];
        String question = "Find the greatest common divisor of given numbers.";

        for (int i = 0; i < Engine.NUMBER_OF_QUESTION; i++) {
            var randomNumber1 = (int) (MULTIPLIER * Math.random());
            var randomNumber2 = (int) (MULTIPLIER * Math.random());
            var answer = GCD.algorithmGreatestCommonDivisor(randomNumber1, randomNumber2);

            response[i][0] = randomNumber1 + " " + randomNumber2;
            response[i][1] = Integer.toString(answer);
        }
        Engine.gameManagement(question, response);
    }
}

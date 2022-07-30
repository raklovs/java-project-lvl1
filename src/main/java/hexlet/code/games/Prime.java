package hexlet.code.games;

import hexlet.code.Engine;

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

        String[][] response = new String[Engine.NUMBER_OF_QUESTION][2];
        String question = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        final var multiplier = 10;

        for (int i = 0; i < Engine.NUMBER_OF_QUESTION; i++) {
            int randomNumber = (int) (Math.random() * multiplier) + 1;
            response[i][0] = Integer.toString(randomNumber);
            response[i][1] = isPrime(randomNumber) ? "yes" : "no";
        }
        Engine.gameManagement(question, response);
    }
}

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

        final var multiplier = 10;
        String result;
        int i;

        for (i = 0; i < Engine.NUMBER_OF_QUESTION; i++) {
            int randomNumber = (int) (Math.random() * multiplier) + 1;
            System.out.println("Question: " + randomNumber);

            boolean isPrime = isPrime(randomNumber);
            Engine.yourAnswer();

            if (isPrime) {
                result = "yes";
            } else {
                result = "no";
            }

            if (isPrime && Engine.getAnswer().equals("yes")) {
                System.out.println("Correct!");
            } else if (!isPrime && Engine.getAnswer().equals("no")) {
                System.out.println("Correct!");
            } else {
                System.out.println(Engine.getAnswer() + " is wrong answer ;(. Correct answer was " + result + ".");
                System.out.println("Let's try again, " + Greet.getName() + "!");
                break;
            }

        }
        if (i == Engine.NUMBER_OF_QUESTION) {
            Engine.congratulations();
        }
    }
}

package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    public static void guessEvenOrOddNumber() {

        Greet.getGreet();
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
        final var multiplier = 17;

        for (int i = 0; i < Engine.NUMBER_OF_QUESTION; i++) {
            var randomNumber = (int) (multiplier * Math.random());
            System.out.println("Question: " + randomNumber);
            Engine.yourAnswer();

            if (randomNumber % 2 == 0 && Engine.getAnswer().equals("yes")) {
                System.out.println("Correct!");

            } else if (randomNumber % 2 != 0 && Engine.getAnswer().equals("no")) {
                System.out.println("Correct!");

            } else if (randomNumber % 2 == 0 && !Engine.getAnswer().equals("no")) {
                System.out.println("'" + Engine.getAnswer() + "'" + " is wrong answer ;(. Correct answer was 'yes'.");
                System.out.println("Let's try again, " + Greet.getName() + "!");
                break;

            } else {
                System.out.println("'" + Engine.getAnswer() + "'" + " is wrong answer ;(. Correct answer was 'no'.");
                System.out.println("Let's try again, " + Greet.getName() + "!");
                break;
            }
        }
        Engine.congratulations();
    }
}

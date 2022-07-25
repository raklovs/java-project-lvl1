package hexlet.code.games;

import java.util.Scanner;

public class Even {
    public static void guessEvenOrOddNumber() {
        Scanner words = new Scanner(System.in);
        Greet.getGreet();
        String getName = Greet.getName();

        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
        var count = 0;
        final var numberOfQuestions = 3;
        final var multiplier = 17;

        for (int i = 0; i < numberOfQuestions; i++) {
            var randomNumber = (int) (multiplier * Math.random());
            System.out.println("Question: " + randomNumber);
            var answer = words.nextLine();
            if (randomNumber % 2 == 0 && answer.equalsIgnoreCase("yes")) {
                System.out.println("Correct!");
                count += 1;

            } else if (randomNumber % 2 != 0 && answer.equalsIgnoreCase("no")) {
                System.out.println("Correct!");
                count += 1;

            } else if (randomNumber % 2 == 0 && !answer.equals("yes")) {
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was 'yes'.");
                System.out.println("Let's try again, " + getName + "!");
                break;

            } else {
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was 'no'.");
                System.out.println("Let's try again, " + getName + "!");
                break;
            }
        }
        if (count == numberOfQuestions) {
            System.out.println("Congratulations, " + getName + "!");
        }
    }
}

package hexlet.code.games;

import java.util.Scanner;

public class Even {
    public static void GuessEvenOrOddNumber() {
        Scanner words = new Scanner(System.in);
        Greet.getGreet();
        String getName = Greet.name;

        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
        var count = 0;

        for (int i = 0; i < 3; i++) {
            var rand = (int) (17 * Math.random());
            System.out.println("Question: " + rand);
            var answer = words.nextLine();
            if (rand % 2 == 0 && answer.equalsIgnoreCase("yes")) {
                System.out.println("Correct!");
                count += 1;

            } else if (rand % 2 != 0 && answer.equalsIgnoreCase("no")) {
                System.out.println("Correct!");
                count += 1;
            } else if (rand % 2 == 0 && !answer.equals("yes")) {
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was 'yes'.");
                System.out.println("Let's try again, " + getName + "!");
                break;
            } else {
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was 'no'.");
                System.out.println("Let's try again, " + getName + "!");
                break;
            }
        }
        if (count == 3) {
            System.out.println("Congratulations, " + getName + "!");
        }
    }
}
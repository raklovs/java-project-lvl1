package hexlet.code.games;

import java.util.Arrays;
import java.util.Scanner;

public class Progression {

    public static void arithmeticProgressionNumbers() {

        Scanner words = new Scanner(System.in);
        Greet.getGreet();
        String getName = Greet.getName();
        System.out.println("What number is missing in the progression?");
        var count = 0;
        final var multiplier1 = 10;
        final var multiplier2 = 5;
        final var multiplier3 = 9;
        final int numberOfQuestions = 3;

        for (var i = 0; i < numberOfQuestions; i++) {
            var beginNumber = (int) (multiplier1 * Math.random() - 1);
            var stepNumber = (int) (multiplier2 * Math.random() + 1);
            final var arrayLength = 10;
            int[] progression = new int[arrayLength];
            String[] arrayOfString = new String[progression.length];
            int rezult = beginNumber;
            String replacement = "..";
            int randomReplacement = ((int) (multiplier3 * Math.random()));
            int randomChoice = 0;

            for (int j = 0; j < progression.length; j++) {
                progression[j] = rezult;
                rezult = rezult + stepNumber;
                arrayOfString[j] = String.valueOf(progression[j]);
                if (j == randomReplacement) {
                    arrayOfString[j] = replacement;
                    randomChoice = progression[j];
                }
            }
            String arraysNumbers = Arrays.toString(arrayOfString);
            System.out.println("Question: " + arraysNumbers.replaceAll(",", "").replace("[", "").replace("]", ""));
            String choice = words.nextLine();
            System.out.println("Your answer: " + choice);

            if (String.valueOf(randomChoice).equals(choice)) {
                System.out.println("Correct!");
                count++;
            } else {
                System.out.println(choice + " is wrong answer ;(. Correct answer was " + randomChoice + ".");
                System.out.println("Let's try again, " + getName + "!");
                break;
            }

        }

        if (count == numberOfQuestions) {
            System.out.println("Congratulations, " + getName + "!");
        }
    }
}

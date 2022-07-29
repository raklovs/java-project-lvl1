package hexlet.code.games;

import java.util.Arrays;

import hexlet.code.Engine;

public class Progression {

    public static void arithmeticProgressionNumbers() {

        final var multiplier1 = 10;
        final var multiplier2 = 5;
        final var multiplier3 = 9;
        int i;

        for (i = 0; i < Engine.NUMBER_OF_QUESTION; i++) {
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
            Engine.yourAnswer();

            if (String.valueOf(randomChoice).equals(Engine.getAnswer())) {
                System.out.println("Correct!");
            } else {
                System.out.println(Engine.getAnswer() + " is wrong answer ;(.");
                System.out.println("Correct answer was " + randomChoice + ".");
                System.out.println("Let's try again, " + Greet.getName() + "!");
                break;
            }

        }
        if (i == Engine.NUMBER_OF_QUESTION) {
            Engine.congratulations();
        }
    }
}

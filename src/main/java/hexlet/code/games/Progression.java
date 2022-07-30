package hexlet.code.games;

import java.util.Arrays;

import hexlet.code.Engine;

public class Progression {

    public static void arithmeticProgressionNumbers() {
        String[][] response = new String[Engine.NUMBER_OF_QUESTION][2];
        String question = "What number is missing in the progression?";

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
            response[i][0] = arraysNumbers.replaceAll(",", "").replace("[", "").replace("]", " ");
            response[i][1] = Integer.toString(randomChoice);
        }
        Engine.gameManagement(question, response);
    }
}

package hexlet.code.games;

import java.util.Arrays;
import java.util.Scanner;

public class Progression {

    public static void arithmeticProgressionNumbers() {

        Scanner words = new Scanner(System.in);
        Greet.getGreet();
        String getName = Greet.name;
        System.out.println("What number is missing in the progression?");
        var count = 0;

        for (var i = 0; i < 3; i++) {
            var beginNumber = (int) (10 * Math.random() - 1);
            var stepNumber = (int) (5 * Math.random() + 1);
            int[] progression = new int[10];
            String[] arrayOfString = new String[progression.length];
            int rezult = beginNumber;
            String replacement = "..";
            int randomReplacement = ((int) (9 * Math.random()));
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

        if (count == 3) {
            System.out.println("Congratulations, " + getName + "!");
        }
    }
}

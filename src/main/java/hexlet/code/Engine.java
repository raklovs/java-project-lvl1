package hexlet.code;

import java.util.Scanner;

import hexlet.code.games.Greet;

public class Engine {

    public static final int NUMBER_OF_QUESTION = 3;

    public static void gameManagement(String question, String[][] response) {
        Greet.getGreet();
        System.out.println(question);
        int i;
        for (i = 0; i < NUMBER_OF_QUESTION; i++) {
            System.out.println("Question: " + response[i][0]);
            System.out.print("Your answer: ");
            String text = yourAnswer();
            if (text.equals(response[i][1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + text + "'" + " is wrong answer ;(. Correct answer was '"
                        + response[i][1] + "'.");
                System.out.println("Let's try again, " + Greet.getName() + "!");
                return;
            }
        }
        if (i == NUMBER_OF_QUESTION) {
            System.out.println("Congratulations, " + Greet.getName() + "!");
        }

    }


    public static String yourAnswer() {
        Scanner words = new Scanner(System.in);
        return words.next();
    }

}

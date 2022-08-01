package hexlet.code;

import java.util.Scanner;

import java.util.Random;

public class Engine {

    public static final int NUMBER_OF_QUESTION = 3;
    public static final int MAX_NUMBER = 40;

    public static void gameManagement(String question, String[][] response) {

        Scanner words = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String name = words.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println(question);

        for (int i = 0; i < NUMBER_OF_QUESTION; i++) {
            System.out.println("Question: " + response[i][0]);
            System.out.print("Your answer: ");
            String text = yourAnswer();
            if (text.equals(response[i][1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + text + "'" + " is wrong answer ;(. Correct answer was '"
                        + response[i][1] + "'.");
                System.out.println("Let's try again, " + name + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + name + "!");
    }


    public static String yourAnswer() {
        Scanner words = new Scanner(System.in);
        return words.next();
    }

    public static int getRandom(int max) {
        final Random random = new Random();
        return random.nextInt(max);
    }

}

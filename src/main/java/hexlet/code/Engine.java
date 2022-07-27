package hexlet.code;


import hexlet.code.games.Greet;

import java.util.Scanner;

public class Engine {

    private static String getAnswer;
    public static final int NUMBER_OF_QUESTION = 3;

    public static String getAnswer() {
        return getAnswer;
    }

    public static void yourAnswer() {
        Scanner words = new Scanner(System.in);
        getAnswer = words.nextLine();
        System.out.println("Your answer: " + getAnswer);
    }

    public static void congratulations() {
        System.out.println("Congratulations, " + Greet.getName() + "!");
    }
}

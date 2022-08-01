package hexlet.code.games;

import java.util.Scanner;

public class Greet {

    public static void getGreet() {
        Scanner words = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String name = words.nextLine();
        System.out.println("Hello, " + name + "!");
    }
}

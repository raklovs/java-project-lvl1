package hexlet.code;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner words = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n2 - Even\n0 - Exit");
        String choice = words.nextLine();
        System.out.println("Your choice: " + choice);

        switch (choice) {
            case "1":
                System.out.println("Welcome to the Brain Games!");
                System.out.println("May I have your name?");
                String name1 = words.nextLine();
                System.out.println("Hello, " + name1 + "!");
                break;
            case "2":
                System.out.println("Welcome to the Brain Games!");
                System.out.println("May I have your name?");
                String name2 = words.nextLine();
                System.out.println("Hello, " + name2 + "!");
                System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
                var count = 0;

                for (int i = 0; i < 3; i++) {
                    var rand = (int) (20 * Math.random());
                    System.out.println("Question: " + rand);
                    var answer = words.nextLine();
                    if (rand % 2 == 0 && answer.equalsIgnoreCase("yes")) {
                        System.out.println("Correct!");
                        count += 1;

                    } else if (rand % 2 != 0 && answer.equalsIgnoreCase("no")) {
                        System.out.println("Correct!");
                        count += 1;
                    } else {
                        System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.");
                        System.out.println("Let's try again, Bill!");
                        break;
                    }
                }
                if (count == 3) {
                    System.out.println("Congratulations, " + name2 + "!");
                }

                break;

        }

    }
}

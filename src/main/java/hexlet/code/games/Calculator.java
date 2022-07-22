package hexlet.code.games;

import java.util.Scanner;

public class Calculator {

    public static void calculation() {
        Scanner words = new Scanner(System.in);
        Greet.getGreet();
        String getName = Greet.name;

        System.out.println("What is the result of the expression?");
        var count = 0;
        var result = 0;
        var operand = "";

        for (int i = 0; i < 3; i++) {
            var randomNumber1 = (int) (17 * Math.random());
            var randomNumber2 = (int) (17 * Math.random());
            var switchNumbers = (int) (3 * Math.random());


            switch (switchNumbers) {
                case 0:
                    result = randomNumber1 + randomNumber2;
                    operand = "+";
                    break;
                case 1:
                    result = randomNumber1 * randomNumber2;
                    operand = "*";
                    break;
                case 2:
                    result = randomNumber1 / randomNumber2;
                    operand = "/";
                    break;
            }
            System.out.println("Question: " + randomNumber1 + " " + operand + " " + randomNumber2);
            String choice = words.nextLine();
            System.out.println("Your answer: " + choice);

            if (String.valueOf(result).equals(choice)) {
                System.out.println("Correct!");
                count++;
            } else {
                System.out.println(choice + " is wrong answer ;(. Correct answer was " + result + ".");
                System.out.println("Let's try again, " + getName + "!");
                break;
            }

        }
        if (count == 3) {
            System.out.println("Congratulations, " + getName + "!");
        }

    }

}

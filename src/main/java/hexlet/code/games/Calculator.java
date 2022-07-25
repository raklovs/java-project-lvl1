package hexlet.code.games;

import java.util.Scanner;

public class Calculator {

    public static void calculation() {
        Scanner words = new Scanner(System.in);
        Greet.getGreet();
        String getName = Greet.getName();

        System.out.println("What is the result of the expression?");
        var count = 0;
        var result = 0;
        var operand = "";
        final int numberOfQuestions = 3;
        final int multiplier1 = 17;
        final int multiplier2 = 3;

        for (int i = 0; i < numberOfQuestions; i++) {
            var randomNumber1 = (int) (multiplier1 * Math.random());
            var randomNumber2 = (int) (multiplier1 * Math.random());
            var switchNumbers = (int) (multiplier2 * Math.random());


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
                    result = randomNumber1 - randomNumber2;
                    operand = "-";
                    break;
                default:
                    System.out.println("Out of range");
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
        if (count == numberOfQuestions) {
            System.out.println("Congratulations, " + getName + "!");
        }

    }

}

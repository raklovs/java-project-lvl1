package hexlet.code.games;

import hexlet.code.Engine;

public class Calculator {

    static final int MULTIPLIER_1 = 17;
    static final int MULTIPLIER_2 = 3;

    public static void calculation() {

        String[][] response = new String[Engine.NUMBER_OF_QUESTION][2];
        String question = "What is the result of the expression?";

        var result = 0;
        var operand = "";

        for (int i = 0; i < Engine.NUMBER_OF_QUESTION; i++) {
            var randomNumber1 = (int) (Calculator.MULTIPLIER_1 * Math.random());
            var randomNumber2 = (int) (Calculator.MULTIPLIER_1 * Math.random());
            var switchNumbers = (int) (Calculator.MULTIPLIER_2 * Math.random());

            switch (switchNumbers) {
                case 0 -> {
                    result = randomNumber1 + randomNumber2;
                    operand = "+";
                }
                case 1 -> {
                    result = randomNumber1 * randomNumber2;
                    operand = "*";
                }
                case 2 -> {
                    result = randomNumber1 - randomNumber2;
                    operand = "-";
                }
                default -> System.out.println("Out of range");
            }
            response[i][0] = randomNumber1 + " " + operand + " " + randomNumber2;
            response[i][1] = Integer.toString(result);
        }
        Engine.gameManagement(question, response);
    }
}

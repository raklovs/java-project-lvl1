package hexlet.code.games;

import hexlet.code.Engine;

public class Even {

    public static void guessEvenOrOddNumber() {

        String[][] response = new String[Engine.NUMBER_OF_QUESTION][2];
        String question = "Answer 'yes' if number even otherwise answer 'no'.";
        final var multiplier = 17;

        for (int i = 0; i < Engine.NUMBER_OF_QUESTION; i++) {
            var randomNumber = (int) (multiplier * Math.random());
            response[i][0] = Integer.toString(randomNumber);
            response[i][1] = randomNumber % 2 == 0 ? "yes" : "no";

        }
        Engine.gameManagement(question, response);
    }
}

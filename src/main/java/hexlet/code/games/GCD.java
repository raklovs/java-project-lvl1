package hexlet.code.games;

import java.util.Scanner;

public class GCD {

    public static int algorithmGreatestCommonDivisor(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return algorithmGreatestCommonDivisor(n2, n1 % n2);
    }

    public static void findGreatestCommonDivisor() {
        Scanner words = new Scanner(System.in);
        Greet.getGreet();
        String getName = Greet.name;

        System.out.println("Find the greatest common divisor of given numbers.");
        var count = 0;

        for (int i = 0; i < 3; i++) {
            var randomNumber1 = (int) (100 * Math.random());
            var randomNumber2 = (int) (100 * Math.random());
            var answer = GCD.algorithmGreatestCommonDivisor(randomNumber1, randomNumber2);

            System.out.println("Question: " + randomNumber1 + " " + randomNumber2);
            String choice = words.nextLine();
            System.out.println("Your answer: " + choice);

            if (String.valueOf(answer).equals(choice)) {
                System.out.println("Correct!");
                count++;
            } else {
                System.out.println(choice + " is wrong answer ;(. Correct answer was " + answer + ".");
                System.out.println("Let's try again, " + getName + "!");
                break;
            }

        }
        if (count == 3) {
            System.out.println("Congratulations, " + getName + "!");
        }

    }
}

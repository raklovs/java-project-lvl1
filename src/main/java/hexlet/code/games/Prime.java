package hexlet.code.games;

import java.util.Scanner;

public class Prime {

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number / 2; i++) {
            if ((number % i) == 0)
                return false;
        }
        return true;
    }


    public static void PrimeNumber() {
        Scanner words = new Scanner(System.in);
        Greet.getGreet();
        String getName = Greet.name;
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        var count = 0;

        for (var i = 0; i < 3; i++) {
            int randomNumber = (int) (Math.random() * 10) + 1;
            System.out.println("Question: " + randomNumber);

            boolean isPrime = isPrime(randomNumber);
            Scanner answerScan = new Scanner(System.in);
            String answer = answerScan.nextLine();
            System.out.println("Your answer: " + answer);

            if (isPrime & answer.equals("yes")) {
                System.out.println("Correct!");
                count++;
            } else if (!isPrime & answer.equals("no")) {
                System.out.println("Correct!");
                count++;
            } else {
                System.out.println("'" + answer + "'" + " is wrong answer ;(. " + "Correct answer was 'no'.");
                System.out.println("Let's try again, " + getName + "!");
                break;
            }
        }
        if (count == 3) {
            System.out.println("Congratulations, " + getName + "!");
        }
    }
}

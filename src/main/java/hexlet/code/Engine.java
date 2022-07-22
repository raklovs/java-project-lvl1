package hexlet.code;
import java.util.Scanner;
import hexlet.code.games.*;

public class Engine {
    public static void gameManagement() {
        Scanner words = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        String choice = words.nextLine();
        System.out.println("Your choice: " + choice);

        switch (choice) {
            case "0":
                System.out.println("Goodbye!");
                break;
            case "1":
                Greet.getGreet();
                break;
            case "2":
                Even.GuessEvenOrOddNumber();
                break;
            case "3":
                Calculator.calculation();
                break;
        }

    }
}

package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static String getName() {
        Scanner w = new Scanner(System.in);
        String world = w.nextLine();
        return world;
    }

}

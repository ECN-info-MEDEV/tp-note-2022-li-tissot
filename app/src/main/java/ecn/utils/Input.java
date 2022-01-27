package ecn.utils;

import java.util.Scanner;

public class Input {

    private static final Scanner INPUT = new Scanner(System.in);

    private Input() {
        // Utility classes should not be instanciated
    }

    public static String getString() {
        while (!INPUT.hasNextLine()) {
        }
        return INPUT.nextLine();
    }

    public static String getString(String message) {
        System.out.print(message);
        return getString();
    }

}

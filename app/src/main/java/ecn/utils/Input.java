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

    public static int getInt(String message) {
        return getInt(message, "You must put an integer: ");
    }

    public static int getInt(String message, String errorMessage) {
        String input = getString(message);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return getInt(errorMessage, errorMessage);
        }
    }

}

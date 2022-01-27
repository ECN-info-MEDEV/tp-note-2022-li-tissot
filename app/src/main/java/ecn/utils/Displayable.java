package ecn.utils;

public class Displayable {

    private Displayable() {
        // Utility classes should not be instanciated
    }

    // clears and moves cursor
    public static final String CLEAR = "\033c"; // use "\033[H\033[2J" to clear without reseting

    // resets color and style
    public static final String RESET = "\033[0m";

    // colors
    public static final String WHITE = color(255, 255, 255);
    public static final String YELLOW = color(255, 174, 0); // FFAE00
    public static final String RED = color(255, 0, 0); // 0000FF
    public static final String WHITE_BACKGROUND = backgroundColor(219, 202, 125);
    public static final String BLUE_BACKGROUND = backgroundColor(24, 35, 196);

    // symbols
    public static final String FILLED_CIRCLE = "\u2b24\u200a"; // ⬤ + hair space (to fix display bug
                                                               // in some terminals)
    public static final String SPACE = "  ";

    /**
     * Generates a ansi escape code for the background color
     * 
     * @param r : 0 - 255 (red value)
     * @param g : 0 - 255 (green value)
     * @param b : 0 - 255 (blue value)
     * @return the ansi escape code (String)
     */
    public static String backgroundColor(int r, int g, int b) {
        return "\033[48;2;" + r + ";" + g + ";" + b + "m";
    }

    /**
     * Generates a ansi escape code for the foreground color
     * 
     * @param r : 0 - 255 (red value)
     * @param g : 0 - 255 (green value)
     * @param b : 0 - 255 (blue value)
     * @return the ansi escape code (String)
     */
    public static String color(int r, int g, int b) {
        return "\033[38;2;" + r + ";" + g + ";" + b + "m";
    }

    /**
     * Clears the console and put the cursor at the first position
     */
    public static void clearConsole() {
        System.out.print(CLEAR);
    }

}

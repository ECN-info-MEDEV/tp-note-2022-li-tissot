/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ecn;

public class App {
    public static void main(String[] args) {
        var board = new Board();
        board.data[3][4] = State.GREEN;
        board.data[1][2] = State.RED;
        System.out.println(board);
    }
}

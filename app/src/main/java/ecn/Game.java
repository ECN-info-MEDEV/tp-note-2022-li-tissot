package ecn;

import ecn.utils.Input;
import lombok.Getter;

public class Game {

    @Getter
    Player player1;
    @Getter
    Player player2;
    Board board;

    /**
     * Creates a game with 2 players
     * 
     * @param name1 : name of the red player
     * @param name2 : name of the yellow player
     */
    public Game(String name1, String name2) {
        player1 = new Player(Color.RED, name1);
        player2 = new Player(Color.YELLOW, name2);
        board = new Board();
    }

    /**
     * Creates a game asking for names of players
     */
    public Game() {
        String name1 = Input.getString("Choose name for red player [default: player1]: ");
        String name2 = Input.getString("Choose name for yellow player [default: player2]: ");
        player1 = new Player(Color.RED, name1.isBlank() ? "player1" : name1);
        player2 = new Player(Color.YELLOW, name2.isBlank() ? "player2" : name2);
        board = new Board();
    }

    /**
     * Displays the board
     */
    public void display() {
        System.out.println(board);
    }

    /**
     * Ask the user to choose a column and check if it is ok
     * @return the column number
     */
    private int getColumn() {
        int column = Input.getInt("Choose column to put your pawn [0-6]: ");
        while (column < 0 || column > 6 || !board.isColAvailable(column)) {
            if (column < 0 || column > 6) {
                column = Input.getInt("Choose a valid column [0-6]: ");
            } else {
                column = Input.getInt("Choose a free column [0-6]: ");
            }
        }
        return column;
    }

    /**
     * Makes a game round
     * 
     * @param player which must play
     * @return a boolean indicating if game continue (false if game is over)
     */
    private boolean play(Player player) {
        // Displays the board and the player which should play
        display();
        System.out.println(String.format("It's %s's turn to play...", player.name));

        // Gets the column choice of the player and put a pawn in that column
        int column = getColumn();
        board.put(player.getColor(), column);

        // Test if the game is over
        var end = board.hasWon();
        // When the game is over
        if (!end.isEmpty()) {
            display();
            var winner = end.get();
            // Game can be null or won
            if (winner.equals(State.NONE)) {
                tie();
            } else {
                win(winner.equals(player1.getColor().toState()) ? player1 : player2);
            }
        }
        return end.isEmpty();
    }

    /**
     * Displays which player has won
     * @param player who won
     */
    private void win(Player player) {
        System.out.println(String.format("%s has won !", player.name));
    }


    /**
     * Displays that players ties (when game is null)
     */
    private void tie() {
        System.out.println(String.format("%s has tied with %s !", player1.name, player2.name));
    }

    /**
     * Starts the game
     */
    public void start() {
        boolean gameContinue = true;
        Player actualPlayer = player1;
        while (gameContinue) {
            gameContinue = play(actualPlayer);
            actualPlayer = (actualPlayer == player1) ? player2 : player1;
        }
    }

}

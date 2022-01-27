package ecn;

import ecn.utils.Input;

public class Game {

    Player player1;
    Player player2;

    /**
     * Creates a game with 2 players
     * 
     * @param name1 : name of the red player
     * @param name2 : name of the yellow player
     */
    public Game(String name1, String name2) {
        player1 = new Player(Color.RED, name1);
        player2 = new Player(Color.YELLOW, name2);
    }

    /**
     * Creates a game asking for names of players
     */
    public Game() {
        String name1 = Input.getString("Choose name for red player [default: player1]: ");
        String name2 = Input.getString("Choose name for yellow player [default: player2]: ");
        player1 = new Player(Color.RED, name1.isBlank() ? "player1" : name1);
        player2 = new Player(Color.YELLOW, name2.isBlank() ? "player2" : name2);
    }

}

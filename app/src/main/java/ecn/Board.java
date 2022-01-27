package ecn;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ecn.utils.Displayable;
import lombok.Data;

/**
 * The board of the game.
 */
@Data
public class Board {
    private State[][] data;

    public Board(State[][] data) {
        this.data = data;
    }

    /**
     * Make a new board.
     * 
     * @param x The size in the x direction of this board.
     * @param y The size in the y direction of this board.
     */
    public Board(int x, int y) {
        this.data = new State[x][y];
        Arrays.stream(this.data).forEach(l -> Arrays.fill(l, State.NONE));
    }

    /**
     * Make a new board of default size (6x7).
     */
    public Board() {
        this(6, 7);
    }

    /**
     * Returns the size on x of this board.
     */
    public int xSize() {
        return this.data.length;
    }

    /**
     * Returns the size on y of this board.
     */
    public int ySize() {
        return this.data[0].length;
    }

    @Override
    public String toString() {
        String content = Arrays.stream(this.data)
                .map(l -> IntStream.range(0, l.length).mapToObj(i -> l[i].toString())
                        .collect(Collectors.joining()))
                .collect(Collectors.joining("\n", "",
                        Displayable.RESET + "\n" + Displayable.BLUE_BACKGROUND));
        return Displayable.BLUE_BACKGROUND + content + Displayable.RESET + "0 1 2 3 4 5 6";
    }

    /**
     * Copies the whole board.
     * 
     * @return The copied board.
     */
    public Board deepCopy() {
        return new Board(
                Arrays.stream(this.data).map(bs -> bs.clone()).toArray(i -> this.data.clone()));
    }
}

package ecn;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ecn.utils.Displayable;
import lombok.Data;

/**
 * The board of the game.
 * 
 * Convention:
 * x  0
 * |  1
 * v  2
 *    3
 *    4
 *    5
 * y -> 0 1 2 3 4 5 6
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

    protected Optional<Color> hasWonX() {
        for (int i = 0; i < this.xSize(); i++) {
            var redCount = 0;
            var yellowCount = 0;
            for (int j = 0; j < this.ySize(); j++) {
                if (data[i][j] == State.RED) {
                    redCount++;
                    if (redCount >= 4)
                        return Optional.of(Color.RED);
                } else if (data[i][j] == State.YELLOW) {
                    yellowCount++;
                    if (yellowCount >= 4)
                        return Optional.of(Color.YELLOW);
                }
            }
        }
        return Optional.empty();
    }

    protected Optional<Color> hasWonY() {
        for (int j = 0; j < this.ySize(); j++) {
            var redCount = 0;
            var yellowCount = 0;
            for (int i = 0; i < this.xSize(); i++) {
                if (data[i][j] == State.RED) {
                    redCount++;
                    if (redCount >= 4)
                        return Optional.of(Color.RED);
                } else if (data[i][j] == State.YELLOW) {
                    yellowCount++;
                    if (yellowCount >= 4)
                        return Optional.of(Color.YELLOW);
                }
            }
        }
        return Optional.empty();
    }

    protected Optional<Color> hasWonDiag0() {
        for (int j = 1; j < this.ySize(); j++) {
            var redCount = 0;
            var yellowCount = 0;
            for (int i = 0; i < this.ySize() - j; i++) {
                if (data[i][j + i] == State.RED) {
                    redCount++;
                    if (redCount >= 4)
                        return Optional.of(Color.RED);
                } else if (data[i][j + i] == State.YELLOW) {
                    yellowCount++;
                    if (yellowCount >= 4)
                        return Optional.of(Color.YELLOW);
                }
            }
        }
        for (int i = 0; i < this.xSize(); i++) {
            var redCount = 0;
            var yellowCount = 0;
            for (int j = 0; j < this.xSize() - i; j++) {
                if (data[i + j][j] == State.RED) {
                    redCount++;
                    if (redCount >= 4)
                        return Optional.of(Color.RED);
                } else if (data[i + j][j] == State.YELLOW) {
                    yellowCount++;
                    if (yellowCount >= 4)
                        return Optional.of(Color.YELLOW);
                }
            }
        }
        return Optional.empty();
    }

    protected Optional<Color> hasWonDiag1() {
        for (int j = 1; j < this.ySize(); j++) {
            var redCount = 0;
            var yellowCount = 0;
            for (int i = 0; i < this.ySize() - j; i++) {
                if (data[xSize() - 1 - i][j + i] == State.RED) {
                    redCount++;
                    if (redCount >= 4)
                        return Optional.of(Color.RED);
                } else if (data[xSize() - 1 - i][j + i] == State.YELLOW) {
                    yellowCount++;
                    if (yellowCount >= 4)
                        return Optional.of(Color.YELLOW);
                }
            }
        }
        for (int i = 0; i < this.xSize(); i++) {
            var redCount = 0;
            var yellowCount = 0;
            for (int j = 0; j < this.xSize() - i; j++) {
                if (data[xSize() - 1 - i - j][j] == State.RED) {
                    redCount++;
                    if (redCount >= 4)
                        return Optional.of(Color.RED);
                } else if (data[xSize() - 1 - i - j][j] == State.YELLOW) {
                    yellowCount++;
                    if (yellowCount >= 4)
                        return Optional.of(Color.YELLOW);
                }
            }
        }
        return Optional.empty();
    }

    /** Check the board to find if anyone has won. 
     * @return The winner's Color, if any.
    */
    public Optional<Color> hasWon() {
        return hasWonX().or(this::hasWonY).or(this::hasWonDiag0).or(this::hasWonDiag1);
    }
}

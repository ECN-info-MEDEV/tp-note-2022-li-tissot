package ecn;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ecn.utils.Displayable;

public class Board {

    public final State[][] data;

    public Board(State[][] data) {
        this.data = data;
    }

    public Board(int x, int y) {
        this.data = new State[x][y];
        Arrays.stream(this.data).forEach(l -> Arrays.fill(l, State.NONE));
    }

    public Board() {
        this(6, 7);
    }

    public int xSize() {
        return this.data.length;
    }

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

    public Board deepCopy() {
        return new Board(
                Arrays.stream(this.data).map(bs -> bs.clone()).toArray(i -> this.data.clone()));
    }


}

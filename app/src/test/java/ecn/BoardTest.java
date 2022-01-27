package ecn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Optional;
import org.junit.jupiter.api.Test;

public class BoardTest {
    @Test
    void testHasWonDiag0() {
        var b = new Board();
        b.getData()[2][0] = State.RED;
        b.getData()[3][1] = State.RED;
        b.getData()[4][2] = State.RED;
        b.getData()[5][3] = State.RED;
        assertEquals(Optional.of(Color.RED), b.hasWonDiag0());
    }

    @Test
    void testHasWonDiag1() {
        var b = new Board();
        b.getData()[5][0] = State.RED;
        b.getData()[4][1] = State.RED;
        b.getData()[3][2] = State.RED;
        b.getData()[2][3] = State.RED;
        assertEquals(Optional.of(Color.RED), b.hasWonDiag1());
    }

    @Test
    void testHasWonX() {
        var b = new Board();
        b.getData()[3][6] = State.YELLOW;
        b.getData()[3][5] = State.YELLOW;
        b.getData()[3][4] = State.YELLOW;
        b.getData()[3][3] = State.YELLOW;
        assertEquals(Optional.of(Color.YELLOW), b.hasWonX());
    }

    @Test
    void testHasWonY() {
        var b = new Board();
        b.getData()[5][3] = State.YELLOW;
        b.getData()[4][3] = State.YELLOW;
        b.getData()[3][3] = State.YELLOW;
        b.getData()[2][3] = State.YELLOW;
        assertEquals(Optional.of(Color.YELLOW), b.hasWonY());
    }
}

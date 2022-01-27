package ecn;

import lombok.ToString;

@ToString
public enum Color {
    RED, YELLOW;

    public State toState() {
        return switch (this) {
            case RED -> State.RED;
            case YELLOW -> State.YELLOW;
        };
    }
}

package ecn;

public enum Color {
    RED, YELLOW;

    public State state() {
        return switch (this) {
            case RED -> State.RED;
            case YELLOW -> State.YELLOW;
        };
    }
}

package ecn;

public enum State {
    RED, GREEN, NONE;

    @Override
    public String toString() {
        return switch (this) {
            case RED -> "x";
            case GREEN -> "o";
            case NONE -> "_";
        };
    }
}

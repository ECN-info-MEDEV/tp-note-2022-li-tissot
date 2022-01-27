package ecn;

import ecn.utils.Displayable;

public enum State {
    RED, YELLOW, NONE;

    @Override
    public String toString() {
        return switch (this) {
            case RED -> Displayable.RED + Displayable.FILLED_CIRCLE;
            case YELLOW -> Displayable.YELLOW + Displayable.FILLED_CIRCLE;
            case NONE -> Displayable.RESET + Displayable.BLUE_BACKGROUND
                    + Displayable.FILLED_CIRCLE;
        };
    }
}

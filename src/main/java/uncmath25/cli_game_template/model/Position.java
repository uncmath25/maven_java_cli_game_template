package uncmath25.cli_game_template.model;

public class Position {
    private final boolean isEmpty;
    private final Integer value;

    private Position(final boolean isEmpty, final Integer value) {
        this.isEmpty = isEmpty;
        this.value = value;
    }

    public boolean isEmpty() { return isEmpty; }
    public Integer getValue() { return value; }

    public static Position buildEmpty() { return new Position(true, null); }
    public static Position buildPopulated(final int value) { return new Position(false, value); }
}

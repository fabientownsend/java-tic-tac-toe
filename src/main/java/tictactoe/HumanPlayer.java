package tictactoe;

public class HumanPlayer implements Player {
    private IO io;
    private final Marks mark;
    private final String MUST_BE_INTEGER = "It must be an integer";

    public HumanPlayer(IO io, Marks mark) {
        this.io = io;
        this.mark = mark;
    }

    public boolean isReady() {
        return io.isReady();
    }

    public final int nextMove() {
        try {
            String playerMove = io.read();
            return Integer.parseInt(playerMove);
        } catch (NumberFormatException e) {
            io.write(MUST_BE_INTEGER);
            return nextMove();
        }
    }

    public Marks getMark() {
        return mark;
    }
}

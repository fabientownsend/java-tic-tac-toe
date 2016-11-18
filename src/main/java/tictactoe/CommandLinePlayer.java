package tictactoe;

public class CommandLinePlayer implements Player {
    private IO io;
    private final char mark;
    private final String MUST_BE_INTEGER = "It must be an integer";

    public CommandLinePlayer(IO io, char mark) {
        this.io = io;
        this.mark = mark;
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

    public char getMark() {
        return mark;
    }
}

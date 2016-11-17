package tictactoe;

public class CommandLinePlayer implements Player {
    private IOGame io;
    private final char mark;

    public CommandLinePlayer(IOGame io, char mark) {
        this.io = io;
        this.mark = mark;
    }
    public int nextMove() {
        try {
            String playerMove = io.read();
            return Integer.parseInt(playerMove);
        } catch (NumberFormatException e) {
            io.write("It must be an integer");
            return nextMove();
        }
    }

    public char getMark() {
        return mark;
    }
}

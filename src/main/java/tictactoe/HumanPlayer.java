package tictactoe;

public class HumanPlayer implements Player {
    private IO io;
    private final Marks mark;
    private final String MUST_BE_INTEGER = "It must be an integer";
    private final String POSITION_NOT_FREE = "The position isn't free";
    private Board board;

    public HumanPlayer(IO io, Marks mark, Board board) {
        this.board = board;
        this.io = io;
        this.mark = mark;
    }

    public boolean isReady() {
        return io.isReady();
    }

    private final String BETWEEN = "The position should be between ";
    private final String AND = " and ";
    public final int nextMove() {
        displayCurrentParty();

        int position;

        try {
            String playerMove = io.read();
            position = Integer.parseInt(playerMove);
        } catch (NumberFormatException e) {
            io.write(MUST_BE_INTEGER);
            position = nextMove();
        }

        if (position < 0 || position > board.getPositionMax()) {
            io.write(BETWEEN + 0 + AND + board.getPositionMax());
            position = nextMove();
        }

        if (!board.isVacantAt(position)) {
            io.write(POSITION_NOT_FREE);
            position = nextMove();
        }

        return position;
    }

    private void displayCurrentParty() {
        String currentPlayerTurn =  mark + " turn";
        io.displayBoard(board.getContent());
        io.write(currentPlayerTurn);
    }

    public Marks getMark() {
        return mark;
    }
}

package tictactoe;

public class Party {
    private Board board;
    private IO io;
    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer;
    private final String TURN = " turn\n";
    private final String TIE = "it's a tie\n";
    private final String WON = " won the party\n";
    private final String BETWEEN = "Move should be between ";
    private final String AND = " and ";
    private final String POSITION_NOT_FREE = "The position isn't free";
    private final String CROSS = "X";
    private final String NOUGHT = "O";
    private final int MIN_BOARD = 0;
    private int positionMax;

    public Party(IO io, Board board, Player playerOne, Player playerTwo) {
        this.board = board;
        this.io = io;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.currentPlayer = this.playerOne;
        this.positionMax = board.getContent().length * board.getContent().length - 1;
    }

    public void play() {
        displayCurrentParty();

        if (!currentPlayer.isReady()) {
            return;
        }

        currentPlayerMove();

        if (isGameOver()) {
            displayResult();
        } else {
            switchPlayer();
            play();
        }
    }

    private void currentPlayerMove() {
        board.putMark(currentPlayer.getMark(), getMoveBetween(MIN_BOARD, positionMax));
    }

    private int getMoveBetween(int min, int max) {
        int move = currentPlayer.nextMove();

        if (move < min || move > max) {
            io.write(BETWEEN + min + AND + max);
            return getMoveBetween(min, max);
        } else if (!board.isVacantAt(move)) {
            io.write(POSITION_NOT_FREE);
            return getMoveBetween(min, max);
        }

        return move;
    }

    private void displayCurrentParty() {
        String currentPlayerTurn = currentPlayer.getMark() + TURN;
        io.displayBoard(board.getContent());
        io.write(currentPlayerTurn);
    }

    private boolean isGameOver() {
        return board.tie() || board.win(currentPlayer.getMark());
    }

    private void displayResult() {
        String result = getResultMessage();
        io.displayBoard(board.getContent());
        io.write(result);
    }

    private String getResultMessage() {
        if (board.tie()) {
            return TIE;
        } else {
            return convertMarkToString() + WON;
        }
    }

    private String convertMarkToString() {
        if (currentPlayer.getMark() == Marks.CROSS) {
            return CROSS;
        } else {
            return NOUGHT;
        }
    }

    private void switchPlayer() {
        if (currentPlayer == playerOne) {
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }
    }
}

package tictactoe;

public class GamePlay {
    private BoardConverter boardConverter;
    private IBoard board;
    private IO io;
    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer;
    private final String TURN = " turn\n";
    private final String TIE = "it's a tie\n";
    private final String WON = " won the party\n";
    private final String BETWEEN = "Move should be between ";
    private final String AND = " and ";
    private final int MIN_BOARD = 0;
    private final int MAX_BOARD = 8;

    public GamePlay(IO io, IBoard board) {
        this.board = board;
        this.boardConverter = new BoardConverter();
        this.io = io;
        this.playerOne = new CommandLinePlayer(io, Marks.CROSS);
        this.playerTwo = new CommandLinePlayer(io, Marks.ROUND);
        this.currentPlayer = this.playerOne;
    }

    public GamePlay(IO io, IBoard board, Player playerOne, Player playerTwo) {
        this.board = board;
        this.boardConverter = new BoardConverter();
        this.io = io;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.currentPlayer = this.playerOne;
    }

    public void play() {
        displayCurrentParty();
        currentPlayerMove();

        if (isGameOver()) {
            displayResult();
        } else {
            switchPlayer();
            play();
        }
    }

    private void currentPlayerMove() {
        board.putMark(currentPlayer.getMark(), getMoveBetween(MIN_BOARD, MAX_BOARD));
    }

    private int getMoveBetween(int min, int max) {
        int move = currentPlayer.nextMove();

        if (move < min || move > max) {
            io.write(BETWEEN + min + AND + max);
            return getMoveBetween(min, max);
        }

        return move;
    }

    private void displayCurrentParty() {
        String currentBoard = boardConverter.toString(board.getContent());
        String currentPlayerTurn = currentPlayer.getMark() + TURN;
        io.write(currentBoard + currentPlayerTurn);
    }

    private boolean isGameOver() {
        return board.tie() || board.win(currentPlayer.getMark());
    }

    private void displayResult() {
        String result = getResultMessage();
        String currentBoard = boardConverter.toString(board.getContent());
        io.write(result + currentBoard);
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
            return "X";
        } else {
            return "O";
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

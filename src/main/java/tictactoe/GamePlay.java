package tictactoe;

public class GamePlay {
    private BoardConverter boardConverter;
    private IBoard board;
    private IOGame io;
    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer;
    private static String TURN = " turn\n";
    private static String TIE = "it's a tie\n";
    private static String WON = " won the party\n";

    public GamePlay(IOGame io, IBoard board) {
        this.board = board;
        this.boardConverter = new BoardConverter();
        this.io = io;
        this.playerOne = new CommandLinePlayer(io, Marks.CROSS);
        this.playerTwo = new CommandLinePlayer(io, Marks.ROUND);
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
        int move = getMoveBetween(0, 8);

        board.putMark(currentPlayer.getMark(), move);
    }

    private int getMoveBetween(int min, int max) {
        int move = currentPlayer.nextMove();

        if (move < min || move > max) {
            io.write("Move should be between " + min + " and " + max);
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
            return currentPlayer.getMark() + WON;
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

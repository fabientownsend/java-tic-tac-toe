package tictactoe;

public class GamePlay {
    Player playerOne;
    Player playerTwo;
    Player currentPlayer;
    IBoard board;
    BoardConverter boardConverter;
    IOGame io;

    public GamePlay(IOGame io, IBoard board) {
        this.board = board;
        this.io = io;
        this.boardConverter = new BoardConverter();
        this.currentPlayer = playerOne;
        createPlayers();
    }

    public void play() {
        switchPlayer();
        io.write(currentPlayer.getMark() + " turn");
        String strBoard = boardConverter.toString(board.getContent());
        io.write(strBoard);
        board.putMark(currentPlayer.getMark(), currentPlayer.nextMove());

        if (board.tie()) {
            io.write("it's a tie");
        } else if (board.win(currentPlayer.getMark())) {
            io.write(currentPlayer.getMark() + " won the party");
        } else {
            play();
        }

        strBoard = boardConverter.toString(board.getContent());
        io.write(strBoard);
    }

    private void switchPlayer() {
        if (currentPlayer == playerOne) {
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }
    }

    private void createPlayers() {
        this.playerOne = new CommandLinePlayer(io, Marks.CROSS);
        this.playerTwo = new CommandLinePlayer(io, Marks.ROUND);
    }
}

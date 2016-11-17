package tictactoe;

public class GamePlay {
    Player playerOne;
    Player playerTwo;
    Player currentPlayer;
    Board board;
    BoardConvertor boardConvertor;
    IOGame io;

    public GamePlay(IOGame io) {
        this.board = new Board();
        this.io = io;
        this.boardConvertor = new BoardConvertor();
        this.currentPlayer = playerOne;
        createPlayers();
    }

    public void play() {
        switchPlayer();
        String strBoard = boardConvertor.toString(board.getContent());
        io.write(strBoard);
        board.putMark(currentPlayer.getMark(), currentPlayer.nextMove());

        if (!board.tie() && !board.win(currentPlayer.getMark())) {
            play();
        }

        strBoard = boardConvertor.toString(board.getContent());
        io.write(strBoard);
        io.write("ended\n");
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

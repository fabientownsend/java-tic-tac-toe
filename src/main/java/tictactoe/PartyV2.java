package tictactoe;

public class PartyV2 {
    private Board board;
    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer;

    public PartyV2(Board board, Player playerOne, Player playerTwo) {
        this.board = board;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.currentPlayer = this.playerOne;
    }

    public void play() {
        if (!currentPlayer.isReady()) {
            return;
        }

        currentPlayerMove();

        if (!isGameOver()) {
            switchPlayer();
            play();
        }
    }

    private void currentPlayerMove() {
        board.putMark(currentPlayer.getMark(), currentPlayer.nextMove());
    }

    public boolean isTie() {
        return board.tie();
    }

    public boolean currentPlayerWon() {
        board.win(currentPlayer.getMark());
    }

    private boolean isGameOver() {
        return board.tie() || board.win(currentPlayer.getMark());
    }

    private void switchPlayer() {
        if (currentPlayer == playerOne) {
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }
    }
}

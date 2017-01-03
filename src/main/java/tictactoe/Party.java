package tictactoe;

import tictactoe.players.Player;

public class Party {
    private Board board;
    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer;

    public Party(Board board, Player playerOne, Player playerTwo) {
        this.board = board;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.currentPlayer = this.playerOne;
    }

    public void play() {
        if (!currentPlayer.isReady() || isGameOver()) {
            return;
        }

        playNextMove();

        if (!isGameOver()) {
            switchPlayer();
            play();
        }
    }

    private void playNextMove() {
        int move = currentPlayer.nextMove();
        board.putMark(currentPlayer.getMark(), move);
    }

    private void switchPlayer() {
        if (currentPlayer == playerOne) {
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }
    }

    public Marks getCurrentPlayerMark() {
        return currentPlayer.getMark();
    }

    private boolean isGameOver() {
        return isTie() || currentPlayerWon();
    }

    public boolean isTie() {
        return board.tie();
    }

    public boolean currentPlayerWon() {
        return board.win(currentPlayer.getMark());
    }
}

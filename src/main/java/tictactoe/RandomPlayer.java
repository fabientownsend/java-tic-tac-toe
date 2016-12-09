package tictactoe;

import java.util.Random;

public class RandomPlayer implements Player {
    private Marks mark;
    private Board board;

    public RandomPlayer(Marks mark, Board board) {
        this.board = board;
        this.mark = mark;
    }
    public final int nextMove() {
        int index = new Random().nextInt(board.getNumberOfFreePositions());
        return board.freePositions().get(index);
    }

    public Marks getMark() {
        return mark;
    }
}

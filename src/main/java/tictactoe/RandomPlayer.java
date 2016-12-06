package tictactoe;

import java.util.Random;

public class RandomPlayer implements Player {
    private MarksEnum mark;
    private Board board;

    public RandomPlayer(MarksEnum mark, Board board) {
        this.board = board;
        this.mark = mark;
    }
    public final int nextMove() {
        int index = new Random().nextInt(board.freePositions().size());
        return board.freePositions().get(index);
    }

    public MarksEnum getMark() {
        return mark;
    }
}

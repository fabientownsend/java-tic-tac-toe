package tictactoe;

import org.junit.Rule;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RandomPlayerTest {
    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @Repeat(times = 100)
    public void getARandomMoveFromMoveAvailable2() {
        Board board = BoardHelper.createBoard("XOXXOX---");
        RandomPlayer randomPlayer = new RandomPlayer(MarksEnum.CROSS, board);

        assertThat(randomPlayer.nextMove()).isIn(board.freePosition());
    }
}


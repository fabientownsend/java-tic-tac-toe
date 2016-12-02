package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class BoardTest {
    private Board board;

    @Before
    public void initialize() {
        board = new Board();
    }

    @Test
    public void crossPlayerWinRowOne() {
        BoardHelper.update(board, "XXX------");

        assertThat(board.win(MarksEnum.CROSS)).isTrue();
    }

    @Test
    public void crossPlayerWinRowTwo() {
        BoardHelper.update(board, "---XXX---");

        assertThat(board.win(MarksEnum.CROSS)).isTrue();
    }

    @Test
    public void crossPlayerWinRowThree() {
        BoardHelper.update(board, "------XXX");

        assertThat(board.win(MarksEnum.CROSS)).isTrue();
    }

    @Test
    public void crossPlayerWinColumnOne() {
        BoardHelper.update(board, "X--X--X--");

        assertThat(board.win(MarksEnum.CROSS)).isTrue();
    }

    @Test
    public void crossPlayerWinColumnTwo() {
        BoardHelper.update(board, "-X--X--X-");

        assertThat(board.win(MarksEnum.CROSS)).isTrue();
    }

    @Test
    public void crossPlayerWinColumnThree() {
        BoardHelper.update(board, "--X--X--X");

        assertThat(board.win(MarksEnum.CROSS)).isTrue();
    }

    @Test
    public void noPlayerWin() {
        BoardHelper.update(board, "XOX------");

        assertThat(board.win(MarksEnum.CROSS)).isFalse();
    }

    @Test
    public void isNotATieWHenBoardNotFull() {
        BoardHelper.update(board, "XOX------");

        assertThat(board.tie()).isFalse();
    }

    @Test
    public void crossPlayerWinDiagonnalOne() {
        BoardHelper.update(board, "X---X---X");

        assertThat(board.win(MarksEnum.CROSS)).isTrue();
    }

    @Test
    public void crossPlayerWinDiagonnalTwo() {
        BoardHelper.update(board, "--X-X-X--");

        assertThat(board.win(MarksEnum.CROSS)).isTrue();
    }

    @Test
    public void itIsATie() {
        BoardHelper.update(board, "XOXXOXOXO");

        assertThat(board.tie()).isTrue();
    }

    @Test
    public void getFreePosition() {
        BoardHelper.update(board, "XOXOXO---");
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(6);
        arr.add(7);
        arr.add(8);
        assertThat(board.freePosition()).isEqualTo(arr);
    }

    @Test
    public void removeOneElement() {
        BoardHelper.update(board, "XOXOXO---");
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(6);
        arr.add(7);
        arr.add(8);
        assertThat(board.freePosition()).isEqualTo(arr);

        board.removeMark(1);
        arr.add(0, 1);
        assertThat(board.freePosition()).isEqualTo(arr);
    }
}

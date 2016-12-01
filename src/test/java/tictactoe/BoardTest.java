package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BoardTest {
    private Board board;

    @Before
    public void initialize() {
        board = new Board();
    }

    @Test
    public void crossPlayerWinRowOne() {
        BoardHelper.update(board, "XXX------");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void crossPlayerWinRowTwo() {
        BoardHelper.update(board, "---XXX---");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void crossPlayerWinRowThree() {
        BoardHelper.update(board, "------XXX");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void crossPlayerWinColumnOne() {
        BoardHelper.update(board, "X--X--X--");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void crossPlayerWinColumnTwo() {
        BoardHelper.update(board, "-X--X--X-");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void crossPlayerWinColumnThree() {
        BoardHelper.update(board, "--X--X--X");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void noPlayerWin() {
        BoardHelper.update(board, "XOX------");

        assertFalse(board.win(Marks.CROSS));
    }

    @Test
    public void isNotATieWHenBoardNotFull() {
        BoardHelper.update(board, "XOX------");

        assertFalse(board.tie());
    }

    @Test
    public void crossPlayerWinDiagonnalOne() {
        BoardHelper.update(board, "X---X---X");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void crossPlayerWinDiagonnalTwo() {
        BoardHelper.update(board, "--X-X-X--");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void itIsATie() {
        BoardHelper.update(board, "XOXXOXOXO");

        assertTrue(board.tie());
    }

    @Test
    public void getFreePosition() {
        BoardHelper.update(board, "XOXOXO---");
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(6);
        arr.add(7);
        arr.add(8);
        assertEquals(board.freePosition(), arr);
    }

    @Test
    public void removeOneElement() {
        BoardHelper.update(board, "XOXOXO---");
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(6);
        arr.add(7);
        arr.add(8);
        assertEquals(board.freePosition(), arr);

        board.removeMark(1);
        arr.add(0, 1);
        assertEquals(board.freePosition(), arr);
    }
}

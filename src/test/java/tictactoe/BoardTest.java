package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
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
        setBoardState("XXX------");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void crossPlayerWinRowTwo() {
        setBoardState("---XXX---");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void crossPlayerWinRowThree() {
        setBoardState("------XXX");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void crossPlayerWinColumnOne() {
        setBoardState("X--X--X--");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void crossPlayerWinColumnTwo() {
        setBoardState("-X--X--X-");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void crossPlayerWinColumnThree() {
        setBoardState("--X--X--X");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void noPlayerWin() {
        setBoardState("XOX------");

        assertFalse(board.win(Marks.CROSS));
    }

    @Test
    public void isNotATieWHenBoardNotFull() {
        setBoardState("XOX------");

        assertFalse(board.tie());
    }

    @Test
    public void crossPlayerWinDiagonnalOne() {
        setBoardState("X---X---X");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void crossPlayerWinDiagonnalTwo() {
        setBoardState("--X-X-X--");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void itIsATie() {
        setBoardState("XOXXOXOXO");

        assertTrue(board.tie());
    }

    @Test
    public void getFreePosition() {
        setBoardState("XOXOXO---");
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(6);
        arr.add(7);
        arr.add(8);
        assertEquals(board.freePosition(), arr);
    }

    @Test
    public void removeOneElement() {
        setBoardState("XOXOXO---");
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(6);
        arr.add(7);
        arr.add(8);
        assertEquals(board.freePosition(), arr);

        board.removeMark(1);
        arr.add(0, 1);
        assertEquals(board.freePosition(), arr);
    }

    private void setBoardState(String stringBoard) {
        for (int i = 0; i < stringBoard.length(); i ++) {
            if (stringBoard.charAt(i) == 'X') {
                board.putMark(Marks.CROSS, i);
            }
            if (stringBoard.charAt(i) == 'O') {
                board.putMark(Marks.ROUND, i);
            }
        }
    }
}

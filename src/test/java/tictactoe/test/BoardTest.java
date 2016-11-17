package tictactoe.test;

import tictactoe.Board;
import tictactoe.Marks;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {
    private Board board;

    @Before
    public void initialize() {
        board = new Board();
    }

    @Test
    public void crossPlayerWinRowOne() throws Exception {
        setBoardState("XXX------");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void crossPlayerWinRowTwo() throws Exception {
        setBoardState("---XXX---");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void crossPlayerWinRowThree() throws Exception {
        setBoardState("------XXX");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void crossPlayerWinColumnOne() throws Exception {
        setBoardState("X--X--X--");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void crossPlayerWinColumnTwo() throws Exception {
        setBoardState("-X--X--X-");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void crossPlayerWinColumnThree() throws Exception {
        setBoardState("--X--X--X");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void noPlayerWin() throws Exception {
        setBoardState("XOX------");

        assertFalse(board.win(Marks.CROSS));
    }

    @Test
    public void isNotATieWHenBoardNotFull() throws Exception {
        setBoardState("XOX------");

        assertFalse(board.tie());
    }

    @Test
    public void crossPlayerWinDiagonnalOne() throws Exception {
        setBoardState("X---X---X");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void crossPlayerWinDiagonnalTwo() throws Exception {
        setBoardState("--X-X-X--");

        assertTrue(board.win(Marks.CROSS));
    }

    @Test
    public void itIsATie() throws Exception {
        setBoardState("XOXXOXOXO");

        assertTrue(board.tie());
    }

    private void setBoardState(String stringBoard) {
        for (int i = 0; i < stringBoard.length(); i ++) {
            if (stringBoard.charAt(i) == Marks.CROSS || stringBoard.charAt(i) == Marks.ROUND) {
                board.putMark(stringBoard.charAt(i), i);
            }
        }
    }
}

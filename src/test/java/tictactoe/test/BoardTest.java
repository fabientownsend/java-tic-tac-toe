package tictactoe.test;

import tictactoe.Board;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class BoardTest {
    private Board board;
    private char[][] expectedBoard;

    @Before
    public void initialize() {
        board = new Board();
        expectedBoard = new char[3][3];
    }

    @Test
    public void isEmpty() throws Exception {
        assertEquals(true, board.isEmpty());
    }

    @Test
    public void isNotEmptyWhenPartyStarted() throws Exception {
        stringToDoubleArray("-----X---");
        assertEquals(false, board.isEmpty());
    }

    @Test
    public void getEmptyBoard() throws Exception {
        char[][] emptyBoard = new char[3][3];

        assertEquals(emptyBoard, board.getContent());
    }

    @Test
    public void setPositionMiddleBoard() throws Exception {
        stringToDoubleArray("-----X---");
        expectedBoard[1][2] = 'X';

        assertEquals(expectedBoard, board.getContent());
    }

    @Test
    public void isAWinningBoard() throws Exception {
        stringToDoubleArray("XXX------");

        assertTrue(board.win('X'));
    }

    @Test
    public void isWinningBoardRow2() throws Exception {
        stringToDoubleArray("---XXX---");

        assertTrue(board.win('X'));
    }

    @Test
    public void isWinningBoardRow3() throws Exception {
        stringToDoubleArray("------XXX");

        assertTrue(board.win('X'));
    }

    @Test
    public void isWinningBoardColumn() throws Exception {
        stringToDoubleArray("X--X--X--");

        assertTrue(board.win('X'));
    }

    @Test
    public void isWinningBoardColumn2() throws Exception {
        stringToDoubleArray("-X--X--X-");

        assertTrue(board.win('X'));
    }

    @Test
    public void isWinningBoardColumn3() throws Exception {
        stringToDoubleArray("--X--X--X");

        assertTrue(board.win('X'));
    }

    @Test
    public void isNotAWinningBoard() throws Exception {
        stringToDoubleArray("XOX------");

        assertFalse(board.win('X'));
    }

    @Test
    public void isNotATie() throws Exception {
        stringToDoubleArray("XOX------");

        assertFalse(board.tie());
    }

    @Test
    public void winDiagonal() throws Exception {
        stringToDoubleArray("X---X---X");

        assertTrue(board.win('X'));
    }

    @Test
    public void winDiagonalBackward() throws Exception {
        stringToDoubleArray("--X-X-X--");

        assertTrue(board.win('X'));
    }

    @Test
    public void isATie() throws Exception {
        stringToDoubleArray("XOXXOXOXO");

        assertTrue(board.tie());
    }

    private void stringToDoubleArray(String stringBoard) {
        for (int i = 0; i < stringBoard.length(); i ++) {
            if (stringBoard.charAt(i) == 'X' || stringBoard.charAt(i) == 'O') {
                board.putMark(stringBoard.charAt(i), i);
            }
        }
    }
}

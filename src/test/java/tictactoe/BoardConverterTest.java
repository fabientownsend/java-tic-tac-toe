package tictactoe;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardConverterTest {
    @Test
    public void stringiphyAThreeByThreeBoard() {
        BoardConverter boardConverter = new BoardConverter();
        Marks[][] board = new Marks[3][3];
        String boardString = " 0 | 1 | 2 \n"
                           + "-----------\n"
                           + " 3 | 4 | 5 \n"
                           + "-----------\n"
                           + " 6 | 7 | 8 \n";

        assertEquals(boardString, boardConverter.toString(board));
    }

    @Test
    public void boardStringWithAMark() {
        BoardConverter boardConverter = new BoardConverter();
        Marks[][] board = new Marks[3][3];
        board[1][1] = Marks.CROSS;

        String boardString = " 0 | 1 | 2 \n"
                           + "-----------\n"
                           + " 3 | X | 5 \n"
                           + "-----------\n"
                           + " 6 | 7 | 8 \n";

        assertEquals(boardString, boardConverter.toString(board));
    }

    @Test
    public void stringiphyAFourByFourBoard() {
        BoardConverter boardConverter = new BoardConverter();
        Marks[][] board = new Marks[4][4];
        String boardString = "  0 |  1 |  2 |  3 \n"
                           + "-------------------\n"
                           + "  4 |  5 |  6 |  7 \n"
                           + "-------------------\n"
                           + "  8 |  9 | 10 | 11 \n"
                           + "-------------------\n"
                           + " 12 | 13 | 14 | 15 \n";

        assertEquals(boardString, boardConverter.toString(board));
    }

    @Test
    public void methodThatCenterAString() {
        BoardConverter boardConverter = new BoardConverter();
        assertEquals(boardConverter.center("test", 6), " test ");
    }

    @Test
    public void methodThatCenterAStringTwo() {
        BoardConverter boardConverter = new BoardConverter();
        assertEquals("  test  ", boardConverter.center("test", 8));
    }

    @Test
    public void handleTheCaseOfAnEvenString() {
        BoardConverter boardConverter = new BoardConverter();
        assertEquals("   est  ", boardConverter.center("est", 8));
    }

    @Test
    public void expectEvenWidth() {
        BoardConverter boardConverter = new BoardConverter();
        assertEquals(" 1 ", boardConverter.center("1", 3));
    }
    @Test
    public void expectEvenWidth2() {
        BoardConverter boardConverter = new BoardConverter();
        assertEquals("  1  ", boardConverter.center("1", 5));
    }

    @Test
    public void expectEvenWidth3() {
        BoardConverter boardConverter = new BoardConverter();
        assertEquals("  11  ", boardConverter.center("11", 6));
    }

    @Test
    public void expectEvenWidth4() {
        BoardConverter boardConverter = new BoardConverter();
        assertEquals("   11  ", boardConverter.center("11", 7));
    }
}

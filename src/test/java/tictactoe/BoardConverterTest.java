package tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}

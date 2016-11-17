package tictactoe.test;

import org.junit.Test;
import tictactoe.BoardConverter;
import tictactoe.Marks;

import static org.junit.Assert.*;

public class BoardConverterTest {
    @Test
    public void stringiphyAnArrayToString() throws Exception {
        BoardConverter boardConverter = new BoardConverter();
        char[][] board = new char[3][3];
        String boardString = " 0 | 1 | 2 \n"
                           + "-----------\n"
                           + " 3 | 4 | 5 \n"
                           + "-----------\n"
                           + " 6 | 7 | 8 \n";

        assertEquals(boardString, boardConverter.toString(board));
    }

    @Test
    public void boardStringWithAMark() throws Exception {
        BoardConverter cli = new BoardConverter();
        char[][] board = new char[3][3];
        board[1][1] = Marks.CROSS;

        String boardString = " 0 | 1 | 2 \n"
                           + "-----------\n"
                           + " 3 | X | 5 \n"
                           + "-----------\n"
                           + " 6 | 7 | 8 \n";

        assertEquals(boardString, cli.toString(board));
    }
}

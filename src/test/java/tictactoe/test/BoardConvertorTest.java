package tictactoe.test;

import org.junit.Test;
import tictactoe.BoardConvertor;
import tictactoe.Marks;

import static org.junit.Assert.*;

public class BoardConvertorTest {
    @Test
    public void stringiphyAnArrayToString() throws Exception {
        BoardConvertor boardConvertor = new BoardConvertor();
        char[][] board = new char[3][3];
        String boardString = " 0 | 1 | 2 \n"
                           + "-----------\n"
                           + " 3 | 4 | 5 \n"
                           + "-----------\n"
                           + " 6 | 7 | 8 \n";

        assertEquals(boardString, boardConvertor.toString(board));
    }

    @Test
    public void boardStringWithAMark() throws Exception {
        BoardConvertor cli = new BoardConvertor();
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

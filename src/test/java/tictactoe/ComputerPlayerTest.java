package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComputerPlayerTest {
    private Board board;
    private ComputerPlayer computer;

    @Before
    public void initialize() throws Exception {
        board = new Board();
        computer = new ComputerPlayer(Marks.CROSS, board);
    }

    @Test
    public void blockOpponantRow() throws Exception {
        setBoardState("X--OO-X--");
        assertEquals(computer.nextMove(), 5);
    }

    @Test
    public void blockOpponantColumn() throws Exception {
        setBoardState("OX-O-X---");
        assertEquals(computer.nextMove(), 6);
    }

    @Test
    public void blockOpponantDiagonal() throws Exception {
        setBoardState("OX--OX---");
        assertEquals(computer.nextMove(), 8);
    }

    @Test
    public void winRow() {
        setBoardState("X-X-O---O");
        assertEquals(computer.nextMove(), 1);
    }

    @Test
    public void winColumn() {
        setBoardState("XO-XO--XO");
        assertEquals(computer.nextMove(), 6);
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
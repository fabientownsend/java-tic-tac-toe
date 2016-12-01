package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComputerPlayerTest {
    private Board board;
    private ComputerPlayer computer;

    @Before
    public void initialize() {
        board = new Board();
        computer = new ComputerPlayer(Marks.CROSS, board);
    }

    @Test
    public void blockOpponentRow() {
        BoardHelper.update(board, "X--OO-X--");
        assertEquals(computer.nextMove(), 5);
    }

    @Test
    public void blockOpponentColumn() {
        BoardHelper.update(board, "OX-O-X---");
        assertEquals(computer.nextMove(), 6);
    }

    @Test
    public void blockOpponentDiagonal() {
        BoardHelper.update(board, "OX--OX---");
        assertEquals(computer.nextMove(), 8);
    }

    @Test
    public void winRow() {
        BoardHelper.update(board, "X-X-O---O");
        assertEquals(computer.nextMove(), 1);
    }

    @Test
    public void winColumn() {
        BoardHelper.update(board, "XO-XO--XO");
        assertEquals(computer.nextMove(), 6);
    }
}

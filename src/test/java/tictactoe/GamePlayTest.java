package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class GamePlayTest {
    private StringWriter out;
    private IO fakeCommandLine;
    private FakeBoard fakeBoard;
    private  GamePlay game;

    @Before
    public void initialize() {
        initialisationFakeIO("4\n0\n3\n1\n5\nn");
        this.fakeBoard = new FakeBoard();
        this.game = new GamePlay(fakeCommandLine, fakeBoard);
    }

    @Test
    public void computerVsComputer() throws Exception {
        initialisationFakeIO("4\n0\n3\n1\n5\nn");
        Board board = new Board();
        Player player_1 = new ComputerPlayer(Marks.CROSS, board);
        Player player_2 = new ComputerPlayer(Marks.ROUND, board);
        this.game = new GamePlay(fakeCommandLine, board, player_1, player_2);
        game.play();
        assertTrue(out.toString().contains("tie"));
    }

    @Test
    public void displayThePlayerTurn() throws Exception {
        game.play();
        assertTrue(out.toString().contains("CROSS turn"));
    }

    @Test
    public void rotatePlayer() throws Exception {
        fakeBoard.setTie(false);
        fakeBoard.setWin(false);
        game.play();
        assertTrue(out.toString().contains("ROUND turn"));
        assertTrue(out.toString().contains("O won the party"));
    }

    @Test
    public void displayMessageWinner() throws Exception {
        fakeBoard.setTie(false);
        fakeBoard.setWin(true);
        game.play();
        assertTrue(out.toString().contains("X won the party"));
    }

    @Test
    public void displayMessageItsATie() throws Exception {
        fakeBoard.setTie(true);
        fakeBoard.setWin(false);
        game.play();
        assertTrue(out.toString().contains("it's a tie"));
    }

    private void initialisationFakeIO(String text) {
        BufferedReader input = new BufferedReader(new StringReader(text));
        out = new StringWriter();
        PrintWriter output = new PrintWriter(out, true);

        fakeCommandLine = new FakeIO(input, output);
    }
}

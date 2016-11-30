package tictactoe;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.Assert.assertTrue;

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
    public void computerCantBeatComputerOnThreeByThreeBoard() {
        initialisationFakeIO("4\n0\n3\n1\n5\nn");
        Board board = new Board(3);
        Player player_1 = new ComputerPlayer(Marks.CROSS, board);
        Player player_2 = new ComputerPlayer(Marks.ROUND, board);
        this.game = new GamePlay(fakeCommandLine, board, player_1, player_2);
        game.play();
        assertTrue(out.toString().contains("tie"));
    }

    @Test(timeout = 18000)
    public void computerTake18secondsMaximumToFinishTheGame() {
        initialisationFakeIO("");
        Board board = new Board(3);
        Player player_1 = new ComputerPlayer(Marks.CROSS, board);
        Player player_2 = new ComputerPlayer(Marks.ROUND, board);
        this.game = new GamePlay(fakeCommandLine, board, player_1, player_2);
        game.play();
    }

    @Test
    public void computerCantBeatComputerOnFourByFourBoard() {
        initialisationFakeIO("4\n0\n3\n1\n5\nn");
        Board board = new Board(4);
        Player player_1 = new ComputerPlayer(Marks.CROSS, board);
        Player player_2 = new ComputerPlayer(Marks.ROUND, board);
        this.game = new GamePlay(fakeCommandLine, board, player_1, player_2);
        game.play();
        assertTrue(out.toString().contains("tie"));
    }

    @Test(timeout = 24000)
    public void computerTake24SecondsMaximumToFinishTheGame() {
        initialisationFakeIO("");
        Board board = new Board(4);
        Player player_1 = new ComputerPlayer(Marks.CROSS, board);
        Player player_2 = new ComputerPlayer(Marks.ROUND, board);
        this.game = new GamePlay(fakeCommandLine, board, player_1, player_2);
        game.play();
    }

    @Test
    public void displayThePlayerTurn() {
        game.play();
        assertTrue(out.toString().contains("CROSS turn"));
    }

    @Test
    public void rotatePlayer() {
        fakeBoard.setTie(false);
        fakeBoard.setWin(false);
        game.play();
        assertTrue(out.toString().contains("ROUND turn"));
        assertTrue(out.toString().contains("O won the party"));
    }

    @Test
    public void displayMessageWinner() {
        fakeBoard.setTie(false);
        fakeBoard.setWin(true);
        game.play();
        assertTrue(out.toString().contains("X won the party"));
    }

    @Test
    public void displayMessageItsATie() {
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

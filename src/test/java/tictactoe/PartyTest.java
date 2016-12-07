package tictactoe;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class PartyTest {
    private StringWriter out;
    private IO fakeCommandLine;
    private Party game;

    @Test
    public void displayErrorMessageWhenMoveTooLow() {
        initialisationFakeIO("-1\n1\n3\n2\n4\n0\n");
        Board board = new Board(3);
        Player player_1 = new CommandLinePlayer(fakeCommandLine, MarksEnum.CROSS);
        Player player_2 = new CommandLinePlayer(fakeCommandLine, MarksEnum.NOUGHT);
        game = new Party(fakeCommandLine, board, player_1, player_2);
        game.play();

        assertThat(out.toString()).contains("Move should be between 0 and 8");
    }

    @Test
    public void displayErrorMessageWhenMoveTooHight() {
        initialisationFakeIO("18\n1\n3\n2\n4\n0\n");
        Board board = new Board(3);
        Player player_1 = new CommandLinePlayer(fakeCommandLine, MarksEnum.CROSS);
        Player player_2 = new CommandLinePlayer(fakeCommandLine, MarksEnum.NOUGHT);
        game = new Party(fakeCommandLine, board, player_1, player_2);
        game.play();

        assertThat(out.toString()).contains("Move should be between 0 and 8");
    }

    @Test
    public void displayErrorMessageWhenSpotAlreadyUsed() {
        initialisationFakeIO("1\n1\n3\n2\n4\n0\n");
        Board board = new Board(3);
        Player player_1 = new CommandLinePlayer(fakeCommandLine, MarksEnum.CROSS);
        Player player_2 = new CommandLinePlayer(fakeCommandLine, MarksEnum.NOUGHT);
        game = new Party(fakeCommandLine, board, player_1, player_2);
        game.play();

        assertThat(out.toString()).contains("The position isn't free");
    }

    @Test
    public void computerCantBeatComputerOnThreeByThreeBoard() {
        initialisationFakeIO("4\n0\n3\n1\n5\nn");
        Board board = new Board(3);
        Player player_1 = new ComputerPlayer(MarksEnum.CROSS, board);
        Player player_2 = new ComputerPlayer(MarksEnum.NOUGHT, board);
        game = new Party(fakeCommandLine, board, player_1, player_2);
        game.play();

        assertThat(out.toString()).contains("tie");
    }

    @Test(timeout = 18000)
    public void computerTake18secondsMaximumToFinishTheGame() {
        initialisationFakeIO("");
        Board board = new Board(3);
        Player player_1 = new ComputerPlayer(MarksEnum.CROSS, board);
        Player player_2 = new ComputerPlayer(MarksEnum.NOUGHT, board);
        game = new Party(fakeCommandLine, board, player_1, player_2);
        game.play();
    }

    @Test
    public void computerCantBeatComputerOnFourByFourBoard() {
        initialisationFakeIO("4\n0\n3\n1\n5\nn");
        Board board = new Board(4);
        Player player_1 = new ComputerPlayer(MarksEnum.CROSS, board);
        Player player_2 = new ComputerPlayer(MarksEnum.NOUGHT, board);
        game = new Party(fakeCommandLine, board, player_1, player_2);
        game.play();

        assertTrue(out.toString().contains("tie"));
    }

    @Test(timeout = 24000)
    public void computerTake24SecondsMaximumToFinishTheGame() {
        initialisationFakeIO("");
        Board board = new Board(4);
        Player player_1 = new ComputerPlayer(MarksEnum.CROSS, board);
        Player player_2 = new ComputerPlayer(MarksEnum.NOUGHT, board);
        game = new Party(fakeCommandLine, board, player_1, player_2);
        game.play();
    }

    @Test
    public void rotatePlayer() {
        initialisationFakeIO("4\n0\n3\n1\n5\nn");
        Board board = BoardHelper.createBoard("XXX------");
        Player player_1 = new ComputerPlayer(MarksEnum.CROSS, board);
        Player player_2 = new ComputerPlayer(MarksEnum.NOUGHT, board);
        game = new Party(fakeCommandLine, board, player_1, player_2);
        game.play();

        assertThat(out.toString()).contains("X won the party");
    }

    @Test
    public void displayMessageWinner() {
        initialisationFakeIO("4\n0\n3\n1\n5\nn");
        Board board = BoardHelper.createBoard("OOO------");
        Player player_1 = new ComputerPlayer(MarksEnum.CROSS, board);
        Player player_2 = new ComputerPlayer(MarksEnum.NOUGHT, board);
        game = new Party(fakeCommandLine, board, player_1, player_2);
        game.play();

        assertThat(out.toString()).contains("O won the party");
    }

    private void initialisationFakeIO(String text) {
        BufferedReader input = new BufferedReader(new StringReader(text));
        out = new StringWriter();
        PrintWriter output = new PrintWriter(out, true);

        fakeCommandLine = new FakeIO(input, output);
    }
}

package tictactoe;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;


public class CommandLinePlayerTest {
    FakeIO fakeIO;
    StringWriter out;
    CommandLinePlayer player;

    @Before
    public void initialize() {
        this.player = new CommandLinePlayer(fakeIO, Marks.CROSS);
    }

    @Test
    public void getTheMarksOfThePlayer() {
        player = new CommandLinePlayer(fakeIO, Marks.CROSS);
        assertEquals(player.getMark(), Marks.CROSS);
    }

    @Test
    public void getTheMoveOfThePlayer() {
        initialisationFakeIO("1\n");
        player = new CommandLinePlayer(fakeIO, Marks.CROSS);
        assertEquals(player.nextMove(), 1);
    }

    @Test
    public void getAMessageWhenTheInputIsntAnInteger() {
        initialisationFakeIO("sd;fj\n1\n");
        player = new CommandLinePlayer(fakeIO, Marks.CROSS);
        assertEquals(player.nextMove(), 1);
        assertTrue(out.toString().contains("It must be an integer"));
    }

    private void initialisationFakeIO(String text) {
        BufferedReader input = new BufferedReader(new StringReader(text));
        out = new StringWriter();
        PrintWriter output = new PrintWriter(out, true);

        fakeIO = new FakeIO(input, output);
    }
}
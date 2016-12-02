package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class CommandLinePlayerTest {
    FakeIO fakeIO;
    StringWriter out;
    CommandLinePlayer player;

    @Before
    public void initialize() {
        this.player = new CommandLinePlayer(fakeIO, MarksEnum.CROSS);
    }

    @Test
    public void getTheMarksOfThePlayer() {
        player = new CommandLinePlayer(fakeIO, MarksEnum.CROSS);
        assertThat(player.getMark()).isEqualTo(MarksEnum.CROSS);
    }

    @Test
    public void getTheMoveOfThePlayer() {
        initialisationFakeIO("1\n");
        player = new CommandLinePlayer(fakeIO, MarksEnum.CROSS);
        assertThat(player.nextMove()).isEqualTo(1);
    }

    @Test
    public void getAMessageWhenTheInputIsntAnInteger() {
        initialisationFakeIO("sd;fj\n1\n");
        player = new CommandLinePlayer(fakeIO, MarksEnum.CROSS);
        assertThat(player.nextMove()).isEqualTo(1);
        assertThat(out.toString()).contains("It must be an integer");
    }

    private void initialisationFakeIO(String text) {
        BufferedReader input = new BufferedReader(new StringReader(text));
        out = new StringWriter();
        PrintWriter output = new PrintWriter(out, true);

        fakeIO = new FakeIO(input, output);
    }
}

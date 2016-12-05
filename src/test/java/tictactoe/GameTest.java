package tictactoe;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static org.assertj.core.api.Java6Assertions.*;

public class GameTest {
    private StringWriter out;
    private IO fakeCommandLine;

    @Test
    public void runOneParty() {
        initialisationFakeIO("3\n2\nno\n");
        Game game = new Game(fakeCommandLine);
        game.start();
        assertThat(out.toString()).contains("Do you want to replay? yes/no");
    }

    @Test
    public void askTwiceWhenReplayAnswerWrong() {
        initialisationFakeIO("3\n2\nrandomText\nno\n");
        Game game = new Game(fakeCommandLine);
        game.start();
        assertThat(out.toString()).contains("Do you want to replay? yes/no");
    }

    @Test
    public void runTwoParty() {
        initialisationFakeIO("3\n2\nyes\n3\n2\nno\n");
        Game game = new Game(fakeCommandLine);
        game.start();
        assertThat(out.toString()).contains("Do you want to replay? yes/no");
    }

    private void initialisationFakeIO(String text) {
        BufferedReader input = new BufferedReader(new StringReader(text));
        out = new StringWriter();
        PrintWriter output = new PrintWriter(out, true);

        fakeCommandLine = new FakeIO(input, output);
    }
}

package tictactoe.test;

import org.junit.Test;
import tictactoe.GamePlay;
import tictactoe.IOGame;

import java.io.*;

import static org.junit.Assert.assertTrue;

public class GamePlayTest {
    private StringWriter out;
    private IOGame fakeIO;

    @Test
    public void getTrueValues() throws Exception {
        // shouldn't play but inject a fake board and the see the reaction?
        initialisationFakeIO("4\n0\n3\n1\n5\nn");
        GamePlay gp = new GamePlay(fakeIO);
        gp.play();
        assertTrue(out.toString().contains("ended"));
    }

    private void initialisationFakeIO(String text) {
        BufferedReader input = new BufferedReader(new StringReader(text));
        out = new StringWriter();
        PrintWriter output = new PrintWriter(out, true);

        fakeIO = new FakeIO(input, output);
    }
}

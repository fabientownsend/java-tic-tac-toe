package tictactoe;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MenuTest {
    private StringWriter out;
    private IO fakeCommandLine;

    @Test
    public void displayMessageForBoardSize() {
        initialisationFakeIO("1\n");
        Menu menu = new Menu(fakeCommandLine);
        menu.sizeBoard(0, 5);
        assertTrue(out.toString().contains("Select board size: "));
    }

    @Test
    public void returnMinValueAsDefaultValueWhenInputEmpty() {
        initialisationFakeIO("\n");
        Menu menu = new Menu(fakeCommandLine);
        assertEquals(menu.sizeBoard(0, 5), 0);
    }

    @Test
    public void displayMessageForTypeGame() {
        initialisationFakeIO("1\n");
        Menu menu = new Menu(fakeCommandLine);
        menu.typeGame(0, 5);
        assertTrue(out.toString().contains("What kind of game do you want to play?"));
    }

    @Test
    public void returnTheUserInput() {
        initialisationFakeIO("1\n");
        Menu menu = new Menu(fakeCommandLine);
        assertEquals(menu.sizeBoard(0, 5), 1);
    }

    @Test
    public void askUntilToGetIntegerValue() {
        initialisationFakeIO("dsajfl;\n1\n");
        Menu menu = new Menu(fakeCommandLine);
        assertEquals(menu.sizeBoard(0, 5), 1);
        assertTrue(out.toString().contains("The value must be an integer"));
    }

    @Test
    public void askAgainWhenSizeTooBig() {
        initialisationFakeIO("55\n1\n");
        Menu menu = new Menu(fakeCommandLine);
        menu.sizeBoard(0, 5);
        assertTrue(out.toString().contains("Select value between: 0 and 5"));
    }

    @Test
    public void askAgainWhenSizeTooSmall() {
        initialisationFakeIO("-1234\n1\n");
        Menu menu = new Menu(fakeCommandLine);
        menu.sizeBoard(0, 5);
        assertTrue(out.toString().contains("Select value between: 0 and 5"));
    }


    private void initialisationFakeIO(String text) {
        BufferedReader input = new BufferedReader(new StringReader(text));
        out = new StringWriter();
        PrintWriter output = new PrintWriter(out, true);

        fakeCommandLine = new FakeIO(input, output);
    }
}

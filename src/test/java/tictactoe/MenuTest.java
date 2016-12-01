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
        initialisationFakeIO("3\n");
        Menu menu = new Menu(fakeCommandLine);
        menu.sizeBoard();
        assertTrue(out.toString().contains("Select board size: "));
    }

    @Test
    public void returnMinValueAsDefaultValueWhenInputEmpty() {
        initialisationFakeIO("\n");
        Menu menu = new Menu(fakeCommandLine);
        assertEquals(menu.sizeBoard(), 3);
    }

    @Test
    public void displayMessageForTypeGame() {
        initialisationFakeIO("1\n");
        Menu menu = new Menu(fakeCommandLine);
        menu.typeGame();
        assertTrue(out.toString().contains("What kind of game do you want to play?"));
    }

    @Test
    public void returnTheUserInput() {
        initialisationFakeIO("3\n");
        Menu menu = new Menu(fakeCommandLine);
        assertEquals(menu.sizeBoard(), 3);
    }

    @Test
    public void askUntilToGetIntegerValue() {
        initialisationFakeIO("dsajfl;\n3\n");
        Menu menu = new Menu(fakeCommandLine);
        assertEquals(menu.sizeBoard(), 3);
        assertTrue(out.toString().contains("The value must be an integer"));
    }

    @Test
    public void askAgainWhenSizeTooBig() {
        initialisationFakeIO("55\n3\n");
        Menu menu = new Menu(fakeCommandLine);
        menu.sizeBoard();
        assertTrue(out.toString().contains("Select value between: 3 and 5"));
    }

    @Test
    public void askAgainWhenSizeTooSmall() {
        initialisationFakeIO("-1234\n3\n");
        Menu menu = new Menu(fakeCommandLine);
        menu.sizeBoard();
        assertTrue(out.toString().contains("Select value between: 3 and 5"));
    }

    private void initialisationFakeIO(String text) {
        BufferedReader input = new BufferedReader(new StringReader(text));
        out = new StringWriter();
        PrintWriter output = new PrintWriter(out, true);

        fakeCommandLine = new FakeIO(input, output);
    }
}

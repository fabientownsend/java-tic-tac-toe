package tictactoe;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MenuTest {
    private StringWriter out;
    private IO fakeCommandLine;
    private Menu menu;

    @Test
    public void displayMessageForBoardSize() {
        initialisationMenuInput("3\n");
        menu.getBoardSize();
        assertTrue(out.toString().contains("Select board size: "));
    }

    @Test
    public void returnMinValueAsDefaultValueWhenInputEmpty() {
        initialisationMenuInput("\n");
        assertEquals(menu.getBoardSize(), 3);
    }

    @Test
    public void displayMessageForTypeGame() {
        initialisationMenuInput("1\n");
        menu.getGameType();
        assertTrue(out.toString().contains("What kind of game do you want to play?"));
    }

    @Test
    public void menuReturnHumanVsHumanGameType() {
        initialisationMenuInput("1\n");
        assertEquals(menu.getGameType(), GameTypes.HUMAN_VS_HUMAN);
    }

    @Test
    public void menuReturnHumanVsComputerGameType() {
        initialisationMenuInput("2\n");
        assertEquals(menu.getGameType(), GameTypes.HUMAN_VS_COMPUTER);
    }

    @Test
    public void menuReturnComputerVsComputerGameType() {
        initialisationMenuInput("3\n");
        assertEquals(menu.getGameType(), GameTypes.COMPUTER_VS_COMPUTER);
    }

    @Test
    public void returnTheUserInput() {
        initialisationMenuInput("3\n");
        assertThat(menu.getBoardSize()).isEqualTo(3);
    }

    @Test
    public void askUntilToGetIntegerValue() {
        initialisationMenuInput("text\n3\n");
        menu.getBoardSize();
        assertThat(out.toString()).contains("The value must be an integer");
    }

    @Test
    public void askAgainWhenSizeTooBig() {
        initialisationMenuInput("55\n3\n");
        menu.getBoardSize();
        assertThat(out.toString()).contains("Select value between: 3 and 5");
    }

    @Test
    public void askAgainWhenSizeTooSmall() {
        initialisationMenuInput("-1234\n3\n");
        menu.getBoardSize();
        assertThat(out.toString()).contains("Select value between: 3 and 5");
    }

    private void initialisationMenuInput(String text) {
        BufferedReader input = new BufferedReader(new StringReader(text));
        out = new StringWriter();
        PrintWriter output = new PrintWriter(out, true);

        fakeCommandLine = new FakeIO(input, output);
        menu = new Menu(fakeCommandLine);
    }
}

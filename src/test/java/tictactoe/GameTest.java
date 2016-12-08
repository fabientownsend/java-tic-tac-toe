package tictactoe;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class GameTest {
    private StringWriter out;
    private IO fakeCommandLine;

    @Test
    public void runOneParty() {
        initialisationFakeIO("3\n2\nno\n");
        PartyCreator partyCreatorSpy = new PartyCreator();
        Game game = new Game(fakeCommandLine, partyCreatorSpy);
        game.start();

        assertThat(partyCreatorSpy.getTotalPartyPlayed()).isEqualTo(1);
    }

    @Test
    public void askToReplayUntilValidAnswer() {
        initialisationFakeIO("3\n2\nrandomText\nno\n");
        PartyCreator pc = new PartyCreator();
        Game game = new Game(fakeCommandLine, pc);
        game.start();

        assertThat(pc.getTotalPartyPlayed()).isEqualTo(1);
    }

    @Test
    public void runTwoParty() {
        initialisationFakeIO("3\n2\nyes\n3\n2\nno\n");
        PartyCreator pc = new PartyCreator();
        Game game = new Game(fakeCommandLine, pc);
        game.start();

        assertThat(pc.getTotalPartyPlayed()).isEqualTo(2);
    }

    private void initialisationFakeIO(String text) {
        BufferedReader input = new BufferedReader(new StringReader(text));
        out = new StringWriter();
        PrintWriter output = new PrintWriter(out, true);

        fakeCommandLine = new FakeIO(input, output);
    }
}

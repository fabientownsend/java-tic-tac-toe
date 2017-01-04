package cli;

import org.junit.Test;
import tictactoe.Board;
import tictactoe.GameTypes;
import tictactoe.Party;

import static org.assertj.core.api.Assertions.assertThat;

public class PartyCreatorTest {
    @Test
    public void itCreatesAParties() {
        PartyCreator partyCreator = new PartyCreator();
        IO unusedIo = null;
        Party party = partyCreator.newParty(unusedIo, new Board(3), GameTypes.COMPUTER_VS_COMPUTER);
        assertThat(party).isNotNull();
    }
}

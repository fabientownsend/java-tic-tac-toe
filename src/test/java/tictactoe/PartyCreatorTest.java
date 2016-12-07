package tictactoe;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PartyCreatorTest {
    @Test
    public void itCreatesAParties() {
        PartyCreator partyCreator = new PartyCreator();
        IO unusedIo = null;
        Party party = partyCreator.newParty(unusedIo, 3, GameTypes.COMPUTER_VS_COMPUTER);
        assertThat(party).isNotNull();
    }
}

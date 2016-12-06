package tictactoe;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PartyCreatorTest {
    @Test
    public void itCreatesAParty() {
        PartyCreator partyCreator = new PartyCreator();
        GamePlay party = partyCreator.newParty(null, 3, GameTypes.COMPUTER_VS_COMPUTER);
        assertThat(party).isInstanceOf(GamePlay.class);
    }
}

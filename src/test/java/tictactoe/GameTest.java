package tictactoe;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class GameTest {
    @Test
    public void runOneParty() {
        IoMock ioMock = new IoMock("3\n2\nno\n");
        PartyCreator partyCreatorSpy = new PartyCreator();
        Game game = new Game(ioMock.getIoMocked(), partyCreatorSpy);
        game.start();

        assertThat(partyCreatorSpy.getTotalPartyPlayed()).isEqualTo(1);
    }

    @Test
    public void askToReplayUntilValidAnswer() {
        IoMock ioMock = new IoMock("3\n2\nrandomText\nno\n");
        PartyCreator partyCreatorSpy = new PartyCreator();
        Game game = new Game(ioMock.getIoMocked(), partyCreatorSpy);
        game.start();

        assertThat(partyCreatorSpy.getTotalPartyPlayed()).isEqualTo(1);
    }

    @Test
    public void runTwoParty() {
        IoMock ioMock = new IoMock("3\n2\nyes\n3\n2\nno\n");
        PartyCreator partyCreatorSpy = new PartyCreator();
        Game game = new Game(ioMock.getIoMocked(), partyCreatorSpy);
        game.start();

        assertThat(partyCreatorSpy.getTotalPartyPlayed()).isEqualTo(2);
    }
}

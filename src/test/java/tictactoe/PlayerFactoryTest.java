package tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerFactoryTest {
    @Test
    public void itCreateTwoCommandLinePlayers() {
        PlayerFactory playerFactory = new PlayerFactory(null, null);
        Player[] players = playerFactory.getPlayers("HUMANvsHUMAN");
        assertTrue(players[0] instanceof CommandLinePlayer);
        assertEquals(players[0].getMark(), Marks.CROSS);
        assertTrue(players[1] instanceof CommandLinePlayer);
        assertEquals(players[1].getMark(), Marks.ROUND);
    }

    @Test
    public void itCreateAComputerPlayerAndCommandLinePlayer() {
        PlayerFactory playerFactory = new PlayerFactory(null, null);
        Player[] players = playerFactory.getPlayers("HUMANvsCOMPUTER");
        assertTrue(players[0] instanceof CommandLinePlayer);
        assertEquals(players[0].getMark(), Marks.CROSS);
        assertTrue(players[1] instanceof ComputerPlayer);
        assertEquals(players[1].getMark(), Marks.ROUND);
    }

    @Test
    public void itCreateAComputerPlayerAndComputerPlayer() {
        PlayerFactory playerFactory = new PlayerFactory(null, null);
        Player[] players = playerFactory.getPlayers("COMPUTERvsCOMPUTER");
        assertTrue(players[0] instanceof ComputerPlayer);
        assertEquals(players[0].getMark(), Marks.CROSS);
        assertTrue(players[1] instanceof ComputerPlayer);
        assertEquals(players[1].getMark(), Marks.ROUND);
    }
}

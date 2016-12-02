package tictactoe;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerFactoryTest {
    @Test
    public void itCreateTwoCommandLinePlayers() {
        PlayerFactory playerFactory = new PlayerFactory(null, null);
        Player[] players = playerFactory.getPlayers(GameTypes.HUMAN_VS_HUMAN);

        assertThat(players[0]).isInstanceOf(CommandLinePlayer.class);
        assertThat(players[0].getMark()).isEqualTo(MarksEnum.CROSS);
        assertThat(players[1]).isInstanceOf(CommandLinePlayer.class);
        assertThat(players[1].getMark()).isEqualTo(MarksEnum.ROUND);
    }

    @Test
    public void itCreateAComputerPlayerAndCommandLinePlayer() {
        PlayerFactory playerFactory = new PlayerFactory(null, null);
        Player[] players = playerFactory.getPlayers(GameTypes.HUMAN_VS_COMPUTER);

        assertThat(players[0]).isInstanceOf(CommandLinePlayer.class);
        assertThat(players[0].getMark()).isEqualTo(MarksEnum.CROSS);
        assertThat(players[1]).isInstanceOf(ComputerPlayer.class);
        assertThat(players[1].getMark()).isEqualTo(MarksEnum.ROUND);
    }

    @Test
    public void itCreateAComputerPlayerAndComputerPlayer() {
        PlayerFactory playerFactory = new PlayerFactory(null, null);
        Player[] players = playerFactory.getPlayers(GameTypes.COMPUTER_VS_COMPUTER);

        assertThat(players[0]).isInstanceOf(ComputerPlayer.class);
        assertThat(players[0].getMark()).isEqualTo(MarksEnum.CROSS);
        assertThat(players[1]).isInstanceOf(ComputerPlayer.class);
        assertThat(players[1].getMark()).isEqualTo(MarksEnum.ROUND);
    }
}

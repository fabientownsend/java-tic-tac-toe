package tictactoe;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerFactoryTest {
    @Test
    public void itCreatesTwoCommandLinePlayers() {
        PlayerFactory playerFactory = new PlayerFactory(null, null);
        Player[] players = playerFactory.getPlayers(GameTypes.HUMAN_VS_HUMAN);

        assertThat(players[0]).isInstanceOf(CommandLinePlayer.class);
        assertThat(players[0].getMark()).isEqualTo(Marks.CROSS);
        assertThat(players[1]).isInstanceOf(CommandLinePlayer.class);
        assertThat(players[1].getMark()).isEqualTo(Marks.NOUGHT);
    }

    @Test
    public void itCreatesAComputerPlayerAndCommandLinePlayer() {
        PlayerFactory playerFactory = new PlayerFactory(null, null);
        Player[] players = playerFactory.getPlayers(GameTypes.HUMAN_VS_COMPUTER);

        assertThat(players[0]).isInstanceOf(CommandLinePlayer.class);
        assertThat(players[0].getMark()).isEqualTo(Marks.CROSS);
        assertThat(players[1]).isInstanceOf(ComputerPlayer.class);
        assertThat(players[1].getMark()).isEqualTo(Marks.NOUGHT);
    }

    @Test
    public void itCreatesAComputerPlayerAndComputerPlayer() {
        PlayerFactory playerFactory = new PlayerFactory(null, null);
        Player[] players = playerFactory.getPlayers(GameTypes.COMPUTER_VS_COMPUTER);

        assertThat(players[0]).isInstanceOf(ComputerPlayer.class);
        assertThat(players[0].getMark()).isEqualTo(Marks.CROSS);
        assertThat(players[1]).isInstanceOf(ComputerPlayer.class);
        assertThat(players[1].getMark()).isEqualTo(Marks.NOUGHT);
    }

    @Test
    public void itCreatesARandomPlayerAndComputerPlayer() {
        PlayerFactory playerFactory = new PlayerFactory(null, null);
        Player[] players = playerFactory.getPlayers(GameTypes.RANDOM_VS_COMPUTER);

        assertThat(players[0]).isInstanceOf(RandomPlayer.class);
        assertThat(players[0].getMark()).isEqualTo(Marks.CROSS);
        assertThat(players[1]).isInstanceOf(ComputerPlayer.class);
        assertThat(players[1].getMark()).isEqualTo(Marks.NOUGHT);
    }

    @Test
    public void itCreatesARandomPlayerAndRandomPlayer() {
        PlayerFactory playerFactory = new PlayerFactory(null, null);
        Player[] players = playerFactory.getPlayers(GameTypes.RANDOM_VS_RANDOM);

        assertThat(players[0]).isInstanceOf(RandomPlayer.class);
        assertThat(players[0].getMark()).isEqualTo(Marks.CROSS);
        assertThat(players[1]).isInstanceOf(RandomPlayer.class);
        assertThat(players[1].getMark()).isEqualTo(Marks.NOUGHT);
    }

    @Test
    public void itCreatesARandomPlayerAndHumanPlayer() {
        PlayerFactory playerFactory = new PlayerFactory(null, null);
        Player[] players = playerFactory.getPlayers(GameTypes.RANDOM_VS_HUMAN);

        assertThat(players[0]).isInstanceOf(RandomPlayer.class);
        assertThat(players[0].getMark()).isEqualTo(Marks.CROSS);
        assertThat(players[1]).isInstanceOf(CommandLinePlayer.class);
        assertThat(players[1].getMark()).isEqualTo(Marks.NOUGHT);
    }
}

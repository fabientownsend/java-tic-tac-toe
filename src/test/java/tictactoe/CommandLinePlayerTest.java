package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class CommandLinePlayerTest {
    FakeIO fakeIO;
    CommandLinePlayer player;

    @Before
    public void initialize() {
        this.player = new CommandLinePlayer(fakeIO, Marks.CROSS);
    }

    @Test
    public void getTheMarksOfThePlayer() {
        player = new CommandLinePlayer(fakeIO, Marks.CROSS);
        assertThat(player.getMark()).isEqualTo(Marks.CROSS);
    }

    @Test
    public void getTheMoveOfThePlayer() {
        IoMock ioMock = new IoMock("1\n");
        player = new CommandLinePlayer(ioMock.getIoMocked(), Marks.CROSS);
        assertThat(player.nextMove()).isEqualTo(1);
    }

    @Test
    public void getAMessageWhenTheInputIsntAnInteger() {
        IoMock ioMock = new IoMock("sd;fj\n1\n");
        player = new CommandLinePlayer(ioMock.getIoMocked(), Marks.CROSS);
        assertThat(player.nextMove()).isEqualTo(1);
        assertThat(ioMock.getOutpout()).contains("It must be an integer");
    }
}

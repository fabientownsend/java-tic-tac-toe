package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class CommandLinePlayerTest {
    FakeIO fakeIO;
    HumanPlayer player;

    @Before
    public void initialize() {
        this.player = new HumanPlayer(fakeIO, Marks.CROSS);
    }

    @Test
    public void getTheMarksOfThePlayer() {
        player = new HumanPlayer(fakeIO, Marks.CROSS);
        assertThat(player.getMark()).isEqualTo(Marks.CROSS);
    }

    @Test
    public void getTheMoveOfThePlayer() {
        IoMock ioMock = new IoMock("1\n");
        player = new HumanPlayer(ioMock.getIoMocked(), Marks.CROSS);
        assertThat(player.nextMove()).isEqualTo(1);
    }

    @Test
    public void getAMessageWhenTheInputIsntAnInteger() {
        IoMock ioMock = new IoMock("sd;fj\n1\n");
        player = new HumanPlayer(ioMock.getIoMocked(), Marks.CROSS);
        assertThat(player.nextMove()).isEqualTo(1);
        assertThat(ioMock.getOutpout()).contains("It must be an integer");
    }
}

package cli;

import org.junit.Before;
import org.junit.Test;
import tictactoe.Board;
import tictactoe.Marks;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class HumanPlayerTest {
    FakeIO fakeIO;
    HumanPlayer player;

    @Before
    public void initialize() {
        this.player = new HumanPlayer(fakeIO, Marks.CROSS, new Board());
    }

    @Test
    public void getTheMarksOfThePlayer() {
        player = new HumanPlayer(fakeIO, Marks.CROSS, new Board());
        assertThat(player.getMark()).isEqualTo(Marks.CROSS);
    }

    @Test
    public void getTheMoveOfThePlayer() {
        IoMock ioMock = new IoMock("1\n");
        player = new HumanPlayer(ioMock.getIoMocked(), Marks.CROSS, new Board());
        assertThat(player.nextMove()).isEqualTo(1);
    }

    @Test
    public void getAMessageWhenTheInputIsntAnInteger() {
        IoMock ioMock = new IoMock("sd;fj\n1\n");
        player = new HumanPlayer(ioMock.getIoMocked(), Marks.CROSS, new Board());
        assertThat(player.nextMove()).isEqualTo(1);
        assertThat(ioMock.getOutpout()).contains("It must be an integer");
    }

    @Test
    public void displayErrorMessageWhenSpotAlreadyUsed() {
        Board board = new Board(3);
        board.putMark(Marks.CROSS, 0);
        IoMock ioMock = new IoMock("0\n1\n");
        HumanPlayer humanPlayer = new HumanPlayer(ioMock.getIoMocked(), Marks.NOUGHT, board);

        int validMove = humanPlayer.nextMove();

        assertThat(ioMock.getOutpout()).contains("The position isn't free");
        assertThat(validMove).isEqualTo(1);
    }

    @Test
    public void displayErrorMessageWhenSpotTooLow() {
        Board board = new Board();
        IoMock ioMock = new IoMock("-1\n1\n");
        HumanPlayer humanPlayer = new HumanPlayer(ioMock.getIoMocked(), Marks.NOUGHT, board);

        int validMove = humanPlayer.nextMove();

        assertThat(ioMock.getOutpout()).contains("The position should be between 0 and 8");
        assertThat(validMove).isEqualTo(1);
    }
}

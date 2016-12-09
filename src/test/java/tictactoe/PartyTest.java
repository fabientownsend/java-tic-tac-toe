package tictactoe;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PartyTest {
    private Party party;

    @Test
    public void displayErrorMessageWhenMoveTooLow() {
        IoMock ioMock = new IoMock("-1\n1\n3\n2\n4\n0\n");
        party = createGameWithTwoHumanPlayer(ioMock);
        party.play();

        assertThat(ioMock.getOutpout()).contains("Move should be between 0 and 8");
    }

    @Test
    public void displayErrorMessageWhenMoveTooHight() {
        IoMock ioMock = new IoMock("-1\n1\n3\n2\n4\n0\n");
        party = createGameWithTwoHumanPlayer(ioMock);
        party.play();

        assertThat(ioMock.getOutpout()).contains("Move should be between 0 and 8");
    }

    @Test
    public void displayErrorMessageWhenSpotAlreadyUsed() {
        IoMock ioMock = new IoMock("1\n1\n3\n2\n4\n0\n");
        party = createGameWithTwoHumanPlayer(ioMock);
        party.play();

        assertThat(ioMock.getOutpout()).contains("The position isn't free");
    }

    private Party createGameWithTwoHumanPlayer(IoMock mock) {
        Board board = new Board(3);
        Player player_1 = new CommandLinePlayer(mock.getIoMocked(), Marks.CROSS);
        Player player_2 = new CommandLinePlayer(mock.getIoMocked(), Marks.NOUGHT);
        return new Party(mock.getIoMocked(), board, player_1, player_2);
    }

    @Test
    public void computerCantBeatComputerOnThreeByThreeBoard() {
        IoMock ioMock = new IoMock();
        party = createGameWithTwoComputerPlayers(ioMock, 3);
        party.play();

        assertThat(ioMock.getOutpout()).contains("tie");
    }

    @Test(timeout = 18000)
    public void computerTake18secondsMaximumToFinishTheGame() {
        IoMock ioMock = new IoMock();
        party = createGameWithTwoComputerPlayers(ioMock, 3);
        party.play();
    }

    @Test
    public void computerCantBeatComputerOnFourByFourBoard() {
        IoMock ioMock = new IoMock();
        party = createGameWithTwoComputerPlayers(ioMock, 4);
        party.play();

        assertThat(ioMock.getOutpout()).contains("tie");
    }

    @Test(timeout = 24000)
    public void computerTake24SecondsMaximumToFinishTheGame() {
        IoMock ioMock = new IoMock();
        party = createGameWithTwoComputerPlayers(ioMock, 4);
        party.play();
    }

    private Party createGameWithTwoComputerPlayers(IoMock ioMock, int boardSize) {
        ioMock.createIoMock("");
        Board board = new Board(boardSize);
        Player player_1 = new ComputerPlayer(Marks.CROSS, board);
        Player player_2 = new ComputerPlayer(Marks.NOUGHT, board);
        return new Party(ioMock.getIoMocked(), board, player_1, player_2);
    }

    @Test
    public void rotatePlayer() {
        IoMock ioMock = new IoMock();
        party = createGameWithTwoComputerPlayers(ioMock, "XXX------");
        party.play();

        assertThat(ioMock.getOutpout()).contains("X won the party");
    }

    @Test
    public void displayMessageWinner() {
        IoMock ioMock = new IoMock();
        party = createGameWithTwoComputerPlayers(ioMock, "OOO------");
        party.play();

        assertThat(ioMock.getOutpout()).contains("O won the party");
    }

    private Party createGameWithTwoComputerPlayers(IoMock ioMock, String stringBoard) {
        Board board = BoardHelper.createBoard(stringBoard);
        Player player_1 = new ComputerPlayer(Marks.CROSS, board);
        Player player_2 = new ComputerPlayer(Marks.NOUGHT, board);
        return new Party(ioMock.getIoMocked(), board, player_1, player_2);
    }
}

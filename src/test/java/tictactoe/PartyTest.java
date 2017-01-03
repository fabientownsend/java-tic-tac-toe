package tictactoe;

import org.junit.Test;
import tictactoe.players.ComputerPlayer;
import tictactoe.players.Player;

public class PartyTest {
    private Party party;

    @Test(timeout = 18000)
    public void computerTake18secondsMaximumToFinishTheGame() {
        IoMock ioMock = new IoMock();
        party = createGameWithTwoComputerPlayers(ioMock, 3);
        party.play();
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
        return new Party(board, player_1, player_2);
    }
}

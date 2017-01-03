package tictactoe.players;

import tictactoe.Board;
import tictactoe.GameTypes;
import tictactoe.IO;
import tictactoe.Marks;

public class PlayerFactory {
    private IO io;
    private Board board;
    private Player[] players = new Player[2];

    public PlayerFactory(IO io, Board board) {
        this.io = io;
        this.board = board;
    }

    public Player[] getPlayers(GameTypes gameType) {
        if (gameType == GameTypes.HUMAN_VS_COMPUTER) {
            return createHumanVsComputer();
        } else if (gameType == GameTypes.COMPUTER_VS_COMPUTER) {
            return createComputerVsComputer();
        } else if (gameType == GameTypes.RANDOM_VS_COMPUTER) {
            return createRandomVsComputer();
        } else if (gameType == GameTypes.RANDOM_VS_HUMAN) {
            return createRandomVsHuman();
        } else if (gameType == GameTypes.RANDOM_VS_RANDOM) {
            return createRandomVsRandom();
        } else {
            return createHumanVsHuman();
        }
    }

    private Player[] createHumanVsHuman() {
        players[0] = new HumanPlayer(io, Marks.CROSS, board);
        players[1] = new HumanPlayer(io, Marks.NOUGHT, board);
        return players;
    }

    private Player[] createHumanVsComputer() {
        players[0] = new HumanPlayer(io, Marks.CROSS, board);
        players[1] = new ComputerPlayer(Marks.NOUGHT, board);
        return players;
    }

    private Player[] createComputerVsComputer() {
        players[0] = new ComputerPlayer(Marks.CROSS, board);
        players[1] = new ComputerPlayer(Marks.NOUGHT, board);
        return players;
    }

    private Player[] createRandomVsComputer() {
        players[0] = new RandomPlayer(Marks.CROSS, board);
        players[1] = new ComputerPlayer(Marks.NOUGHT, board);
        return players;
    }

    private Player[] createRandomVsHuman() {
        players[0] = new RandomPlayer(Marks.CROSS, board);
        players[1] = new HumanPlayer(io, Marks.NOUGHT, board);
        return players;
    }

    private Player[] createRandomVsRandom() {
        players[0] = new RandomPlayer(Marks.CROSS, board);
        players[1] = new RandomPlayer(Marks.NOUGHT, board);
        return players;
    }

}

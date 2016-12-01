package tictactoe;

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
        } else {
            return createHumanVsHuman();
        }
    }

    private Player[] createHumanVsHuman() {
        players[0] = new CommandLinePlayer(io, Marks.CROSS);
        players[1] = new CommandLinePlayer(io, Marks.ROUND);
        return players;
    }

    private Player[] createHumanVsComputer() {
        players[0] = new CommandLinePlayer(io, Marks.CROSS);
        players[1] = new ComputerPlayer(Marks.ROUND, board);
        return players;
    }

    private Player[] createComputerVsComputer() {
        players[0] = new ComputerPlayer(Marks.CROSS, board);
        players[1] = new ComputerPlayer(Marks.ROUND, board);
        return players;
    }
}

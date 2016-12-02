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
        players[0] = new CommandLinePlayer(io, MarksEnum.CROSS);
        players[1] = new CommandLinePlayer(io, MarksEnum.ROUND);
        return players;
    }

    private Player[] createHumanVsComputer() {
        players[0] = new CommandLinePlayer(io, MarksEnum.CROSS);
        players[1] = new ComputerPlayer(MarksEnum.ROUND, board);
        return players;
    }

    private Player[] createComputerVsComputer() {
        players[0] = new ComputerPlayer(MarksEnum.CROSS, board);
        players[1] = new ComputerPlayer(MarksEnum.ROUND, board);
        return players;
    }
}

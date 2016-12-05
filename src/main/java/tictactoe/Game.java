package tictactoe;

public class Game {
    private IO io;
    private Menu menu;
    private Board board;
    private Player[] players;
    private final String REPLAY_REQUEST = "Do you want to replay? yes/no";
    private final String YES = "yes";
    private final String NO = "no";

    public Game(IO io) {
        this.io = io;
        this.menu = new Menu(io);
    }

    public void start() {
        do {
            initialisationBoard();
            initialisationPlayers();
            GamePlay party = initialisationParty();
            party.play();
        } while (replay());
    }

    private void initialisationBoard() {
        int boardSize = menu.getBoardSize();
        board = new Board(boardSize);
    }

    private void initialisationPlayers() {
        PlayerFactory playerFactory = new PlayerFactory(io, board);
        GameTypes gameType = menu.getGameType();
        players = playerFactory.getPlayers(gameType);
    }

    private GamePlay initialisationParty() {
        return new GamePlay(io, board, players[0], players[1]);
    }

    private boolean replay() {
        io.write(REPLAY_REQUEST);
        String answer = io.read();

        if (answer.equals(YES)) {
            return true;
        } else if (answer.equals(NO)) {
            return false;
        } else {
            return replay();
        }
    }
}

package tictactoe;

public class Game {
    private IO io;
    private Menu menu;
    private Board board;
    private Player[] players;

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
        } while (menu.replay());
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

}

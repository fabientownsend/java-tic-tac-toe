package tictactoe;

public class Game {
    private IO io;
    private Menu menu;

    public Game(IO io) {
        this.io = io;
        this.menu = new Menu(io);
    }

    public Game(IO io, PartyCreator partyCreator) {
        this(io);
    }

    public void start() {
        do {
            int boardSize = menu.getBoardSize();
            GameTypes gameType = menu.getGameType();

            PartyCreator.newParty(io, boardSize, gameType).play();
        } while (menu.replay());
    }
}

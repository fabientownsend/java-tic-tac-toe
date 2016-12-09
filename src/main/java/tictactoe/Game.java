package tictactoe;

public class Game {
    private IO io;
    private Menu menu;
    private PartyCreator partyCreator;

    public Game(IO io, PartyCreator partyCreator) {
        this.io = io;
        this.menu = new Menu(io);
        this.partyCreator = partyCreator;
    }

    public void start() {
        do {
            int boardSize = menu.getBoardSize();
            GameTypes gameType = menu.getGameType();

            partyCreator.newParty(io, boardSize, gameType).play();
        } while (menu.replay());
    }
}

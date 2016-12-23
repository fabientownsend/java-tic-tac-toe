package fx;

import tictactoe.Party;

public class GameEvent {
    private Move move;
    private Party party;
    private Desktop desktop;

    public GameEvent(Move move, Party party, Desktop desktop) {
        this.move = move;
        this.party = party;
        this.desktop = desktop;
    }

    public void updateWindow(int idTile) {
        move.setNewMove(idTile);
        party.play();
        desktop.refreshWindows();
    }
}

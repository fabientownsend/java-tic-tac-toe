package fx;

import tictactoe.PartyV2;

public class GameEvent {
    private Move move;
    private PartyV2 party;
    private Desktop desktop;

    public GameEvent(Move move, PartyV2 party, Desktop desktop) {
        this.move = move;
        this.party = party;
        this.desktop = desktop;
    }

    public void updateSituation(int idTile) {
        move.setNewMove(idTile);
        party.play();
        desktop.refreshWindows();
    }
}

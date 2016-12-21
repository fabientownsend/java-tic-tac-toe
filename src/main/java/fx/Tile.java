package fx;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import tictactoe.PartyV2;

public class Tile extends Rectangle {
    private Move move;
    private final int idTile;
    private PartyV2 party;
    private Desktop desktop;

    public Tile(int x, int y, int width, int idTile, Move move, PartyV2 party, Desktop desktop) {
        this.desktop = desktop;
        this.party = party;
        this.move = move;
        this.idTile = idTile;
        this.setWidth(width);
        this.setHeight(width);
        relocate(x * width, y * width);
        setFill(Color.WHITE);
        setId("id_tile_" + idTile);

        setStroke(Color.BLACK);
        setStrokeWidth(5);

        setOnMouseClicked(e -> this.updateMove() );
    }

    private void updateMove() {
        move.setNewMove(idTile);
        party.play();
        desktop.refreshWindows();
        System.out.println(idTile);
    }
}

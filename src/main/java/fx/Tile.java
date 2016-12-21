package fx;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
    private final int idTile;
    private GameEvent gameEvent;

    public Tile(int x, int y, int width, int idTile, GameEvent gameEvent) {
        this.gameEvent = gameEvent;
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
        gameEvent.updateSituation(idTile);
    }
}

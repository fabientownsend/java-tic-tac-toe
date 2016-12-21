package fx;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
    private Move move;
    private final int idTile;

    public Tile(int x, int y, int width, int idTile, Move move) {
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
        System.out.println(idTile);
    }
}

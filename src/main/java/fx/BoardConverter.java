package fx;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import tictactoe.Marks;

public class BoardConverter {
    private final int TILE_SIZE = 100;
    private GameEvent gameEvent;

    public BoardConverter(GameEvent gameEvent) {
        this.gameEvent = gameEvent;
    }

    public Pane makeBoard(Marks[][] board) {
        Pane boardPane = new Pane();
        Group tiles = new Group();
        Group marks = new Group();

        boardPane.setPrefSize(board.length * TILE_SIZE, board.length * TILE_SIZE);
        boardPane.getChildren().addAll(tiles, marks);

        int idTile = 0;
        for (int y  = 0; y < board.length; y++) {
            for (int x = 0; x < board.length; x++) {
                Tile tile = new Tile(x, y, TILE_SIZE, idTile, gameEvent);
                idTile++;
                makeTile(tiles, tile);

                Marks mark = board[x][y];
                if (mark != null) {
                    makeMark(board[x][y], marks, x, y);
                }
            }
        }

        return boardPane;
    }

    private void makeMark(Marks mark, Group marksGroup, int y, int x) {
        MarkBuilder markPane = new MarkBuilder(x, y, TILE_SIZE);
        markPane.make(mark);
        marksGroup.getChildren().add(markPane);
    }

    private void makeTile(Group tileGroup, Tile tile) {
        tileGroup.getChildren().add(tile);
    }
}

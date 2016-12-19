package fx;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import tictactoe.Marks;

public class BoardConverter {
    private final int TILE_SIZE = 100;

    public Pane createBoard(Marks[][] board, Move mov) {
        Move move = mov;
        Pane boardPane = new Pane();
        Group tiles = new Group();
        Group marks = new Group();

        boardPane.setPrefSize(board.length * TILE_SIZE, board.length * TILE_SIZE);
        Button button = new Button();
        // button.setOnAction(event -> Main.party.play());
        boardPane.getChildren().addAll(tiles, marks);

        int idTile = 0;
        for (int y  = 0; y < board.length; y++) {
            for (int x = 0; x < board.length; x++) {
                Tile tile = new Tile(x, y, TILE_SIZE, idTile, move);
                idTile++;
                createTile(tiles, tile);

                Marks mark = board[x][y];
                if (mark != null) {
                    createMarkPane(board[x][y], marks, y, x);
                }
            }
        }

        return boardPane;
    }

    private void createMarkPane(Marks mark, Group marksGroup, int y, int x) {
        MarkPane markPane = new MarkPane(x, y, TILE_SIZE);
        markPane.create(mark);
        marksGroup.getChildren().add(markPane);
    }

    private void createTile(Group tileGroup, Tile tile) {
        tileGroup.getChildren().add(tile);
    }
}

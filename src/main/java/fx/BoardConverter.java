package fx;

import javafx.scene.Group;
import javafx.scene.layout.Pane;

import tictactoe.Marks;
import tictactoe.PartyV2;

public class BoardConverter {
    private final int TILE_SIZE = 100;

    public Pane makeBoard(Marks[][] board, Move mov, PartyV2 party, Desktop desktop) {
        Move move = mov;
        Pane boardPane = new Pane();
        Group tiles = new Group();
        Group marks = new Group();

        boardPane.setPrefSize(board.length * TILE_SIZE, board.length * TILE_SIZE);
        boardPane.getChildren().addAll(tiles, marks);

        int idTile = 0;
        for (int y  = 0; y < board.length; y++) {
            for (int x = 0; x < board.length; x++) {
                Tile tile = new Tile(x, y, TILE_SIZE, idTile, move, party, desktop);
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

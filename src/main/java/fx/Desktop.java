
package fx;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tictactoe.Board;
import tictactoe.PartyV2;

public class Desktop extends VBox {
    private Stage primaryStage;
    private BoardConverter boardConverter;
    private Move move;
    private Scene scene;
    private boolean isReady = false;
    private Pane convertedBoard;
    private Label label;
    private BorderPane boarderPane;
    private PartyV2 party;
    private Board board;

    public Desktop(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.boardConverter = new BoardConverter();
        this.move = new Move();

        label = new Label();
        label.setText("Welcome to Tic-Tac-Toe");
        label.setId("my_label");
    }

    public Desktop(Stage primaryStage, Move move, PartyV2 party, Board board) {
        this.board = board;
        this.party = party;
        this.primaryStage = primaryStage;
        this.boardConverter = new BoardConverter();
        this.move = move;

        label = new Label();
        label.setText("Welcome to Tic-Tac-Toe");
        label.setId("my_label");
        refreshWindows();
    }

    public Scene getCurrentScene() {
        return scene;
    }

    public boolean isReady() {
        if (move.hasChanged()) {
            isReady = true;
        } else {
            isReady = false;
        }

        return isReady;
    }

    public void refreshWindows() {
        convertedBoard = boardConverter.createBoard(board.getContent(), move, party, this);

        boarderPane = new BorderPane();
        boarderPane.setTop(label);
        boarderPane.setCenter(convertedBoard);

        scene = new Scene(boarderPane);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}


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
    private Scene scene;
    private Label label;
    private BorderPane boarderPane;
    private Board board;
    private GameEvent gameEvent;
    private PartyV2 party;

    public Desktop(Stage primaryStage, Move move, PartyV2 party, Board board) {
        this.gameEvent = new GameEvent(move, party, this);
        this.board = board;
        this.party = party;

        this.primaryStage = primaryStage;
        this.boardConverter = new BoardConverter(gameEvent);

        label = new Label();
        label.setText("Welcome to Tic-Tac-Toe");
        label.setId("my_label");
        refreshWindows();
    }

    public Scene getCurrentScene() {
        return scene;
    }

    public void refreshWindows() {
        Pane convertedBoard = boardConverter.makeBoard(board.getContent());

        updateMessage();
        boarderPane = new BorderPane();
        boarderPane.setTop(label);
        boarderPane.setCenter(convertedBoard);

        scene = new Scene(boarderPane);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    private void updateMessage() {
        if (party.isTie()) {
            label.setText("It's a tie");
        } else if (party.currentPlayerWon()) {
            label.setText(party.getCurrentPlayerMark() + " win the party");
        } else {
            label.setText(party.getCurrentPlayerMark() + " turn");
        }
    }
}

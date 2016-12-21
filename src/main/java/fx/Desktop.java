package fx;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tictactoe.IO;
import tictactoe.Marks;

public class Desktop extends VBox implements IO {
    private Stage primaryStage;
    private BoardConverter boardConverter;
    private Move move;
    private Scene scene;
    private boolean isReady = false;
    private Pane convertedBoard;
    private Label label;
    private BorderPane boarderPane;

    public Desktop(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.boardConverter = new BoardConverter();
        this.move = new Move();

        label = new Label();
        label.setText("Welcome to Tic-Tac-Toe");
        label.setId("my_label");
    }

    public Scene getCurrentScene() {
        return scene;
    }

    public void write(String textToDisplay) {
        label.setText(textToDisplay);
    }

    public boolean isReady() {
        if (move.hasChanged()) {
            isReady = true;
        } else {
            isReady = false;
        }

        return isReady;
    }

    public String read() {
        return Integer.toString(move.getLastMove());
    }

    public void displayBoard(Marks[][] board) {
        refreshWindows(board);
    }

    private void refreshWindows(Marks[][] board) {
        convertedBoard = boardConverter.createBoard(board, move);

        boarderPane = new BorderPane();
        boarderPane.setTop(label);
        boarderPane.setCenter(convertedBoard);

        scene = new Scene(boarderPane);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}

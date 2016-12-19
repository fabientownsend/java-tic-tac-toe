package fx;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import tictactoe.IO;
import tictactoe.Marks;

public class Desktop implements IO {
    private Stage primaryStage;
    private BoardConverter boardConverter;
    private final String TITLE = "Tic-Tac-Toe";
    private Move move;
    private Scene scene;
    private boolean isReady = false;

    public Desktop(Stage primaryStage, Marks[][] board) {
        this.primaryStage = primaryStage;
        this.boardConverter = new BoardConverter();
        this.move = new Move();

        Pane root = boardConverter.createBoard(board, move);
        scene = new Scene(root);
        primaryStage.setTitle(TITLE);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public void write(String textToDisplay) {
        // Not implemented yet
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
        Pane root = boardConverter.createBoard(board, move);
        scene = new Scene(root);
        primaryStage.setTitle(TITLE);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}

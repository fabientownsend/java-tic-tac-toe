package fx;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tictactoe.IO;
import tictactoe.Marks;

import java.util.Arrays;
import java.util.LinkedList;

public class Desktop implements IO {
    private Stage primaryStage;
    private BoardConverter boardConverter;
    private final String TITLE = "Tic-Tac-Toe";
    private LinkedList<String> hardCodedPlayersPositionsSelected;
    private Move move;
    private Scene scene;
    public static boolean isReady = false;

    public Desktop(Stage primaryStage, Marks[][] board) {
        this.primaryStage = primaryStage;
        this.boardConverter = new BoardConverter();
        this.move = new Move();

        this.hardCodedPlayersPositionsSelected = new LinkedList<>(Arrays.asList("0", "1", "4", "2", "8"));

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
        return isReady;
    }

    public String read() {
        isReady = false;
        if (move.hasChanged()) {
            return Integer.toString(move.getLastMove());
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return read();
        }
        //return hardCodedPlayersPositionsSelected.pop();
    }

    public void displayBoard(Marks[][] board) {
        // scene.setRoot(boardConverter.createBoard(board, move));
        Pane root = boardConverter.createBoard(board, move);
        scene = new Scene(root);
        primaryStage.setTitle(TITLE);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}

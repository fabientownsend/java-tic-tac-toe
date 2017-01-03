package fx;

import javafx.application.Application;
import javafx.stage.Stage;

import tictactoe.Board;
import tictactoe.Marks;
import tictactoe.Party;
import tictactoe.players.Player;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Board board = new Board();
        Move move = new Move();
        Player desktopPlayer = new DesktopPlayer(move, Marks.CROSS);
        Player desktopPlayer2 = new DesktopPlayer(move, Marks.NOUGHT);
        Party party = new Party(board, desktopPlayer, desktopPlayer2);

        Desktop desktop = new Desktop(move, party, board);
        stage.setScene(desktop.getCurrentScene());
        stage.sizeToScene();
        stage.show();
    }
}

package fx;

import javafx.application.Application;
import javafx.stage.Stage;
import tictactoe.Board;
import tictactoe.Marks;
import tictactoe.PartyV2;
import tictactoe.Player;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Board board = new Board();
        Move move = new Move();
        Player desktopPlayer = new DesktopPlayer(move, Marks.CROSS);
        Player desktopPlayer2 = new DesktopPlayer(move, Marks.NOUGHT);
        PartyV2 party = new PartyV2(board, desktopPlayer, desktopPlayer2);

        Desktop desktop = new Desktop(move, party, board);
        primaryStage.setScene(desktop.getCurrentScene());
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}

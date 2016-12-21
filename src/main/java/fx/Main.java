package fx;

import javafx.application.Application;
import javafx.stage.Stage;

import tictactoe.*;

public class Main extends Application {
    public static Party party;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
/*        Board board = new Board();
        Desktop io = new Desktop(primaryStage);
        party = new PartyCreator().newParty(io, board, GameTypes.HUMAN_VS_HUMAN);
        party.play();*/
        creation(primaryStage);
    }

    public void creation(Stage primaryStage) {
        Board board = new Board();
        Move move = new Move();
        Player desktopPlayer = new DesktopPlayer(move, Marks.CROSS);

        Player desktopPlayer2 = new DesktopPlayer(move, Marks.NOUGHT);

        PartyV2 party = new PartyV2(board, desktopPlayer, desktopPlayer2);
        Desktop io = new Desktop(primaryStage, move, party, board);
    }
}

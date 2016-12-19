package fx;

import javafx.application.Application;
import javafx.stage.Stage;
import tictactoe.Board;
import tictactoe.GameTypes;
import tictactoe.Party;
import tictactoe.PartyCreator;

public class Main extends Application {
    public static Party party;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Board board = new Board();
        Desktop io = new Desktop(primaryStage, board.getContent());
        party = new PartyCreator().newParty(io, board, GameTypes.HUMAN_VS_COMPUTER);
    }
}

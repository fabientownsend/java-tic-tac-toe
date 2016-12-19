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
        Board board = new Board();
        Desktop io = new Desktop(primaryStage, board.getContent());
        party = createParty(board, io);
        // party.play();
    }

    private Party createParty(Board board, Desktop io) {
        PlayerFactory playerFactory = new PlayerFactory(io, board);
        Player[] players = playerFactory.getPlayers(GameTypes.HUMAN_VS_HUMAN);
        return new Party(io, board, players[0], players[1]);
    }
}

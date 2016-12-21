package fx;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import tictactoe.Board;
import tictactoe.Marks;
import tictactoe.PartyV2;
import tictactoe.Player;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class DesktopTest extends ApplicationTest {
    private Desktop io;

    @Override
    public void start(Stage stage) throws Exception {
        Board board = new Board();
        Move move = new Move();
        Player desktopPlayer = new DesktopPlayer(move, Marks.CROSS);

        Player desktopPlayer2 = new DesktopPlayer(move, Marks.NOUGHT);

        PartyV2 party = new PartyV2(board, desktopPlayer, desktopPlayer2);
        Desktop io = new Desktop(stage, move, party, board);
        Scene scene = io.getCurrentScene();
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void initializationOfTheGame() {
        verifyThat("#my_label", hasText("Welcome to Tic-Tac-Toe"));
    }

    @Test
    public void makeCrossWin() {
        clickOn("#id_tile_0").clickOn();
        clickOn("#id_tile_1").clickOn();
        clickOn("#id_tile_3").clickOn();
        clickOn("#id_tile_2").clickOn();
        clickOn("#id_tile_6").clickOn();
        verifyThat("#my_label", hasText("win"));
    }
}

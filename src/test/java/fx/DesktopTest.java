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
        Desktop io = new Desktop(move, party, board);
        Scene scene = io.getCurrentScene();
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void initializationOfTheGame() {
        verifyThat("#my_label", hasText("CROSS turn"));
    }

    @Test
    public void displayTheNextPlayerTurn() {
        clickOn("#id_tile_0").clickOn();
        verifyThat("#my_label", hasText("NOUGHT turn"));
    }

    @Test
    public void makeCrossWin() {
        clickOn("#id_tile_0").clickOn();
        clickOn("#id_tile_1").clickOn();
        clickOn("#id_tile_3").clickOn();
        clickOn("#id_tile_2").clickOn();
        clickOn("#id_tile_6").clickOn();
        verifyThat("#my_label", hasText("CROSS win the party"));
    }

    @Test
    public void makeRoundWin() {
        clickOn("#id_tile_0").clickOn();
        clickOn("#id_tile_1").clickOn();
        clickOn("#id_tile_2").clickOn();
        clickOn("#id_tile_4").clickOn();
        clickOn("#id_tile_8").clickOn();
        clickOn("#id_tile_7").clickOn();
        verifyThat("#my_label", hasText("NOUGHT win the party"));
    }

    @Test
    public void itsATie() {
        clickOn("#id_tile_0").clickOn();
        clickOn("#id_tile_1").clickOn();
        clickOn("#id_tile_2").clickOn();
        clickOn("#id_tile_4").clickOn();
        clickOn("#id_tile_3").clickOn();
        clickOn("#id_tile_5").clickOn();
        clickOn("#id_tile_7").clickOn();
        clickOn("#id_tile_6").clickOn();
        clickOn("#id_tile_8").clickOn();
        verifyThat("#my_label", hasText("It's a tie"));
    }
}

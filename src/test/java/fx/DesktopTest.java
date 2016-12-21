package fx;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import tictactoe.Board;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class DesktopTest extends ApplicationTest {
    private Desktop io;

    @Override
    public void start(Stage stage) throws Exception {
        this.io = new Desktop(stage);
        this.io.displayBoard(new Board().getContent());
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

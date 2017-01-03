package fx;

import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class DesktopTest extends ApplicationTest {
    @Override
    public void start(Stage stage) throws Exception {
        Main main = new Main();
        main.start(stage);
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
        clickOn(0);
        clickOn(1);
        clickOn(2);
        clickOn(4);
        clickOn(8);
        clickOn(7);
        verifyThat("#my_label", hasText("NOUGHT win the party"));
    }

    private FxRobot clickOn(int i) {
        return clickOn("#id_tile_" + i).clickOn();
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

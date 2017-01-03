package fx;

import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isInvisible;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
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
    public void resetButtonIsInvisibleWhenGameNotOver() {
        verifyThat("#reset", isInvisible());
    }

    @Test
    public void displayTheNextPlayerTurn() {
        clickOnTile(0);
        verifyThat("#my_label", hasText("NOUGHT turn"));
    }

    @Test
    public void makeCrossWin() {
        clickOnTile(0);
        clickOnTile(1);
        clickOnTile(3);
        clickOnTile(2);
        clickOnTile(6);
        verifyThat("#my_label", hasText("CROSS win the party"));
    }

    @Test
    public void resetButtonIsVisibleWhenGameOver() {
        clickOnTile(0);
        clickOnTile(1);
        clickOnTile(3);
        clickOnTile(2);
        clickOnTile(6);
        verifyThat("#reset", isVisible());
    }

    @Test
    public void gameIsReset() {
        clickOnTile(0);
        clickOnTile(1);
        clickOnTile(3);
        clickOnTile(2);
        clickOnTile(6);
        clickOn("#reset").clickOn();
        verifyThat("#my_label", hasText("CROSS turn"));
    }

    @Test
    public void makeRoundWin() {
        clickOnTile(0);
        clickOnTile(1);
        clickOnTile(2);
        clickOnTile(4);
        clickOnTile(8);
        clickOnTile(7);
        verifyThat("#my_label", hasText("NOUGHT win the party"));
    }

    @Test
    public void itsATie() {
        clickOnTile(0);
        clickOnTile(1);
        clickOnTile(2);
        clickOnTile(4);
        clickOnTile(3);
        clickOnTile(5);
        clickOnTile(7);
        clickOnTile(6);
        clickOnTile(8);
        verifyThat("#my_label", hasText("It's a tie"));
    }

    private FxRobot clickOnTile(int i) {
        return clickOn("#id_tile_" + i).clickOn();
    }
}

package fx;

import fx.Scenes.Menu;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Menu desktop = new Menu(stage);
        stage.setScene(desktop.getCurrentScene());
        stage.sizeToScene();
        stage.show();
    }
}

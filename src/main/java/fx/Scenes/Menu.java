package fx.Scenes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tictactoe.GameTypes;

public class Menu {
    private Scene currentScene;
    private TextField boardSizeInput;
    private ComboBox comboBox;
    private Stage stage;
    private int boardSize;
    Text textMenu = new Text();

    public Menu(Stage stage) {
        this.stage = stage;
        currentScene = createMenu();
    }

    private Scene createMenu() {
        this.boardSizeInput = new TextField();

        ObservableList<String> options = FXCollections.observableArrayList();
        for (GameTypes gameType : GameTypes.values()) {
            options.add(gameType.toString());
        }

        this.comboBox = new ComboBox(options);
        comboBox.getSelectionModel().selectFirst();

        Button submit = new Button("Submit");
        submit.setId("submit");
        submit.setOnMouseClicked(e -> submitMenu());

        HBox hb = new HBox();
        hb.getChildren().addAll(textMenu, boardSizeInput, comboBox, submit);
        return new Scene(hb);
    }

    private void submitMenu() {
        if (boardSizeInput.getText().isEmpty()) {
            boardSize = 3;
            Game game = new Game(boardSize, stringToGameType(comboBox.getValue().toString()));
            stage.setScene(game.createGameScene());
        } else if (isValid(boardSizeInput.getText())) {
            boardSize = Integer.parseInt(boardSizeInput.getText());
            Game game = new Game(boardSize, stringToGameType(comboBox.getValue().toString()));
            stage.setScene(game.createGameScene());
        } else {
            textMenu.setText("It must be integer");
        }
    }

    private boolean isValid(String text) {
        return text.matches("[0-9]*");
    }


    private GameTypes stringToGameType(String type) {
        GameTypes game = GameTypes.HUMAN_VS_COMPUTER;

        for (GameTypes gameType : GameTypes.values()) {
            if (type.equals(gameType.toString())) {
                game = gameType;
            }
        }

        return game;
    }

    public Scene getCurrentScene() {
        return currentScene;
    }
}

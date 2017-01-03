package fx;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import tictactoe.Board;
import tictactoe.Marks;
import tictactoe.Party;
import tictactoe.players.Player;

public class Desktop extends VBox {
    private BoardConverter boardConverter;
    private Scene scene;
    private Label label;
    private BorderPane boarderPane;
    private Board board;
    private GameEvent gameEvent;
    private Party party;

    public Desktop() {
        this.board = new Board();
        Move move = new Move();
        Player desktopPlayer = new DesktopPlayer(move, Marks.CROSS);
        Player desktopPlayer2 = new DesktopPlayer(move, Marks.NOUGHT);
        this.party = new Party(board, desktopPlayer, desktopPlayer2);

        this.gameEvent = new GameEvent(move, party, this);

        this.boardConverter = new BoardConverter(gameEvent);

        boarderPane = new BorderPane();
        scene = new Scene(boarderPane);

        label = new Label();
        label.setText("Welcome to Tic-Tac-Toe");
        label.setId("my_label");
        refreshWindows();
    }

    public Scene getCurrentScene() {
        return scene;
    }

    public void refreshWindows() {
        Pane convertedBoard = boardConverter.makeBoard(board.getContent());
        updateMessage();
        boarderPane.setTop(label);
        boarderPane.setCenter(convertedBoard);
    }

    private void updateMessage() {
        if (party.isTie()) {
            label.setText("It's a tie");
        } else if (party.currentPlayerWon()) {
            label.setText(party.getCurrentPlayerMark() + " win the party");
        } else {
            label.setText(party.getCurrentPlayerMark() + " turn");
        }
    }
}

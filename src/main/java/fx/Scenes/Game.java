package fx.Scenes;

import fx.BoardConverter;
import fx.GameEvent;
import fx.Move;
import fx.PlayerFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import tictactoe.Board;
import tictactoe.GameTypes;
import tictactoe.Party;
import tictactoe.players.Player;

public class Game {
    private Board board;
    private Party party;
    private Button reset;
    private Label label;
    private Move move;
    private GameEvent gameEvent;
    private BoardConverter boardConverter;
    private BorderPane boarderPane;

    public Game(int boardSize, GameTypes gameType) {
        this.move = new Move();
        this.board = new Board(boardSize);
        this.party = createParty(move, board, gameType);
    }

    private Party createParty(Move move, Board board, GameTypes gameTypes) {
        PlayerFactory playerFactory = new PlayerFactory(move, board);
        Player[] players = playerFactory.getPlayers(gameTypes);
        party = new Party(board, players[0], players[1]);
        party.play();
        return party;
    }

    public Scene createGameScene() {
        reset = new Button("Replay");
        reset.setId("reset");
        reset.setOnMouseClicked(e -> resetParty());

        label = new Label();
        label.setText("Welcome to Tic-Tac-Toe");
        label.setId("my_label");
        this.gameEvent = new GameEvent(move, party, this);
        this.boardConverter = new BoardConverter(gameEvent);
        this.boarderPane = new BorderPane();
        refreshWindows();
        return new Scene(boarderPane);
    }

    private void resetParty() {
        party.reset();
        refreshWindows();
    }

    public void refreshWindows() {
        boarderPane.setTop(updateMessage());
        boarderPane.setCenter(convertBoard());
        boarderPane.setBottom(resetButton());
    }

    private Pane convertBoard() {
        return boardConverter.makeBoard(board.getContent());
    }

    private Button resetButton() {
        if (party.isTie() || party.currentPlayerWon()) {
            reset.setVisible(true);
        } else {
            reset.setVisible(false);
        }

        return reset;
    }

    private Label updateMessage() {
        if (party.isTie()) {
            label.setText("It's a tie");
        } else if (party.currentPlayerWon()) {
            label.setText(party.getCurrentPlayerMark() + " win the party");
        } else {
            label.setText(party.getCurrentPlayerMark() + " turn");
        }

        return label;
    }
}

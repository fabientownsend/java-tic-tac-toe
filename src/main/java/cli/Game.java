package cli;

import tictactoe.*;
import tictactoe.Marks;

public class Game {
    private IO io;
    private Menu menu;
    private PartyCreator partyCreator;
    private Board board;
    private Party party;

    public Game(IO io, PartyCreator partyCreator) {
        this.io = io;
        this.menu = new Menu(io);
        this.partyCreator = partyCreator;
    }

    public void start() {
        do {
            int boardSize = menu.getBoardSize();
            GameTypes gameType = menu.getGameType();
            board =  new Board(boardSize);

            party = partyCreator.newParty(io, board, gameType);
            party.play();
            displayResult();

        } while (menu.replay());
    }

    private void displayResult() {
        String result = getResultMessage();
        io.displayBoard(board.getContent());
        io.write(result);
    }

    private String getResultMessage() {
        if (board.tie()) {
            return "it's a tie\n";
        } else {
            return convertMarkToString() + " won the party\n";
        }
    }

    private String convertMarkToString() {
        if (party.getCurrentPlayerMark() == Marks.CROSS) {
            return "X";
        } else {
            return "O";
        }
    }
}

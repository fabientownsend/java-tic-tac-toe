package tictactoe.test;

import tictactoe.IBoard;

class FakeBoard implements IBoard {
    private boolean tie = true;
    private boolean win = true;

    public void putMark(char mark, int position) {}
    public boolean tie() {
        return tie;
    }
    public boolean win(char mark) {
        if (!win) {
            win = true;
            return false;
        }

        return win;
    }
    public char[][] getContent() {
        return new char[3][3];
    }

    public void setTie(boolean status) {
        tie = status;
    }

    public void setWin(boolean status) {
        win = status;
    }
}

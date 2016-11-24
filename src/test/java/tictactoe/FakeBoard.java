package tictactoe;

class FakeBoard implements IBoard {
    private boolean tie = true;
    private boolean win = true;

    public void putMark(Marks mark, int position) {}
    public boolean tie() {
        return tie;
    }
    public boolean win(Marks mark) {
        if (!win) {
            win = true;
            return false;
        }

        return win;
    }
    public Marks[][] getContent() {
        return new Marks[3][3];
    }

    public void setTie(boolean status) {
        tie = status;
    }

    public void setWin(boolean status) {
        win = status;
    }
}

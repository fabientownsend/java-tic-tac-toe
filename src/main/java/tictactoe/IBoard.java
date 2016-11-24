package tictactoe;

public interface IBoard {
    void putMark(Marks mark, int position);
    boolean tie();
    boolean win(Marks mark);
    Marks[][] getContent();
}

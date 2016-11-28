package tictactoe;

public interface IBoard {
    void putMark(Marks mark, int position);
    Marks[][] getContent();
    boolean tie();
    boolean win(Marks mark);
}

package tictactoe;

public interface IBoard {
    void putMark(char mark, int position);
    boolean tie();
    boolean win(char mark);
    char[][] getContent();
}

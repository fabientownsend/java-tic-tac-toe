package tictactoe;

public interface IBoard {
    public  void putMark(char mark, int position);
    public boolean tie();
    public boolean win(char mark);
    public char[][] getContent();
}

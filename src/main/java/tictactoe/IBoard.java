package tictactoe;

import java.util.ArrayList;

public interface IBoard {
    void putMark(Marks mark, int position);
    Marks[][] getContent();
    boolean tie();
    boolean win(Marks mark);
    ArrayList<Integer> freePosition();
}

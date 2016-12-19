package tictactoe;

public interface Player {
    int nextMove();
    Marks getMark();
    boolean isReady();
}

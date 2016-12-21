package fx;

import java.util.Observable;

public class Move extends Observable {
    private int move = -1;

    public int getLastMove() {
        clearChanged();
        return move;
    }

    public void setNewMove(int newMove) {
        if (move != newMove) {
            move = newMove;
            setChanged();
            System.out.println("Update the value with: " + move);
        } else {
            System.out.println("Didn't update the value with: " + move);
        }
    }
}
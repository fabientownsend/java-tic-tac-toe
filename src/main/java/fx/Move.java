package fx;

import java.util.Observable;

public class Move extends Observable {
    private int move = -1;
    private boolean notStarted = true;

    public int getLastMove() {
        clearChanged();
        return move;
    }

    public void setNewMove(int newMove) {
        if (move != newMove) {
            move = newMove;
            setChanged();
            System.out.println("Update the value with: " + move);
            Desktop.isReady = true;
            Main.party.play();
        } else {
            System.out.println("Didn't update the value with: " + move);
        }
    }
}
package fx;

import tictactoe.Marks;
import tictactoe.Player;

public class DesktopPlayer implements Player {
    private Move move;
    private final Marks mark;

    public DesktopPlayer(Move move, Marks mark) {
        this.move = move;
        this.mark = mark;
    }

    public boolean isReady() {
        return move.hasChanged();
    }

    public int nextMove() {
        return move.getLastMove();
    }

    public Marks getMark() {
        return mark;
    }
}

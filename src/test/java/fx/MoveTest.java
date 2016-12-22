package fx;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class MoveTest {
    private Move move;

    @Before
    public void initialization() {
        this.move = new Move();
    }

    @Test
    public void valueIsntChanged_whenInitialization() {
        assertThat(move.hasChanged()).isFalse();
    }

    @Test
    public void valueChanged_whenNewValueAdded() {
        move.setNewMove(1);
        assertThat(move.hasChanged()).isTrue();
    }

    @Test
    public void valueIsntChanged_whenAValueWasCalled() {
        move.setNewMove(1);
        move.getLastMove();
        assertThat(move.hasChanged()).isFalse();
    }

    @Test
    public void valueChanged_whenNewAValueAddedAfterCalled() {
        move.setNewMove(1);
        move.getLastMove();
        move.setNewMove(2);
        assertThat(move.hasChanged()).isTrue();
    }

    @Test
    public void valueIsntChanged_whendIdenticalToPreviousOne() {
        move.setNewMove(1);
        move.getLastMove();
        move.setNewMove(1);
        assertThat(move.hasChanged()).isFalse();
    }
}

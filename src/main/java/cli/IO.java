package cli;

import tictactoe.Marks;

public interface IO {
    void write(String input);
    String read();
    void displayBoard(Marks[][] board);
    boolean isReady();
}

package tictactoe;

public interface IO {
    void write(String input);
    String read();
    void displayBoard(Marks[][] board);
}

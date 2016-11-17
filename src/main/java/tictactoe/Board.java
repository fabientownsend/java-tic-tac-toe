package tictactoe;

public class Board implements IBoard {
    private char[][] board;
    private final int SIZE = 3;

    public Board() {
        this.board = new char[SIZE][SIZE];
    }

    public void putMark(char mark, int position) {
        board[getRow(position)][getColumn(position)] = mark;
    }

    private int getRow(int position) {
        return position / SIZE;
    }

    private int getColumn(int position) {
        return position % SIZE;
    }

    public final char[][] getContent() {
        return  board;
    }

    public boolean tie() {
        return isFull() && !win(Marks.CROSS) && !win(Marks.ROUND);
    }

    private boolean isFull() {
        for(int row = 0; row < SIZE; row++){
            for(int column = 0; column < SIZE; column++) {
                if (board[row][column] != Marks.CROSS && board[row][column] != Marks.ROUND) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean win(char mark) {
        for (int i = 0; i < SIZE; i++) {
            if (winningRow(i, mark) || winningColumn(i, mark)) {
                return true;
            }
        }

        if (winningDiagonal(mark) || winningDiagonalBackward(mark)) {
            return true;
        }

        return false;
    }

    private boolean winningRow(int rowIndex, char mark) {
        for(int i = 0; i < SIZE; i++) {
            if (board[rowIndex][i] != mark) {
                return false;
            }
        }

        return true;
    }

    private boolean winningColumn(int columnIndex, char mark) {
        for(int i = 0; i < SIZE; i++) {
            if (board[i][columnIndex] != mark) {
                return false;
            }
        }

        return true;
    }

    private boolean winningDiagonal(char mark) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][i] != mark) {
                return false;
            }
        }

        return true;
    }

    private boolean winningDiagonalBackward(char mark) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][SIZE - i - 1] != mark) {
                return false;
            }
        }

        return true;
    }
}

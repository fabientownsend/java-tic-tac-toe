package tictactoe;

public class Board {
    private boolean isEmpty;
    private char[][] board;
    private final int SIZE = 3;

    public Board() {
        this.isEmpty = true;
        this.board = new char[SIZE][SIZE];
    }

    public void putMark(char mark, int position) {
        isEmpty = false;
        board[getRow(position)][getColumn(position)] = mark;
    }

    private int getRow(int position) {
        return position / SIZE;
    }

    private int getColumn(int position) {
        return position % SIZE;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public final char[][] getContent() {
        return  board;
    }

    public boolean tie() {
        return isFull() && !win(Marks.CROSS) && !win(Marks.ROUND);
    }

    private boolean isFull() {
        for(int i = 0; i < SIZE; i++){
            for(int y = 0; y < SIZE; y++) {
                if (board[i][y] != Marks.CROSS && board[i][y] != Marks.ROUND) {
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

    private boolean winningRow(int index, char mark) {
        for(int i = 0; i < SIZE; i++) {
            if (board[index][i] != mark) {
                return false;
            }
        }

        return true;
    }

    private boolean winningColumn(int index, char mark) {
        for(int i = 0; i < SIZE; i++) {
            if (board[i][index] != mark) {
                return false;
            }
        }

        return true;
    }
}

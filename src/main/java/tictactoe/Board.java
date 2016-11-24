package tictactoe;

public class Board implements IBoard {
    private Marks[][] board;
    private final int SIZE = 3;

    public Board() {
        this.board = new Marks[SIZE][SIZE];
    }

    public void putMark(Marks mark, int position) {
        board[getRow(position)][getColumn(position)] = mark;
    }

    private int getRow(int position) {
        return position / SIZE;
    }

    private int getColumn(int position) {
        return position % SIZE;
    }

    public final Marks[][] getContent() {
        return  board;
    }

    public boolean tie() {
        return isFull() && !win(Marks.CROSS) && !win(Marks.ROUND);
    }

    private boolean isFull() {
        for (Marks[] columns : board) {
            for (Marks mark : columns) {
                if (mark != Marks.CROSS && mark != Marks.ROUND) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean win(Marks mark) {
        return winningDiagonals(mark) || winningRows(mark) || winningColumns(mark);
    }

    private boolean winningDiagonals(Marks mark) {
        return winningDiagonal(mark) || winningDiagonalBackward(mark);
    }

    private boolean winningColumns(Marks mark) {
        for (int i = 0; i < SIZE; i ++) {
            if (winningColumn(i, mark)) {
                return true;
            }
        }

        return false;
    }

    private boolean winningRows(Marks mark) {
        for (int i = 0; i < SIZE; i++) {
            if (winningRow(i, mark)) {
                return true;
            }
        }

        return false;
    }

    private boolean winningRow(int rowIndex, Marks mark) {
        for(int i = 0; i < SIZE; i++) {
            if (board[rowIndex][i] != mark) {
                return false;
            }
        }

        return true;
    }

    private boolean winningColumn(int columnIndex, Marks mark) {
        for(int i = 0; i < SIZE; i++) {
            if (board[i][columnIndex] != mark) {
                return false;
            }
        }

        return true;
    }

    private boolean winningDiagonal(Marks mark) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][i] != mark) {
                return false;
            }
        }

        return true;
    }

    private boolean winningDiagonalBackward(Marks mark) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][SIZE - i - 1] != mark) {
                return false;
            }
        }

        return true;
    }
}

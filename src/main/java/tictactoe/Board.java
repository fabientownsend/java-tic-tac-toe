package tictactoe;

import java.util.ArrayList;

public class Board implements IBoard {
    private Marks[][] board;
    private int size = 3;

    public Board() {
        this(3);
    }

    public Board(int size) {
        this.board = new Marks[size][size];
        this.size = size;
    }

    public void putMark(Marks mark, int position) {
        board[getRow(position)][getColumn(position)] = mark;
    }

    public void removeMark(int position) {
        board[getRow(position)][getColumn(position)] = null;
    }

    private int getRow(int position) {
        return position / size;
    }

    private int getColumn(int position) {
        return position % size;
    }

    public final Marks[][] getContent() {
        return  board;
    }

    public boolean tie() {
        return isFull() && !win(Marks.CROSS) && !win(Marks.ROUND);
    }

    public final ArrayList<Integer> freePosition() {
        ArrayList<Integer> positions = new ArrayList<Integer>();
        int id = 0;

        for(int row = 0; row < size; row++){
            for(int column = 0; column < size; column++) {
                if (board[row][column] != Marks.CROSS && board[row][column] != Marks.ROUND) {
                    positions.add(id);
                }
                id++;
            }
        }

        return positions;
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
        for (int i = 0; i < size; i ++) {
            if (winningColumn(i, mark)) {
                return true;
            }
        }

        return false;
    }

    private boolean winningRows(Marks mark) {
        for (int i = 0; i < size; i++) {
            if (winningRow(i, mark)) {
                return true;
            }
        }

        return false;
    }

    private boolean winningRow(int rowIndex, Marks mark) {
        for(int i = 0; i < size; i++) {
            if (board[rowIndex][i] != mark) {
                return false;
            }
        }

        return true;
    }

    private boolean winningColumn(int columnIndex, Marks mark) {
        for(int i = 0; i < size; i++) {
            if (board[i][columnIndex] != mark) {
                return false;
            }
        }

        return true;
    }

    private boolean winningDiagonal(Marks mark) {
        for (int i = 0; i < size; i++) {
            if (board[i][i] != mark) {
                return false;
            }
        }

        return true;
    }

    private boolean winningDiagonalBackward(Marks mark) {
        for (int i = 0; i < size; i++) {
            if (board[i][size - i - 1] != mark) {
                return false;
            }
        }

        return true;
    }
}

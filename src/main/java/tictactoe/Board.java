package tictactoe;

import java.util.ArrayList;

public class Board {
    private MarksEnum[][] board;
    private int size = 3;

    public Board() {
        this(3);
    }

    public Board(int size) {
        this.board = new MarksEnum[size][size];
        this.size = size;
    }

    public void putMark(MarksEnum mark, int position) {
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

    public MarksEnum[][] getContent() {
        return  board;
    }

    public boolean tie() {
        return isFull() && !win(MarksEnum.CROSS) && !win(MarksEnum.ROUND);
    }

    public ArrayList<Integer> freePositions() {
        ArrayList<Integer> positions = new ArrayList<>();
        int id = 0;

        for(int row = 0; row < size; row++){
            for(int column = 0; column < size; column++) {
                if (board[row][column] != MarksEnum.CROSS && board[row][column] != MarksEnum.ROUND) {
                    positions.add(id);
                }
                id++;
            }
        }

        return positions;
    }

    private boolean isFull() {
        for (MarksEnum[] columns : board) {
            for (MarksEnum mark : columns) {
                if (mark != MarksEnum.CROSS && mark != MarksEnum.ROUND) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean win(MarksEnum mark) {
        return winningDiagonals(mark) || winningRows(mark) || winningColumns(mark);
    }

    private boolean winningDiagonals(MarksEnum mark) {
        return winningDiagonal(mark) || winningDiagonalBackward(mark);
    }

    private boolean winningColumns(MarksEnum mark) {
        for (int i = 0; i < size; i ++) {
            if (winningColumn(i, mark)) {
                return true;
            }
        }

        return false;
    }

    private boolean winningRows(MarksEnum mark) {
        for (int i = 0; i < size; i++) {
            if (winningRow(i, mark)) {
                return true;
            }
        }

        return false;
    }

    private boolean winningRow(int rowIndex, MarksEnum mark) {
        for(int i = 0; i < size; i++) {
            if (board[rowIndex][i] != mark) {
                return false;
            }
        }

        return true;
    }

    private boolean winningColumn(int columnIndex, MarksEnum mark) {
        for(int i = 0; i < size; i++) {
            if (board[i][columnIndex] != mark) {
                return false;
            }
        }

        return true;
    }

    private boolean winningDiagonal(MarksEnum mark) {
        for (int i = 0; i < size; i++) {
            if (board[i][i] != mark) {
                return false;
            }
        }

        return true;
    }

    private boolean winningDiagonalBackward(MarksEnum mark) {
        for (int i = 0; i < size; i++) {
            if (board[i][size - i - 1] != mark) {
                return false;
            }
        }

        return true;
    }
}

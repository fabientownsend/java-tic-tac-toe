package tictactoe;

public class BoardConverter {
    public String toString(Marks[][] board) {
        StringBuilder str = new StringBuilder();
        int idSpot = 0;

        for(int i = 0; i < board.length; i++) {
            for (int y = 0; y < board.length; y++) {
                str.append(" " + markToDisplay(board[i][y], idSpot));
                str.append(rightEdgeSpot(board, y));
                idSpot++;
            }

            if (!isBoardEdge(board, i)) {
                str.append("-----------\n");
            }
        }

        return str.toString();
    }

    private String rightEdgeSpot(Marks[][] board, int y) {
        if (isBoardEdge(board, y)) {
            return " \n";
        } else {
            return " |";
        }
    }

    private char markToDisplay(Marks c, int idSpot) {
        if (c == Marks.CROSS) {
            return 'X';
        } else if (c == Marks.ROUND) {
            return 'O';
        } else {
            return Character.forDigit(idSpot, 10);
        }
    }

    private boolean isBoardEdge(Marks[][] board, int i) {
        return i == board.length - 1;
    }
}

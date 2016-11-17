package tictactoe;

public class BoardConverter {
    public String toString(char[][] board) {
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

    private String rightEdgeSpot(char[][] board, int y) {
        if (isBoardEdge(board, y)) {
            return " \n";
        } else {
            return " |";
        }
    }

    private char markToDisplay(char c, int idSpot) {
        if (c == Marks.CROSS || c == Marks.ROUND) {
            return c;
        } else {
            return Character.forDigit(idSpot, 10);
        }
    }

    private boolean isBoardEdge(char[][] board, int i) {
        return i == board.length - 1;
    }
}

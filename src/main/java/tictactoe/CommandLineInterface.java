package tictactoe;

public class CommandLineInterface {

    public String boardString(char[][] board) {
        StringBuilder str = new StringBuilder();
        int id = 0;

        for(int i = 0; i < board.length; i++) {
            for (int y = 0; y < board.length; y++) {
                str.append(" " + markToDisplay(board[i][y], id));
                str.append(endBoxWith(board, y));
                id++;
            }

            if (!isBoardEdge(board, i)) {
                str.append("-----------\n");
            }
        }
        return str.toString();
    }

    private String endBoxWith(char[][] board, int y) {
        if (isBoardEdge(board, y)) {
            return " \n";
        } else {
            return " |";
        }
    }

    private char markToDisplay(char c, int id) {
        char input;
        if (c == Marks.CROSS || c == Marks.ROUND) {
            input = c;
        } else {
            input = Character.forDigit(id, 10);
        }
        return input;
    }

    private boolean isBoardEdge(char[][] board, int i) {
        return i == board.length - 1;
    }
}

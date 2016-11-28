package tictactoe;

public class BoardConverter {
    private Marks[][] board;

    public String toString(Marks[][] board) {
        this.board = board;
        StringBuilder str = new StringBuilder();
        int idLine = 0;
        int idSpot = 0;

        for (Marks[] columns : board) {
            for (Marks mark : columns) {
                str.append(createLine(idSpot, mark));
                idSpot++;
            }

            if (++idLine != board.length) {
                for (int i = 0; i < board.length * board.length + 1 * board.length - 1; i++) {
                    str.append("-");
                }
                str.append("\n");
            }
        }

        return str.toString();
    }

    private String createLine(int idSpot, Marks mark) {
        return markToDisplay(mark, idSpot) + rightEdgeSpot(idSpot);
    }

    private String rightEdgeSpot(int y) {
        if (isBoardEdge(y)) {
            return "\n";
        } else {
            return "|";
        }
    }

    private String markToDisplay(Marks mark, int idSpot) {
        String result = "";
        if (mark == Marks.CROSS) {
            result += "X";
        } else if (mark == Marks.ROUND) {
            result += "O";
        } else {
            result += String.valueOf(idSpot);
        }
        return center(result, board.length);
    }

    public String center(String str, int width) {
        int paddenWidth = (width - str.length()) / 2;
        if (str.length() % 2 == 0 || width % 2 != 0) {
            return padden(paddenWidth) + str + padden(paddenWidth);
        } else {
            return padden(paddenWidth) + " " + str + padden(paddenWidth);
        }
    }

    private String padden(int width) {
        StringBuilder padden = new StringBuilder();
        for (int i = 0; i < width; i++) {
            padden.append(" ");
        }
        return padden.toString();
    }

    private boolean isBoardEdge(int i) {
        return (i + 1) % board.length == 0;
    }
}

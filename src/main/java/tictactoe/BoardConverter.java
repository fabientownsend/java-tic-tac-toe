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
                str.append("-----------\n");
            }
        }

        return str.toString();
    }

    private String createLine(int idSpot, Marks mark) {
        return " " + markToDisplay(mark, idSpot) + rightEdgeSpot(idSpot);
    }

    private String rightEdgeSpot(int y) {
        if (isBoardEdge(y)) {
            return " \n";
        } else {
            return " |";
        }
    }

    private char markToDisplay(Marks mark, int idSpot) {
        if (mark == Marks.CROSS) {
            return 'X';
        } else if (mark == Marks.ROUND) {
            return 'O';
        } else {
            return Character.forDigit(idSpot, 10);
        }
    }

    private boolean isBoardEdge(int i) {
        return (i + 1) % board.length == 0;
    }
}

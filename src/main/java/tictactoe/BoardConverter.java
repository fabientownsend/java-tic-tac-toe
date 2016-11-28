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
                str.append(createSpot(idSpot, mark));
                idSpot++;
            }

            if (++idLine != board.length) {
                str.append(repeatElement(boardCharWidth(board), "-"));
                str.append("\n");
            }
        }

        return str.toString();
    }

    private int boardCharWidth(Marks[][] board) {
        Integer widthSpot = widthSpot(board);
        int rightElements = board.length - 1;
        return widthSpot * (board.length) + rightElements;
    }

    private int widthSpot(Marks[][] board) {
        int widthMaxIdSpot = String.valueOf(board.length * board.length - 1).length();
        widthMaxIdSpot += 2;
        return widthMaxIdSpot;
    }

    private String createSpot(int idSpot, Marks mark) {
        return spot(mark, idSpot) + elementRightSpot(idSpot);
    }

    private String elementRightSpot(int y) {
        if (isBoardEdge(y)) {
            return "\n";
        } else {
            return "|";
        }
    }

    private String spot(Marks mark, int idSpot) {
        Integer test = widthSpot(board);
        int width = test;
        if (mark == Marks.CROSS) {
            return center("X", width);
        } else if (mark == Marks.ROUND) {
            return center("O", width);
        } else {
            return center(String.valueOf(idSpot), width);
        }
    }

    private final String SPACE = " ";
    private String center(String str, int totalWidth) {
        int paddingWidth = calculatePaddingWidth(str, totalWidth);

        if (totalWidthIsOdd(str, totalWidth)) {
            return padding(paddingWidth) + str + padding(paddingWidth);
        } else {
            return padding(paddingWidth) + SPACE + str + padding(paddingWidth);
        }
    }

    private int calculatePaddingWidth(String str, int width) {
        return (width - str.length()) / 2;
    }

    private boolean totalWidthIsOdd(String str, int width) {
        return (str.length() + width) % 2 == 0;
    }

    private String padding(int width) {
        return repeatElement(width, SPACE);
    }

    private String repeatElement(int width, String str) {
        StringBuilder spaces = new StringBuilder();

        for (int i = 0; i < width; i++) {
            spaces.append(str);
        }

        return spaces.toString();
    }

    private boolean isBoardEdge(int i) {
        return (i + 1) % board.length == 0;
    }
}

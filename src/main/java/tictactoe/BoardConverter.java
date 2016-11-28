package tictactoe;

public class BoardConverter {
    private Marks[][] board;
    private final String NEW_LINE = "\n";
    private final String INTER_LINE = "-";

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
                str.append(repeatElement(totalCharBoardWidth(board), INTER_LINE));
                str.append(NEW_LINE);
            }
        }

        return str.toString();
    }

    private String createSpot(int idSpot, Marks mark) {
        String centeredMark = center(correctMark(mark, idSpot), spotWidth(board));
        return centeredMark + elementRightSpot(idSpot);
    }

    private final String CROSS = "X";
    private final String ROUND = "O";
    private String correctMark(Marks mark, int idSpot) {
        if (mark == Marks.CROSS) {
            return CROSS;
        } else if (mark == Marks.ROUND) {
            return ROUND;
        } else {
            return String.valueOf(idSpot);
        }
    }

    private final String SPOT_BORDER = "|";
    private String elementRightSpot(int y) {
        if (isBoardEdge(y)) {
            return NEW_LINE;
        } else {
            return SPOT_BORDER;
        }
    }

    private int spotWidth(Marks[][] board) {
        int idMaxWidth = String.valueOf(board.length * board.length - 1).length();
        idMaxWidth += 2;
        return idMaxWidth;
    }

    private int totalCharBoardWidth(Marks[][] board) {
        int rightElements = board.length - 1;
        return spotWidth(board) * board.length + rightElements;
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

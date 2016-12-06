package tictactoe;

public class BoardConverter {
    private MarksEnum[][] board;
    private final String NEW_LINE = "\n";
    private final String LINE_SEPARATOR = "-";

    public String toString(MarksEnum[][] board) {
        this.board = board;
        StringBuilder str = new StringBuilder();
        int rowCounter = 0;
        int spotCounter = 0;

        for (MarksEnum[] rows : board) {
            for (MarksEnum mark : rows) {
                str.append(createSpot(spotCounter, mark));
                spotCounter++;
            }

            if (++rowCounter != board.length) {
                str.append(repeatElement(widthOf(board), LINE_SEPARATOR));
                str.append(NEW_LINE);
            }
        }

        return str.toString();
    }

    private String createSpot(int spotNumber, MarksEnum mark) {
        String centeredMark = center(correctMark(mark, spotNumber), widthOfSpots());
        return centeredMark + elementRightSpot(spotNumber);
    }

    private final String CROSS = "X";
    private final String NOUGHT = "O";
    private String correctMark(MarksEnum mark, int idSpot) {
        if (mark == MarksEnum.CROSS) {
            return CROSS;
        } else if (mark == MarksEnum.NOUGHT) {
            return NOUGHT;
        } else {
            return String.valueOf(idSpot);
        }
    }

    private final String SPOT_SEPARATOR = "|";
    private String elementRightSpot(int y) {
        if (isBoardEdge(y)) {
            return NEW_LINE;
        } else {
            return SPOT_SEPARATOR;
        }
    }

    private int widthOfSpots() {
        int widthHighestSpotId = String.valueOf(board.length * board.length - 1).length();
        widthHighestSpotId += 2;
        return widthHighestSpotId;
    }

    private int widthOf(MarksEnum[][] board) {
        int rightElements = board.length - 1;
        return widthOfSpots() * board.length + rightElements;
    }

    private final String SPACE = " ";
    private String center(String centerContent, int totalWidth) {
        int paddingWidth = calculatePaddingWidth(centerContent, totalWidth);

        if (totalWidthIsOdd(centerContent, totalWidth)) {
            return padding(paddingWidth) + centerContent + padding(paddingWidth);
        } else {
            return padding(paddingWidth) + SPACE + centerContent + padding(paddingWidth);
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
        StringBuilder elements = new StringBuilder();

        for (int i = 0; i < width; i++) {
            elements.append(str);
        }

        return elements.toString();
    }

    private boolean isBoardEdge(int i) {
        return (i + 1) % board.length == 0;
    }
}

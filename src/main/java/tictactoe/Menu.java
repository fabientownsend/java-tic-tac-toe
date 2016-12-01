package tictactoe;

public class Menu {
    private IO io;

    public Menu(IO io) {
        this.io = io;
    }

    private final int THREE_BY_THREE = 3;
    private final int FIVE_BY_FIVE = 5;
    public int sizeBoard() {
        io.write("Select board size: ");

        return getValueBetween(THREE_BY_THREE, FIVE_BY_FIVE);
    }

    private final int HUMAN_VS_HUMAN = 1;
    private final int COMPUTER_VS_COMPUTER = 3;
    public GameTypes typeGame() {
        io.write("What kind of game do you want to play?\n" +
                "1 - Human vs. Human\n" +
                "2 - Human vs. Computer\n" +
                "3 - Computer vs. Computer\n");

        return convertToGameType(getValueBetween(HUMAN_VS_HUMAN, COMPUTER_VS_COMPUTER));
    }

    private GameTypes convertToGameType(int value) {
        if (value == 1) {
            return GameTypes.HUMAN_VS_HUMAN;
        } else if (value == 2) {
            return GameTypes.HUMAN_VS_COMPUTER;
        } else  if (value == 3) {
            return GameTypes.COMPUTER_VS_COMPUTER;
        } else {
            return GameTypes.HUMAN_VS_HUMAN;
        }
    }

    private int getValueBetween(int sizeMin, int sizeMax) {
        int defaultValue = sizeMin;
        int integerValue = getInteger(defaultValue);

        if (integerValue > sizeMax || integerValue < sizeMin) {
            io.write("Select value between: " + sizeMin + " and " + sizeMax);
            return sizeBoard();
        } else {
            return integerValue;
        }
    }

    private int getInteger(int defaultValue) {
        String value = io.read();

        if (value.equals("")) {
            return defaultValue;
        }

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            io.write("The value must be an integer");
            return getInteger(defaultValue);
        }
    }
}

package tictactoe;

public class Menu {
    private IO io;
    private int defaultValue = 0;

    public Menu(IO io) {
        this.io = io;
    }

    public int sizeBoard(int sizeMin, int sizeMax) {
        defaultValue = sizeMin;
        io.write("Select board size: ");

        return getValueBetween(sizeMin, sizeMax);
    }

    public int typeGame(int sizeMin, int sizeMax) {
        defaultValue = sizeMin;
        io.write("What kind of game do you want to play?\n" +
                "- Human vs. Human\n" +
                "- Human vs. Computer\n" +
                "- Computer vs. Computer\n");

        return getValueBetween(sizeMin, sizeMax);
    }

    private int getValueBetween(int sizeMin, int sizeMax) {
        int integerValue = getInteger();

        if (integerValue > sizeMax || integerValue < sizeMin) {
            io.write("Select value between: " + sizeMin + " and " + sizeMax);
            return sizeBoard(sizeMin, sizeMax);
        } else {
            return integerValue;
        }
    }

    private int getInteger() {
        String value = io.read();

        if (value.equals("")) {
            return defaultValue;
        }

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            io.write("The value must be an integer");
            return getInteger();
        }
    }
}

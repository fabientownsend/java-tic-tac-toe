package tictactoe;

public class Menu {
    private IO io;

    public Menu(IO io) {
        this.io = io;
    }

    private final int THREE_BY_THREE = 3;
    private final int FIVE_BY_FIVE = 5;
    public int getBoardSize() {
        io.write("Select board size: ");

        return getValueBetween(THREE_BY_THREE, FIVE_BY_FIVE);
    }

    private final int FIRST_MENU = 0;
    public GameTypes getGameType() {
        io.write(getMenuGamesTypes());
        int indexGameTypeSelected = getValueBetween(FIRST_MENU, GameTypes.values().length);
        return GameTypes.values()[indexGameTypeSelected];
    }

    private String getMenuGamesTypes() {
        int idGameType = 0;
        StringBuilder menuGamesTypes = new StringBuilder();
        menuGamesTypes.append("What kind of game do you want to play?\n");

        for (GameTypes gameType : GameTypes.values()) {
            menuGamesTypes.append(idGameType + " - " + gameType.toString() + "\n");
            idGameType++;
        }

        return menuGamesTypes.toString();
    }

    private int getValueBetween(int sizeMin, int sizeMax) {
        int defaultValue = sizeMin;
        int integerValue = getInteger(defaultValue);

        if (integerValue > sizeMax || integerValue < sizeMin) {
            io.write("Select value between: " + sizeMin + " and " + sizeMax);
            return getBoardSize();
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

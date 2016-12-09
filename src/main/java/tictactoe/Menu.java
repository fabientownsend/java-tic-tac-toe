package tictactoe;

public class Menu {
    private final String REPLAY_REQUEST = "Do you want to replay? yes/no\n";
    private final String YES = "yes";
    private final String NO = "no";
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

    public GameTypes getGameType() {
        io.write(getMenuGameTypes());
        int indexGameTypeSelected = getValueBetween(0, GameTypes.values().length);
        return GameTypes.values()[indexGameTypeSelected];
    }

    public boolean replay() {
        io.write(REPLAY_REQUEST);
        String answer = io.read().toLowerCase();

        if (answer.equals(YES)) {
            return true;
        } else if (answer.equals(NO)) {
            return false;
        } else {
            return replay();
        }
    }

    private String getMenuGameTypes() {
        return "What type of game do you want to play?\n" + gameTypesList();
    }

    private String gameTypesList() {
        int indexGameType = 0;
        String listGameTypes = "";

        for (GameTypes gameType : GameTypes.values()) {
            listGameTypes += (indexGameType + " - " + gameType.toString() + "\n");
            indexGameType++;
        }

        return listGameTypes;
    }

    private int getValueBetween(int min, int max) {
        int defaultValue = min;
        int value = getInteger(defaultValue);

        if (value >= min && value <= max) {
            return value;
        } else {
            io.write("Select value between: " + min + " and " + max + "\n");
            return getBoardSize();
        }
    }

    private int getInteger(int defaultValue) {
        String userInput = io.read();

        if (userInput.equals("")) {
            return defaultValue;
        }

        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            io.write("The value must be an integer");
            return getInteger(defaultValue);
        }
    }
}

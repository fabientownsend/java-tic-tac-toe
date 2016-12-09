package tictactoe;

public class PartyCreator {
    private static int totalPartyPlayed = 0;

    public PartyCreator() {
        totalPartyPlayed = 0;
    }

    public static Party newParty(IO io, int sizeBoard, GameTypes gameType) {
        Board board = new Board(sizeBoard);
        totalPartyPlayed++;

        PlayerFactory playerFactory = new PlayerFactory(io, board);
        Player[] players = playerFactory.getPlayers(gameType);

        return new Party(io, board, players[0], players[1]);
    }

    public int getTotalPartyPlayed() {
        return totalPartyPlayed;
    }
}

package tictactoe;

public class PartyCreatorPsy extends PartyCreator {
    private int totalPartyPlayed = 0;

    public PartyCreatorPsy() {
        totalPartyPlayed = 0;
    }

    public Party newParty(IO io, int sizeBoard, GameTypes gameType) {
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

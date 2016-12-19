package tictactoe;

public class CountingPartyCreator extends PartyCreator {
    private int totalPartyPlayed = 0;

    public CountingPartyCreator() {
        totalPartyPlayed = 0;
    }

    public Party newParty(IO io, int sizeBoard, GameTypes gameType) {
        totalPartyPlayed++;
        return super.newParty(io, sizeBoard, gameType);
    }

    public int getTotalPartyPlayed() {
        return totalPartyPlayed;
    }
}

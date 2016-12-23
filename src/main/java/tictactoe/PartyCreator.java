package tictactoe;

public class PartyCreator {
    public Party newParty(IO io, Board board, GameTypes gameType) {
        PlayerFactory playerFactory = new PlayerFactory(io, board);
        Player[] players = playerFactory.getPlayers(gameType);

        return new Party(board, players[0], players[1]);
    }
}

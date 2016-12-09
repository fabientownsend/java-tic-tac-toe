package tictactoe;

public class PartyCreator {
    public Party newParty(IO io, int sizeBoard, GameTypes gameType) {
        Board board = new Board(sizeBoard);

        PlayerFactory playerFactory = new PlayerFactory(io, board);
        Player[] players = playerFactory.getPlayers(gameType);

        return new Party(io, board, players[0], players[1]);
    }
}

package tictactoe;

public class PartyCreator {
    public static GamePlay newParty(IO io, int sizeBoard, GameTypes gameType) {
        Board board = new Board(sizeBoard);

        PlayerFactory playerFactory = new PlayerFactory(io, board);
        Player[] players = playerFactory.getPlayers(gameType);

        return new GamePlay(io, board, players[0], players[1]);
    }
}

package tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out, true);
        IO io = new CommandLine(input, output);
        Menu menu = new Menu(io);
        int boardSize = menu.getBoardSize();
        GameTypes gameType = menu.getGameType();

        Board board = new Board(boardSize);
        PlayerFactory playerFactory = new PlayerFactory(io, board);
        Player[] players = playerFactory.getPlayers(gameType);

        GamePlay game = new GamePlay(io, board, players[0], players[1]);
        game.play();
    }
}

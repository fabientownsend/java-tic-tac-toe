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
        int boardSize = menu.sizeBoard(3, 5);
        int gameType = menu.typeGame(1, 3);

        Board board = new Board(boardSize);
        PlayerFactory playerFactory = new PlayerFactory(io, board);
        Player[] players = playerFactory.getPlayers(convert(gameType));

        GamePlay game = new GamePlay(io, board, players[0], players[1]);
        game.play();
    }

    private static String convert(int gameType) {
        if (gameType == 1) {
            return "HUMANvsHUMAN";
        } else if (gameType == 2) {
            return "COMPUTERvsHUMAN";
        } else if (gameType == 3) {
            return "COMPUTERvsCOMPUTER";
        } else {
            return "HUMANvsHUMAN";
        }
    }
}

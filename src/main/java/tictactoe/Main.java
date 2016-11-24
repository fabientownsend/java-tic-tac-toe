package tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out, true);
        IO io = new CommandLine(input, output);
        Player player_1 = new CommandLinePlayer(io, Marks.CROSS);
        Board board = new Board();
        Player player_2 = new ComputerPlayer(Marks.ROUND, board);
        GamePlay game = new GamePlay(io, board, player_1, player_2);
        game.play();
    }
}

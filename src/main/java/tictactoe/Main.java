package tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out, true);
        IO io = new CommandLine(input, output);
        Board board = new Board();

        Player playerOne = new CommandLinePlayer(io, Marks.CROSS);
        Player playerTwo = new ComputerPlayer(Marks.ROUND, board);

        GamePlay game = new GamePlay(io, board, playerOne, playerTwo);
        game.play();
    }
}

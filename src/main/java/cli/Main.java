package tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out, true);
        IO io = new CommandLine(input, output);
        PartyCreator partyCreator = new PartyCreator();

        Game game = new Game(io, partyCreator);
        game.start();
    }
}

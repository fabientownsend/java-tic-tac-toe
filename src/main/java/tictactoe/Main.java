package tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out, true);
        IOGame io = new IO(input, output);

        GamePlay gp = new GamePlay(io);
        gp.play();
        System.out.println("The party is over");
    }
}

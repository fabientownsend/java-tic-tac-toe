package tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class IO implements IOGame {
    BufferedReader input;
    PrintWriter output;

    public IO(BufferedReader input, PrintWriter output) {
        this.input = input;
        this.output = output;
    }

    public void write(String input) {
        output.printf(input);
    }

    public String read() {
        try {
            return input.readLine();
        } catch (IOException e) {
            // log
            return "";
        }
    }
}

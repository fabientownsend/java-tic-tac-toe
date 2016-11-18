package tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CommandLine implements IO {
    private BufferedReader input;
    private PrintWriter output;
    private final String ERROR = "Error";

    public CommandLine(BufferedReader input, PrintWriter output) {
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
            return ERROR;
        }
    }
}

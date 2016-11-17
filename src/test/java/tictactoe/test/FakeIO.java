package tictactoe.test;

import tictactoe.IOGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

class FakeIO implements IOGame {
    private BufferedReader input;
    private PrintWriter output;

    public FakeIO(BufferedReader input, PrintWriter output) {
        this.input = input;
        this.output = output;
    }

    public String read() {
        try {
            return input.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    public void write(String input) {
        output.printf(input);
    }
}
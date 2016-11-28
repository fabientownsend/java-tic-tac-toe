package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class CommandLineTest {
    private CommandLine cli;
    private StringWriter out;

    @Before
    public void initialize() {
        BufferedReader input = new BufferedReader(new StringReader("world"));
        out = new StringWriter();
        PrintWriter output = new PrintWriter(out, true);

        cli = new CommandLine(input, output);
    }

    @Test
    public void displayTheInput() throws Exception {
        cli.write("hello");
        assertEquals( "hello", out.toString());
    }

    @Test
    public void readTheUserInput() throws Exception {
        assertEquals(cli.read(), "world");
    }

    @Test
    public void handleIOException() throws Exception {
        BufferedReader ioExceptionThrower = new IOExceptionThrower();
        out = new StringWriter();
        PrintWriter output = new PrintWriter(out, true);
        cli = new CommandLine(ioExceptionThrower, output);

        assertEquals(cli.read(), "Error");
    }
}

final class IOExceptionThrower extends BufferedReader {
    public IOExceptionThrower() {
        super(new StringReader(""));
    }

    @Override
    public String readLine() throws IOException {
        throw new IOException();
    }
}


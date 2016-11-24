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
    public void itWriteInTheCommandLine() throws Exception {
        cli.write("hello");
        assertEquals( "hello", out.toString());
    }

    @Test
    public void itReadFromTheCommandLine() throws Exception {
        assertEquals(cli.read(), "world");
    }

    @Test
    public void itRaiseAnException() throws Exception {
        BufferedReader input = new FakeBuffered(new StringReader("world"));
        out = new StringWriter();
        PrintWriter output = new PrintWriter(out, true);
        cli = new CommandLine(input, output);

        assertEquals(cli.read(), "Error");
    }
}

final class FakeBuffered extends BufferedReader {
    FakeBuffered(final Reader reader) {
        super(reader);
    }

    @Override
    public String readLine() throws IOException {
        throw new IOException();
    }
}


package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.assertj.core.api.Java6Assertions.assertThat;

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
    public void displayTheInput() {
        cli.write("hello");
        assertThat(out.toString()).isEqualTo("hello");
    }

    @Test
    public void readTheUserInput() {
        assertThat(cli.read()).isEqualTo("world");
    }

    @Test
    public void handleIOException() {
        BufferedReader ioExceptionThrower = new IOExceptionThrower();
        out = new StringWriter();
        PrintWriter output = new PrintWriter(out, true);
        cli = new CommandLine(ioExceptionThrower, output);

        assertThat(cli.read()).isEqualTo("Error");
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
}


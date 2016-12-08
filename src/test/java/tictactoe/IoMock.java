package tictactoe;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

public class IoMock {
    private StringWriter out;
    private IO mockedIo;

    public  IoMock() {
        this("");
    }

    public IoMock(String text) {
        BufferedReader input = new BufferedReader(new StringReader(text));
        out = new StringWriter();
        PrintWriter output = new PrintWriter(out, true);

        mockedIo = new FakeIO(input, output);
    }

    public void createIoMock(String text) {
        BufferedReader input = new BufferedReader(new StringReader(text));
        out = new StringWriter();
        PrintWriter output = new PrintWriter(out, true);

        mockedIo = new FakeIO(input, output);
    }

    public IO getIoMocked() {
        return mockedIo;
    }

    public String getOutpout() {
        return out.toString();
    }
}

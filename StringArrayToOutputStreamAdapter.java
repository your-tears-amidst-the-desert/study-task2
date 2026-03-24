package main.java;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class StringArrayToOutputStreamAdapter {
    private final OutputStream outputStream;

    public StringArrayToOutputStreamAdapter(OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalArgumentException("OutputStream не должен быть null");
        }
        this.outputStream = outputStream;
    }

    public void writeStrings(String[] lines) throws IOException {
        if (lines == null) {
            return;
        }
        for (String line : lines) {
            String safeLine = line == null ? "null" : line;
            outputStream.write((safeLine + System.lineSeparator()).getBytes(StandardCharsets.UTF_8));
        }
        outputStream.flush();
    }
}

package main.java;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MultiplyProxy implements MultiplyService {
    private final String host;
    private final int port;

    public MultiplyProxy(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public double multiply(double a, double b) throws IOException {
        try (Socket socket = new Socket(host, port);
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             DataInputStream in = new DataInputStream(socket.getInputStream())) {
            out.writeDouble(a);
            out.writeDouble(b);
            out.flush();
            return in.readDouble();
        }
    }
}

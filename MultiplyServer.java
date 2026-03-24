package main.java;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiplyServer {
    public static void main(String[] args) throws IOException {
        int port = 5000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("MultiplyServer запущен на порту " + port);
            while (true) {
                Socket client = serverSocket.accept();
                new Thread(() -> handle(client)).start();
            }
        }
    }

    private static void handle(Socket client) {
        try (Socket socket = client;
             DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            double a = in.readDouble();
            double b = in.readDouble();
            double result = a * b;
            out.writeDouble(result);
            out.flush();
        } catch (IOException e) {
            System.err.println("Ошибка обслуживания клиента: " + e.getMessage());
        }
    }
}

package main.java;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AdapterDemoMain {
    public static void main(String[] args) throws IOException {
        String[] input = {"Adapter", "преобразует", "интерфейсы"};

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        StringArrayToOutputStreamAdapter adapter = new StringArrayToOutputStreamAdapter(output);
        adapter.writeStrings(input);

        System.out.println("Результат записи в байтовый поток:");
        System.out.println(output);
    }
}

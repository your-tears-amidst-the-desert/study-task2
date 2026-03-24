package main.java;

public class AutoFactory implements TransportFactory {
    @Override
    public Transport createInstance(String name, int size) {
        return new SimpleTransport(name, size);
    }
}

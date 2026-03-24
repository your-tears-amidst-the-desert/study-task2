package main.java;

public interface TransportFactory {
    Transport createInstance(String name, int size) throws VehicleException;
}

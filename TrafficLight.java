package main.java;

public class TrafficLight {
    public enum Signal { RED, YELLOW, GREEN }

    private Signal signal = Signal.RED;

    public Signal getSignal() {
        return signal;
    }

    public void next() {
        signal = switch (signal) {
            case RED -> Signal.YELLOW;
            case YELLOW -> Signal.GREEN;
            case GREEN -> Signal.RED;
        };
    }
}

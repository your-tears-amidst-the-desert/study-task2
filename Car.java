package main.java;

public class Car {
    private int x = 20;
    private final int y = 190;
    private final int speed = 3;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move() {
        x += speed;
        if (x > 620) {
            x = -80;
        }
    }
}

package main.java;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class TrafficSimulationFacade extends JPanel {
    private static final int LIGHT_X = 360;
    private static final int LIGHT_SWITCH_MS = 1200;

    private final Car car = new Car();
    private final TrafficLight trafficLight = new TrafficLight();

    public TrafficSimulationFacade() {
        setPreferredSize(new Dimension(640, 280));
        setBackground(new Color(225, 235, 245));

        Timer lightTimer = new Timer(LIGHT_SWITCH_MS, e -> trafficLight.next());
        Timer animationTimer = new Timer(25, e -> {
            if (trafficLight.getSignal() == TrafficLight.Signal.GREEN || car.getX() + 80 < LIGHT_X - 20) {
                car.move();
            }
            repaint();
        });

        lightTimer.start();
        animationTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawRoad(g);
        drawTrafficLight(g);
        drawCar(g);
    }

    private void drawRoad(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 170, getWidth(), 100);
    }

    private void drawTrafficLight(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(LIGHT_X, 85, 28, 82);

        drawLamp(g, 366, 95, Color.RED, trafficLight.getSignal() == TrafficLight.Signal.RED);
        drawLamp(g, 366, 120, Color.YELLOW, trafficLight.getSignal() == TrafficLight.Signal.YELLOW);
        drawLamp(g, 366, 145, Color.GREEN, trafficLight.getSignal() == TrafficLight.Signal.GREEN);
    }

    private void drawLamp(Graphics g, int x, int y, Color color, boolean active) {
        g.setColor(active ? color : color.darker().darker());
        g.fillOval(x, y, 12, 12);
    }

    private void drawCar(Graphics g) {
        g.setColor(new Color(45, 120, 220));
        g.fillRect(car.getX(), car.getY(), 80, 26);

        g.setColor(Color.BLACK);
        g.fillOval(car.getX() + 10, car.getY() + 20, 16, 16);
        g.fillOval(car.getX() + 54, car.getY() + 20, 16, 16);
    }
}

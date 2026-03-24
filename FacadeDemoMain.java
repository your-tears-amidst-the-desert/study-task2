package main.java;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FacadeDemoMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Facade: автомобиль и светофор");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new TrafficSimulationFacade());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

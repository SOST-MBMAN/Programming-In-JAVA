import javax.swing.*;
import java.awt.*;

public class SimpleSwingApp {
    public static void main(String[] args) {
        // Create the top-level container (JFrame)
        JFrame frame = new JFrame("Simple Swing Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a panel with FlowLayout
        JPanel panel = new JPanel(new FlowLayout());

        // Add components to the panel
        JLabel label = new JLabel("Welcome to Swing!");
        JButton button = new JButton("Click Me");
        panel.add(label);
        panel.add(button);

        // Add panel to frame
        frame.add(panel);

        // Display the frame
        frame.setVisible(true);
    }
}
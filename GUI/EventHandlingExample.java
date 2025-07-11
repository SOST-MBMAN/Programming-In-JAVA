import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventHandlingExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create a JFrame
            JFrame frame = new JFrame("Event Handling Example");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.setLocationRelativeTo(null);

            // Create a JPanel for mouse events
            JPanel panel = new JPanel();
            panel.setBackground(Color.WHITE);
            JLabel mouseLabel = new JLabel("Click or move the mouse here");
            panel.add(mouseLabel);

            // Create a JTextField for keyboard events
            JTextField textField = new JTextField(20);
            JLabel keyLabel = new JLabel("Type in the text field");
            JPanel inputPanel = new JPanel();
            inputPanel.add(textField);
            inputPanel.add(keyLabel);

            // Add mouse listeners to the panel
            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    mouseLabel.setText("Mouse clicked at (" + e.getX() + ", " + e.getY() + ")");
                }
            });
            panel.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    mouseLabel.setText("Mouse moved to (" + e.getX() + ", " + e.getY() + ")");
                }
            });

            // Add key listener to the text field
            textField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    keyLabel.setText("Key typed: " + e.getKeyChar());
                }
            });

            // Add components to the frame
            frame.add(panel, BorderLayout.CENTER);
            frame.add(inputPanel, BorderLayout.SOUTH);

            // Make the frame visible
            frame.setVisible(true);
        });
    }
}
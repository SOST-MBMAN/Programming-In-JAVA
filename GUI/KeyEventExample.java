import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class KeyEventExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Key Event Example");
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());
            frame.setLocationRelativeTo(null);

            // Create components
            JTextField textField = new JTextField(15);
            JLabel label = new JLabel("Type in the text field");

            // Add KeyListener
            textField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    label.setText("Typed: " + e.getKeyChar());
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        label.setText("Enter pressed!");
                    }
                }
            });

            // Add components
            frame.add(textField);
            frame.add(label);

            frame.setVisible(true);
        });
    }
}
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AtomicComponentsExample {
    public static void main(String[] args) {
        // Run on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            // Create a JFrame
            JFrame frame = new JFrame("Atomic Components Example");
            frame.setSize(400, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());
            frame.setLocationRelativeTo(null);

            // Create a JLabel
            JLabel label = new JLabel("Enter your name:");
            label.setFont(new Font("Arial", Font.PLAIN, 16)); // Customize font

            // Create a JTextField
            JTextField textField = new JTextField(15);
            textField.setToolTipText("Type your name here"); // Add tooltip

             // Create a JTextField2
            JTextField textField2 = new JTextField(15);
            textField2.setToolTipText("Type your name here"); // Add tooltip

            // Create a JButton
            JButton button = new JButton("Submit");
            button.setBackground(Color.BLUE); // Customize background
            button.setForeground(Color.WHITE); // Customize text color

            // Create an output JLabel
            JLabel output = new JLabel("Output will appear here");

            // Add components to the frame
            frame.add(label);
            frame.add(textField);
            frame.add(textField2);
            frame.add(button);
            frame.add(output);

            // Add action listener to the button
            button.addActionListener(e -> {
                String name = textField.getText();
                output.setText("Hello, " + (name.isEmpty() ? "User" : name) + "!");
            });

            // Make the frame visible
            frame.setVisible(true);
        });
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonClickExample {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Button Click Example");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());
        
        // Create a label
        JLabel label = new JLabel("Click the button!");
        frame.add(label);
        
        // Create a button
        JButton button = new JButton("Click Me");
        frame.add(button);
        
        // Add an ActionListener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Button Clicked!");
            }
        });
        
        // Make the frame visible
        frame.setVisible(true);
    }
}
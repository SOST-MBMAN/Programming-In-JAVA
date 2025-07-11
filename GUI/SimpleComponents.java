import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SimpleComponents {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Simple Components Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        // Create a label
        JLabel label = new JLabel("Welcome to Swing!");
        label.setBounds(150, 50, 150, 30); // x, y, width, height
        
        // Create a button
        JButton button = new JButton("Click Me");
        button.setBounds(150, 100, 100, 30);
        
        // Add components to the frame
        frame.add(label);
        frame.add(button);
        
        // Set the layout to null (absolute positioning)
        frame.setLayout(null);
        
        // Make the frame visible
        frame.setVisible(true);
    }
}
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SimpleFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> {
        // Create a new JFrame (top-level window)
        JFrame frame = new JFrame("My First Swing Application");
        
        // Set the size of the window (width, height in pixels)
        frame.setSize(400, 300);
        
        // Specify what happens when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Center the window on the screen
        frame.setLocationRelativeTo(null);
        
        // Make the window visible
        frame.setVisible(true);
    });
    }
}
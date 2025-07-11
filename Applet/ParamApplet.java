import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;

public class ParamApplet extends Applet {
    private String message;
    private int fontSize;

    public void init() {
        // Retrieve parameters
        message = getParameter("message");
        if (message == null) {
            message = "No message provided";
        }

        String fontSizeStr = getParameter("fontSize");
        try {
            fontSize = Integer.parseInt(fontSizeStr);
        } catch (NumberFormatException e) {
            fontSize = 12; // Default font size
        }
    }

    public void paint(Graphics g) {
        // Set font and draw message
        g.setFont(new Font("Arial", Font.PLAIN, fontSize));
        g.drawString(message, 20, 100);
    }
}
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="DrawingPadApplet" width=500 height=400>
</applet>
*/

public class DrawingPadApplet extends Applet implements MouseMotionListener {
    private int x = -1, y = -1;

    public void init() {
        setBackground(Color.WHITE);
        addMouseMotionListener(this);
    }

    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        Graphics g = getGraphics();
        g.setColor(Color.BLUE);
        g.fillOval(x, y, 4, 4); // draw a small circle where mouse is dragged
    }

    public void mouseMoved(MouseEvent e) {
        // Not used
    }

    public void paint(Graphics g) {
        g.setColor(Color.GRAY);
        g.drawString("Drag the mouse to draw", 20, 20);
    }
}

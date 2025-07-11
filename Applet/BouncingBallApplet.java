import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class BouncingBallApplet extends Applet implements Runnable {
    int x = 50, y = 50, dx = 2, dy = 2;
    int radius = 20;
    Thread t;

    public void init() {
        setBackground(Color.BLACK);
    }

    public void start() {
        t = new Thread(this);
        t.start();
    }

    public void run() {
        while (true) {
            x += dx;
            y += dy;

            if (x < 0 || x > getWidth() - radius)
                dx = -dx;
            if (y < 0 || y > getHeight() - radius)
                dy = -dy;

            repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(x, y, radius, radius);
    }
}

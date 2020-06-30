package rendering;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Panel extends JPanel {
    private int width;
    private int height;

    public Panel(int width, int height) {
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.width = width;
        this.height = height;
    }

    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    public void paintComponent(Graphics g) {
//        super.paintComponent(g);

        // Draw Text
        g.drawString("This is my custom Panel!", 10, 20);
    }
}

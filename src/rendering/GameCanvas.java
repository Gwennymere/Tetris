package rendering;


import java.awt.*;

public class GameCanvas extends Canvas {
    private Color color = new Color(0x000000);
    private int red = 0;
    private int blue = 0;
    private int green = 0;

    public GameCanvas(int width, int height) {
        this.setSize(width, height);
    }

    public void setBufferStrat(int bufferCount) {
        this.createBufferStrategy(bufferCount);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for(int x = 0; x < 100; x++) {
            for(int y = 0; y < 100; y++) {
                g.setColor(this.color);
                g.drawLine(x, y, x, y);
            }
        }
    }

    public void alterColor() {
        red++;
        blue++;
        green++;
        if (red > 255) {
            red = 0;
            blue = 0;
            green = 0;
        }
        this.color = new Color(red, green, blue);

    }
}

package rendering;


import java.awt.Canvas;

public class GameCanvas extends Canvas {
    public GameCanvas(int width, int height) {
        this.setSize(width, height);
    }

    public void setBufferStrat(int bufferCount) {
        this.createBufferStrategy(bufferCount);
    }
}

package rendering;

import javax.swing.*;

public class Renderer {
    private static final int DEFAULT_DIMENSION_X = 1240;
    private static final int DEFAULT_DIMENSION_Y = 800;
    private final JFrame frame;
    private GameCanvas canvas;

    public Renderer() {
        this(DEFAULT_DIMENSION_X, DEFAULT_DIMENSION_Y);
    }

    public Renderer(int width, int height) {
        this.frame = this.setupNewJFrame(width, height);
    }

    private JFrame setupNewJFrame(int width, int height) {
        JFrame frame = new JFrame("Swing Paint Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        this.canvas = new GameCanvas(width, height);
        frame.add(this.canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return frame;
    }

    /**
     * Kann aufgrund der Architektur nicht im Konstruktor aufgerufen werden
     */
    public void setBufferStrat(int bufferSize) {
        this.canvas.setBufferStrat(bufferSize);
    }

    public void render() {
        canvas.alterColor();
        canvas.repaint();
    }
}

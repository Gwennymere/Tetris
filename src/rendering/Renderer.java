package rendering;

import logic.state.EngineState;

import javax.swing.*;

public class Renderer {
    private static final int DEFAULT_DIMENSION_X = 1240;
    private static final int DEFAULT_DIMENSION_Y = 800;
    private final JFrame frame;
    private GameCanvas canvas;
    private final EngineState engineState;

    public Renderer(EngineState eState) {
        this(DEFAULT_DIMENSION_X, DEFAULT_DIMENSION_Y, eState);
    }

    public Renderer(int width, int height, EngineState engineState) {
        this.frame = this.setupNewJFrame(width, height);
        this.engineState = engineState;
    }

    private JFrame setupNewJFrame(int width, int height) {
        JFrame frame = new JFrame("Swing Paint Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        this.canvas = new GameCanvas(width, height);
        frame.add(this.canvas);
        frame.pack();
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
        System.out.println(this.engineState.getFps());
    }
}

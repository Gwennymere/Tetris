package rendering;

import javax.swing.*;

public class Renderer {
    private static final int DEFAULT_DIMENSION_X = 1240;
    private static final int DEFAULT_DIMENSION_Y = 800;
    private final JFrame frame;
    private GamePanel panel;
    private JPanel mainPanel;
    private int width;
    private int height;

    public Renderer() {
        this(DEFAULT_DIMENSION_X, DEFAULT_DIMENSION_Y);
    }

    public Renderer(int width, int height) {
        this.width = width;
        this.height = height;
        this.frame = this.setupNewJFrame();
    }

    private JFrame setupNewJFrame() {
        JFrame frame = new JFrame("Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        this.mainPanel = (JPanel) frame.getContentPane();
        addFreshPanelToMainPanel();

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return frame;
    }

    public void setupMainMenuScreen(JPanel scene) {
        resetAllPanels();
        panel.add(scene);
        frame.pack();
    }

    private void clearMainPanel() {
        this.mainPanel.remove(0);
    }

    private void resetAllPanels() {
        clearMainPanel();
        addFreshPanelToMainPanel();
    }

    private void addFreshPanelToMainPanel() {
        this.panel = new GamePanel(width, height);
        this.mainPanel.add(this.panel);
    }

    /**
     * Kann aufgrund der Architektur nicht im Konstruktor aufgerufen werden
     */
    public void setBufferStrat(int bufferSize) {
        this.panel.setBufferStrat(bufferSize);
    }

    public void render() {
        panel.alterColor();
        panel.repaint();
    }
}

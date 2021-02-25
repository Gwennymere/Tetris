package logic.Manager;

import logic.App;
import logic.clocking.Clock;
import logic.state.RenderState;
import rendering.Renderer;

import javax.swing.*;

public class RenderManager extends Clock {

    private final Renderer renderer;
    private static final int BUFFER_SIZE = 2;
    private final RenderState renderState;

    public RenderManager(RenderState renderState, int maxFps) {
        super(App.NANO_SECONDS_IN_SECOND / maxFps);
        this.renderState = renderState;
        this.renderer = new Renderer();
        this.renderer.setBufferStrat(BUFFER_SIZE);
    }

    public RenderManager(RenderState eState) {
        this(eState, 60);
    }

    public void switchScene(JPanel scene) {
        renderer.setupMainMenuScreen(scene);
    }

    @Override
    protected void clockTick(long lastUpdateTime) {
        renderState.update(lastUpdateTime);
        System.out.println("FPS: " + renderState.getFps());
        renderer.render();
    }
}

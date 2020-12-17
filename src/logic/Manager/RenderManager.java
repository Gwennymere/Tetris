package logic.Manager;

import logic.Main;
import logic.clocking.GameClock;
import logic.state.RenderState;
import rendering.Renderer;

public class RenderManager extends GameClock {

    private final Renderer renderer;
    private static final int BUFFER_SIZE = 2;
    private final RenderState renderState;

    public RenderManager(RenderState renderState, int maxFps) {
        super(Main.NANO_SECONDS_IN_SECOND / maxFps);
        this.renderState = renderState;
        this.renderer = new Renderer();
        this.renderer.setBufferStrat(BUFFER_SIZE);
    }

    public RenderManager(RenderState eState) {
        this(eState, 60);
    }

    @Override
    protected void clockTick(long lastUpdateTime) {
        renderState.update(lastUpdateTime);
        System.out.println("FPS: " + renderState.getFps());
        renderer.render();
    }
}

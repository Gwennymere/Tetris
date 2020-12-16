package logic.Manager;

import logic.clocking.GameClock;
import logic.state.EngineState;
import logic.update.fixedUpdate.FixedUpdatable;
import rendering.Renderer;

public class RenderManager implements Runnable, FixedUpdatable {

    private final Renderer renderer;
    private final int BUFFER_SIZE = 2;

    public RenderManager(GameClock clock, EngineState eState) {
        this.registerWithClock(clock);
        this.renderer = new Renderer(eState);
        this.renderer.setBufferStrat(BUFFER_SIZE);
    }

    public void registerWithClock(GameClock clock) {
        clock.register(this);
    }

    @Override
    public void run() {
        while (true) {
            renderer.render();
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update() {
        synchronized (this) {
            notify();
        }
    }
}

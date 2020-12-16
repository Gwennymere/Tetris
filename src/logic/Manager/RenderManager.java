package logic.Manager;

import logic.clocking.GameClock;
import logic.update.updatable.FixedUpdatable;
import rendering.Renderer;

public class RenderManager implements Runnable, FixedUpdatable {

    private final Renderer renderer;
    private final int BUFFER_SIZE = 2;

    public RenderManager(GameClock clock) {
        this.registerWithClock(clock);
        this.renderer = new Renderer();
        this.renderer.setBufferStrat(BUFFER_SIZE);
    }

//    @Override
//    public void update(long timeElapsed) {
//        update();
//    }
//
//    @Override
//    public void registerWithClock(GameClock clock) {
//        clock.registerUpdatable(this);
//    }

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
    public void update(Long data) {

    }

    @Override
    public void update() {
        synchronized (this) {
            notify();
        }
    }
}

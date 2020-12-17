package logic.Manager;

import logic.Main;
import logic.clocking.GameClock;
import logic.state.RenderState;
import rendering.Renderer;

public class RenderManager extends GameClock {

    private final Renderer renderer;
    private final int BUFFER_SIZE = 2;

    public RenderManager(RenderState renderState, int maxFps) {
        super(Main.NANO_SECONDS_IN_SECOND / maxFps);
        this.renderer = new Renderer(renderState);
        this.renderer.setBufferStrat(BUFFER_SIZE);
    }

    public RenderManager(RenderState eState) {
        this(eState, 60);
    }

//    @Override
//    public void run() {
//        while (true) {
//            renderer.render();
//            synchronized (this) {
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    @Override
    protected boolean clockTick(long lastUpdateTime) {
        return false;
    }

//    @Override
//    public void updateNow() {
//        synchronized (this) {
//            notify();
//        }
//    }
}

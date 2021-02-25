package logic.state;

import logic.App;
import logic.update.updatables.LongUpdatable;

public class RenderState implements LongUpdatable {
    private long fpsResetTimer = 0;
    private int fpsCounter = 0;
    private int currentFps = 0;

//    public RenderState(Updater clock) {
    public RenderState() {
//        clock.register(this);
    }

    public double getFps() {
        return currentFps;
    }

    @Override
    public void update(Long timeSinceLastUpdate) {
        fpsCounter++;
        fpsResetTimer += timeSinceLastUpdate;
        if (fpsResetTimer > App.NANO_SECONDS_IN_SECOND) {
            currentFps = fpsCounter;
            System.out.println(currentFps);
            fpsCounter = 0;
            fpsResetTimer -= App.NANO_SECONDS_IN_SECOND;
        }
    }
}

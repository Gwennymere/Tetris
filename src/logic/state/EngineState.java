package logic.state;

import logic.clocking.GameClock;
import logic.update.unfixedUpdate.unfixedUpdatables.DoubleUpdatable;

public class EngineState implements DoubleUpdatable {
    private double fpsTimer = 0;
    private double fpsCounter = 0;
    private double currentFps = 0;

    public EngineState(GameClock clock) {
        clock.register(this);
    }

    public double getFps() {
        return currentFps;
    }

    @Override
    public void update(Double updateInfo) {
        fpsCounter++;
        if (fpsTimer > 1) {
            currentFps = fpsCounter;
            fpsCounter = 0;
            fpsTimer -= 1;
        }
    }
}

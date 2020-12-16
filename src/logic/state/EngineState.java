package logic.state;

import logic.Main;
import logic.clocking.GameClock;
import logic.update.unfixedUpdate.unfixedUpdatables.LongUpdatable;

public class EngineState implements LongUpdatable {
    private long fpsResetTimer = 0;
    private int fpsCounter = 0;
    private int currentFps = 0;

    public EngineState(GameClock clock) {
        clock.register(this);
    }

    public double getFps() {
        return currentFps;
    }

    @Override
    public void update(Long timeSinceLastUpdate) {
        fpsCounter++;
        fpsResetTimer += timeSinceLastUpdate;
        System.out.println(timeSinceLastUpdate + " || " + fpsResetTimer);
        if (fpsResetTimer > Main.NANO_SECONDS_IN_SECOND) {
            currentFps = fpsCounter;
            fpsCounter = 0;
            fpsResetTimer -= Main.NANO_SECONDS_IN_SECOND;
        }
    }
}

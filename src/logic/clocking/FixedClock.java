package logic.clocking;

import logic.Main;
import logic.update.fixedUpdate.FixedUpdatable;
import logic.update.fixedUpdate.FixedUpdater;

import java.util.ArrayList;

public class FixedClock extends GameClock implements FixedUpdater{
    private static final int DEFAULT_RENDERPROCESSES_PER_SECOND = 60;

    private final ArrayList<FixedUpdatable> fixedUpdatables = new ArrayList<>();

    private int fixedUpdatesPerSecond;
    private int fixedUpdateRateInNanoSeconds;

    public FixedClock() {
        this(FixedClock.DEFAULT_RENDERPROCESSES_PER_SECOND);
    }

    public FixedClock(int fixedUpdatesPerSecond) {
        this.setupClock(fixedUpdatesPerSecond);
    }

    private void setupClock(int fixedUpdatesPerSecond) {
        this.fixedUpdatesPerSecond = fixedUpdatesPerSecond;
        this.fixedUpdateRateInNanoSeconds = Main.NANO_SECONDS_IN_SECOND / this.fixedUpdatesPerSecond;
    }

    @Override
    protected boolean clockTick(long lastUpdateTime) {
        if (lastUpdateTime > this.fixedUpdateRateInNanoSeconds) {
            updateNow();
            return true;
        }
        return false;
    }

    @Override
    public void register(FixedUpdatable updatable) {
        this.fixedUpdatables.add(updatable);
    }

    @Override
    public void deregister(FixedUpdatable updatable) {
        this.fixedUpdatables.remove(updatable);
    }

    @Override
    public void updateNow() {
        fixedUpdatables.forEach(
                FixedUpdatable::update
        );
    }
}

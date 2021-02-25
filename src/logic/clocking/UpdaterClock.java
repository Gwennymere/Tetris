package logic.clocking;

import logic.update.updatables.Updatable;
import logic.update.updater.Updater;

import java.util.ArrayList;

public class UpdaterClock<U extends Updatable> extends Clock implements Updater<U, Long> {
    private final ArrayList<U> updatables = new ArrayList<>();

    public UpdaterClock() {
        super();
    };

    public UpdaterClock(int clockCycleLength) {
        super(clockCycleLength);
    };

    @Override
    protected void clockTick(final long lastUpdateTime) {
        this.updateNow(lastUpdateTime);
    }

    @Override
    public void register(final U updatable) {
        this.updatables.add(updatable);
    }

    @Override
    public void deregister(final U updatable) {
        this.updatables.remove(updatable);
    }

    @Override
    public void updateNow(final Long lastUpdateTime) {
        updatables.forEach(
                updatable -> updatable.update(lastUpdateTime)
        );
    }
}

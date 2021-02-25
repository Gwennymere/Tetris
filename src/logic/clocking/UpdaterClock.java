package logic.clocking;

import logic.update.updatables.Updatable;
import logic.update.updater.Updater;

import java.util.ArrayList;

public class UpdaterClock<U extends Updatable> extends Clock implements Updater<U, Long> {
    private final ArrayList<U> unfixedUpdatables = new ArrayList<>();

    @Override
    protected void clockTick(final long lastUpdateTime) {
        this.updateNow(lastUpdateTime);
    }

    @Override
    public void register(final U updatable) {
        this.unfixedUpdatables.add(updatable);
    }

    @Override
    public void deregister(final U updatable) {
        this.unfixedUpdatables.remove(updatable);
    }

    @Override
    public void updateNow(final Long lastUpdateTime) {
        unfixedUpdatables.forEach(
                updatable -> updatable.update(lastUpdateTime)
        );
    }
}

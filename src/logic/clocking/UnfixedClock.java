package logic.clocking;

import logic.update.unfixedUpdate.Updatable;
import logic.update.unfixedUpdate.Updater;

import java.util.ArrayList;

public class UnfixedClock extends GameClock implements Updater {
    private final ArrayList<Updatable> unfixedUpdatables = new ArrayList<>();

    @Override
    protected boolean clockTick(long lastUpdateTime) {
        unfixedUpdatables.forEach(
                updatable -> updatable.update(lastUpdateTime)
        );
        return true;
    }

    @Override
    public void register(Updatable updatable) {
        this.unfixedUpdatables.add(updatable);
    }
}

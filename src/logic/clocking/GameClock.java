package logic.clocking;

import logic.Main;
import logic.update.fixedUpdate.FixedUpdatable;
import logic.update.fixedUpdate.FixedUpdater;
import logic.update.unfixedUpdate.Updatable;
import logic.update.unfixedUpdate.Updater;

import java.util.ArrayList;

public class GameClock implements Runnable, FixedUpdater, Updater {

    public static final int MIN_CLOCK_LENGTH_IN_NANO_SECOND = 100000;
    private static final int DEFAULT_RENDERPROCESSES_PER_SECOND = 60;
    private int fixedUpdatesPerSecond;
    private int fixedUpdateRateInNanoSeconds;

    private long totalElapsedTime = 0;
    private long lastFixedUpdateTime = 0;

    private final ArrayList<Updatable> unfixedUpdatables = new ArrayList<>();
    private final ArrayList<FixedUpdatable> fixedUpdatables = new ArrayList<>();

    public GameClock() {
        this.setupClock(this.DEFAULT_RENDERPROCESSES_PER_SECOND);
    }

    public GameClock(int fixedUpdatesPerSecond) {
        this.setupClock(fixedUpdatesPerSecond);
    }

    private void setupClock(int fixedUpdatesPerSecond) {
        this.fixedUpdatesPerSecond = fixedUpdatesPerSecond;
        this.fixedUpdateRateInNanoSeconds = Main.NANO_SECONDS_IN_SECOND / this.fixedUpdatesPerSecond;
    }

    @Override
    public void run() {
        this.totalElapsedTime = System.nanoTime();
        while (true) {
            long elapsedTime = System.nanoTime() - this.totalElapsedTime;

            if (elapsedTime > MIN_CLOCK_LENGTH_IN_NANO_SECOND) {
                this.lastFixedUpdateTime += elapsedTime;
                this.totalElapsedTime += elapsedTime;

                unfixedUpdatables.forEach(
                        updatable -> updatable.update(elapsedTime)
                );

                if (lastFixedUpdateTime > this.fixedUpdateRateInNanoSeconds) {
                    fixedUpdatables.forEach(
                            FixedUpdatable::update
                    );
                }
            }
        }
    }

    @Override
    public void register(FixedUpdatable updatable) {
        this.fixedUpdatables.add(updatable);
    }

    @Override
    public void register(Updatable updatable) {
        this.unfixedUpdatables.add(updatable);
    }

    public void unregisterUpdateable(FixedUpdatable updatable) {
        this.fixedUpdatables.remove(updatable);
    }

    public void unregisterUpdateable(Updatable updatable) {
        this.unfixedUpdatables.remove(updatable);
    }
}

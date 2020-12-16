package logic.clocking;

import logic.update.fixedUpdate.FixedUpdatable;
import logic.update.fixedUpdate.FixedUpdater;
import logic.update.unfixedUpdate.Updatable;
import logic.update.unfixedUpdate.Updater;

import java.util.ArrayList;

public class GameClock implements Runnable, FixedUpdater, Updater {

    private final int DEFAULT_RENDERPROCESSES_PER_SECOND = 60;
    private final int NANO_SECONDS_IN_SECOND = 1000000000;
    private final int MIN_CLOCK_LENGTH_IN_NANO_SECOND = 100000;
    private int renderProcessesPerSecond;
    private int renderProcessRateInNanoSeconds;

    private double totalElapsedTime = 0;
    private double lastFixedUpdateTime = 0;

    private final ArrayList<Updatable> unfixedUpdatables = new ArrayList<>();
    private final ArrayList<FixedUpdatable> fixedUpdatables = new ArrayList<>();

    public GameClock() {
        this.setupClock(this.DEFAULT_RENDERPROCESSES_PER_SECOND);
    }

    public GameClock(int renderProcessesPerSecond) {
        this.setupClock(renderProcessesPerSecond);
    }

    private void setupClock(int renderProcessesPerSecond) {
        this.renderProcessesPerSecond = renderProcessesPerSecond;
        this.renderProcessRateInNanoSeconds = NANO_SECONDS_IN_SECOND / this.renderProcessesPerSecond;
    }

    @Override
    public void run() {
        while (true) {
            double elapsedTime = System.nanoTime() - this.totalElapsedTime;

            if (elapsedTime > MIN_CLOCK_LENGTH_IN_NANO_SECOND) {
                this.lastFixedUpdateTime += elapsedTime;
                this.totalElapsedTime += elapsedTime;

                unfixedUpdatables.forEach(
                        updatable -> updatable.update(elapsedTime)
                );

                if (lastFixedUpdateTime > this.renderProcessRateInNanoSeconds) {
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

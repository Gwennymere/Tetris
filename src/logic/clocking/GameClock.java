package logic.clocking;

import javafx.beans.property.SimpleIntegerProperty;
import logic.update.updatable.FixedUpdatable;
import logic.update.updatable.GenericUpdatable;
import logic.update.updatable.UnfixedUpdatable;
import logic.update.updater.ClockUpdater;

import java.util.ArrayList;

public class GameClock implements Runnable, ClockUpdater {

    private final int DEFAULT_RENDERPROCESSES_PER_SECOND = 60;
    private final int NANO_SECONDS_IN_SECOND = 1000000000;
    private final int MIN_CLOCK_LENGTH_IN_NANO_SECOND = 100000;
    private int renderProcessesPerSecond;
    private int renderProcessRateInNanoSeconds;

    private long totalElapsedTime = 0;
    private long lastRenderProcessTime = 0;

    private final ArrayList<UnfixedUpdatable> unfixedUpdatables = new ArrayList<>();
    private final ArrayList<FixedUpdatable> fixedUpdatables = new ArrayList<>();

    // Debug
    private final int DESIRED_FRAME_COUNT = 20;
    private final int DESIRED_UPDATE_COUNT = 20;
    private final SimpleIntegerProperty fpsProperty = new SimpleIntegerProperty(0);
    private int fps = 0;
    private final SimpleIntegerProperty upsProperty = new SimpleIntegerProperty(0);
    private int ups = 0;
    private int timeToReachFrameCount = 0;
    private int timeToReachUpdateCount = 0;

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
//        for (int i = 0; i < 1000; i++) {
        while (true) {
            long elapsedTime = System.nanoTime() - this.totalElapsedTime;

            if (elapsedTime > MIN_CLOCK_LENGTH_IN_NANO_SECOND) {
//                System.out.println("ClockCycle after " + elapsedTime / 1000 + "ms");
                lastRenderProcessTime += elapsedTime;
                this.totalElapsedTime += elapsedTime;

                unfixedUpdatables.forEach(
                        GenericUpdatable::update
                );

                this.handleUpdateCountMeasurement(elapsedTime);

                if (lastRenderProcessTime > this.renderProcessRateInNanoSeconds) {
                    lastRenderProcessTime = 0;
                    fixedUpdatables.forEach(
                            FixedUpdatable::update
                    );

                    this.handleFrameCountMeasurement(lastRenderProcessTime);
                }
            }
        }
    }

    private void handleFrameCountMeasurement(long lastRenderProcessTime) {
        fps++;
        timeToReachFrameCount += lastRenderProcessTime;
        if (fps >= DESIRED_FRAME_COUNT) {
            fps = 0;
            this.publishFrameMeasurements();
        }
    }

    private void publishFrameMeasurements() {

    }

    private void handleUpdateCountMeasurement(long elapsedTime) {
        ups++;
        timeToReachUpdateCount += elapsedTime;
        if (ups >= DESIRED_UPDATE_COUNT) {
            ups = 0;
            this.publishUpdateMeasurements();
        }
    }

    private void publishUpdateMeasurements() {

    }

    public void register(FixedUpdatable updatable) {
        this.fixedUpdatables.add(updatable);
    }

    public void register(UnfixedUpdatable updatable) {
        this.unfixedUpdatables.add(updatable);
    }

    public void unregisterUpdateable(FixedUpdatable updatable) {
        this.fixedUpdatables.remove(updatable);
    }

    public void unregisterUpdateable(UnfixedUpdatable updatable) {
        this.unfixedUpdatables.remove(updatable);
    }
}

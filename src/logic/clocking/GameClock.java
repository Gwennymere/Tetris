package logic.clocking;

public abstract class GameClock implements Runnable {

    private static final int MIN_CLOCK_LENGTH_IN_NANO_SECOND = 100000;

    private long totalElapsedTime = 0;
    private long lastUpdateTime = 0;
    private long tickCap;

    public GameClock(long tickCap) {
        this.tickCap = tickCap;
    }

    public GameClock() {
        this(GameClock.MIN_CLOCK_LENGTH_IN_NANO_SECOND);
    }

    @Override
    public void run() {
        this.totalElapsedTime = System.nanoTime();
        while (true) {
            long elapsedTime = System.nanoTime() - this.totalElapsedTime;

            if (elapsedTime > tickCap) {
                if (this.clockTick(elapsedTime)) {
                    this.lastUpdateTime += elapsedTime;
                    this.totalElapsedTime += elapsedTime;
                }
            }
        }
    }

    protected abstract boolean clockTick(long lastUpdateTime);

//    public void unregisterUpdateable(FixedUpdatable updatable) {
//        this.fixedUpdatables.remove(updatable);
//    }
//
//    public void unregisterUpdateable(Updatable updatable) {
//        this.unfixedUpdatables.remove(updatable);
//    }
}

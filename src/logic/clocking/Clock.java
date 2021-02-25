package logic.clocking;

public abstract class Clock implements Runnable {

    private static final int MIN_CLOCK_LENGTH_IN_NANO_SECOND = 100000;

    private long totalElapsedTime = 0;
    private long lastUpdateTime = 0;
    private long tickCap;
    private boolean paused = false;
    private long lastToggleTime;
    private long pauseTime;

    public Clock(long tickCap) {
        super();
        this.tickCap = tickCap;
    }

    public Clock() {
        this(Clock.MIN_CLOCK_LENGTH_IN_NANO_SECOND);
    }

    @Override
    public void run() {
        this.totalElapsedTime = System.nanoTime();
        this.lastToggleTime = totalElapsedTime;
        while (true) {
            if (!paused) {
                long elapsedTime = System.nanoTime() - this.totalElapsedTime;

                if (elapsedTime > tickCap + pauseTime) {
                    this.clockTick(elapsedTime);
                    this.lastUpdateTime += elapsedTime;
                    this.totalElapsedTime += elapsedTime;
                    this.pauseTime = 0;
                }
            } else {
                /*
                    Das gesamte else ist ein Workaround, da die Schleife nach dem Pausieren sonst nicht mehr ausgeführt wird. Warum?
                    Schau dir mal Ne BlockingQueue an. Ansonsten Thread sleep. Oder await awake?
                 */
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected abstract void clockTick(long lastUpdateTime);

    protected void togglePause() {
        paused = !paused;
        long curr = System.nanoTime();
        if (!paused) {
            pauseTime = curr - lastToggleTime;
        } else {
            pauseTime = 0;
        }
        lastToggleTime = curr;
    }
}

package logic;

import logic.Manager.RenderManager;
import logic.clocking.UnfixedClock;
import logic.state.EngineState;

public class Main {
    public static final int NANO_SECONDS_IN_SECOND = 1000000000;


    public static void main(String[] args) {
//        FixedClock renderClock = new FixedClock(60);
        UnfixedClock clock = new UnfixedClock();
        EngineState eState = new EngineState(clock);
        RenderManager renderManager = new RenderManager(eState);

        Thread renderThread = new Thread(renderManager);
        renderThread.start();
        Thread clockThread = new Thread(clock);
        clockThread.start();
    }
}

package logic;

import logic.Manager.RenderManager;
import logic.clocking.GameClock;
import logic.state.EngineState;

public class Main {
    public static final int NANO_SECONDS_IN_SECOND = 1000000000;


    public static void main(String[] args) {
        GameClock clock = new GameClock();
        EngineState eState = new EngineState(clock);
        RenderManager renderManager = new RenderManager(clock, eState);

        Thread renderThread = new Thread(renderManager);
        renderThread.start();
        Thread clockThread = new Thread(clock);
        clockThread.start();
    }
}

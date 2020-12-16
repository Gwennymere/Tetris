package logic;

import logic.Manager.RenderManager;
import logic.clocking.GameClock;
import logic.state.EngineState;

public class Main {

    public static void main(String[] args) {
        GameClock clock = new GameClock();
        EngineState gState = new EngineState(clock);
        RenderManager renderManager = new RenderManager(clock);

        Thread renderThread = new Thread(renderManager);
        renderThread.start();
        Thread clockThread = new Thread(clock);
        clockThread.start();
    }
}

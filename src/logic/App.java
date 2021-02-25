package logic;

import game.GameManager;
import logic.Manager.RenderManager;
import logic.clocking.UpdaterClock;
import logic.state.RenderState;

import javax.swing.*;

public class App {
    public static final int NANO_SECONDS_IN_SECOND = 1000000000;
    public static final int MAX_FPS = 60;


    public static void main(String[] args) {
        UpdaterClock gameClock = new UpdaterClock(NANO_SECONDS_IN_SECOND);
        RenderState eState = new RenderState();
        RenderManager renderManager = new RenderManager(eState, MAX_FPS);

        Thread renderThread = new Thread(renderManager);
        renderThread.start();
        Thread clockThread = new Thread(gameClock);
        clockThread.start();

        JPanel test = new JPanel();
        test.add(new JButton("Start game"));
        renderManager.switchScene(test);

        GameManager gameManager = new GameManager(gameClock);
    }
}
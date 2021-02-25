package logic;

import communication.ButtonCommunicator;
import communication.CommunicatorManager;
import game.GameManager;
import logic.Manager.RenderManager;
import logic.clocking.UpdaterClock;
import logic.state.RenderState;
import ui.ButtonType;
import ui.UiManager;

import javax.swing.*;

public class App {
    public static final int NANO_SECONDS_IN_SECOND = 1000000000;
    public static final int MAX_FPS = 60;


    public static void main(String[] args) {
        CommunicatorManager communicatorManager = new CommunicatorManager();
        ButtonCommunicator buttonCommunicator = communicatorManager.getButtonCommunicator();

        UpdaterClock gameClock = new UpdaterClock(NANO_SECONDS_IN_SECOND);
        RenderState eState = new RenderState();
        RenderManager renderManager = new RenderManager(eState, MAX_FPS);

        Thread renderThread = new Thread(renderManager);
        renderThread.start();
        Thread clockThread = new Thread(gameClock);
        clockThread.start();

        renderManager.switchScene(UiManager.createMainMenu(buttonCommunicator));

        buttonCommunicator.getEntry(ButtonType.START).addActionListener(e -> {
            startGame(gameClock, buttonCommunicator);
        });
        buttonCommunicator.getEntry(ButtonType.QUIT).addActionListener(e -> {
            System.exit(0);
        });

//        GameManager gameManager = new GameManager(gameClock);
    }

    private static void startGame(UpdaterClock gameClock, ButtonCommunicator buttonCommunicator) {
        GameManager gameManager = new GameManager(gameClock, buttonCommunicator);
    }
}
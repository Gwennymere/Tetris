package logic;

import communication.ButtonCommunicator;
import communication.CommunicatorManager;
import game.GameManager;
import logic.Manager.RenderManager;
import logic.clocking.UpdaterClock;
import logic.state.RenderState;
import ui.ButtonType;
import ui.UiCreator;

public class App {
    public static final int NANO_SECONDS_IN_SECOND = 1000000000;
    public static final int MAX_FPS = 60;

    // Manager
    private static RenderManager renderManager;
    private static CommunicatorManager communicatorManager;
    private static GameManager gameManager;

    // Clocks
    private static UpdaterClock gameClock;

    // Threads
    private static Thread renderThread;
    private static Thread clockThread;

    public static void main(String[] args) {
        communicatorManager = new CommunicatorManager();
        ButtonCommunicator buttonCommunicator = communicatorManager.getButtonCommunicator();

        gameClock = new UpdaterClock(NANO_SECONDS_IN_SECOND);
        renderManager = new RenderManager(new RenderState(), MAX_FPS);

        renderThread = new Thread(renderManager);
        renderThread.start();
        clockThread = new Thread(gameClock);
        clockThread.start();

        renderManager.switchScene(UiCreator.createMainMenu(buttonCommunicator));

        buttonCommunicator.getEntry(ButtonType.START).addActionListener(e -> {
            startGame();
        });
        buttonCommunicator.getEntry(ButtonType.QUIT).addActionListener(e -> {
            System.exit(0);
        });
    }

    private static void startGame() {
        ButtonCommunicator buttonCommunicator = communicatorManager.getButtonCommunicator();
        renderManager.switchScene(UiCreator.createIngameView(buttonCommunicator));
        gameManager = new GameManager(gameClock, buttonCommunicator);
    }
}
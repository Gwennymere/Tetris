package game;

import communication.ButtonCommunicator;
import game.pieces.PieceInfo;
import logic.clocking.Clock;
import ui.ButtonType;

public class GameManager extends Clock {
    private static final int BOARD_WIDTH = 10;
    private static final int BOARD_HEIGHT = 20;

    private PieceInfo[][] grid = new PieceInfo[BOARD_WIDTH][BOARD_HEIGHT];

    public GameManager(ButtonCommunicator buttonCommunicator, int nanoSecondsInSecond) {
        super(nanoSecondsInSecond);

        buttonCommunicator.getEntry(ButtonType.PAUSE).addActionListener(e -> {
            super.togglePause();
        });
    }

    private void movePiece() {
        System.out.println("movemove");
    }

    @Override
    protected void clockTick(long lastUpdateTime) {
        movePiece();
    }
}

package game;

import communication.ButtonCommunicator;
import game.pieces.PieceInfo;
import logic.update.updatables.Updatable;
import logic.update.updater.Updater;

public class GameManager implements Updatable<Long> {
    private static final int BOARD_WIDTH = 10;
    private static final int BOARD_HEIGHT = 20;

    private PieceInfo[][] grid = new PieceInfo[BOARD_WIDTH][BOARD_HEIGHT];

    public GameManager(Updater updater, ButtonCommunicator buttonCommunicator) {
        updater.register(this);
    }

    @Override
    public void update(Long updateInfo) {
        movePiece();
    }

    private void movePiece() {
        System.out.println("movemove");
    }
}

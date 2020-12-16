package logic.state;

import logic.clocking.GameClock;

public class GuiState {
    private boolean showDebug;

    public GuiState(GameClock clock) {
//        showDebug = false;
//        clock.register(this);
    }

    public boolean toggleDebug() {
        this.showDebug = !showDebug;
        return showDebug;
    }
}

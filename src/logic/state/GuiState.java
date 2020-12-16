package logic.state;

import logic.clocking.GameClock;

public class GuiState {
    private boolean showDebug;

    public GuiState(GameClock clock) {
        showDebug = false;
        clock.registerClockInfo(this);
    }

    public boolean toggleDebug() {
        this.showDebug = !showDebug;
        return showDebug;
    }
}

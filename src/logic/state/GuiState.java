package logic.state;

public class GuiState {
    private boolean showDebug;

    public GuiState() {
        showDebug = false;
    }

    public boolean toggleDebug() {
        this.showDebug = !showDebug;
        return showDebug;
    }
}

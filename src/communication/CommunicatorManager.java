package communication;

public class CommunicatorManager {
    private final ButtonCommunicator buttonCommunicator;

    public CommunicatorManager() {
        buttonCommunicator = new ButtonCommunicator();
    }

    public ButtonCommunicator getButtonCommunicator() {
        return buttonCommunicator;
    }
}

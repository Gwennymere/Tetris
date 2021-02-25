package ui;

import communication.ButtonCommunicator;

import javax.swing.*;

public class UiManager {
    public static JPanel createMainMenu(ButtonCommunicator buttonCommunicator) {
        JPanel mainMenu = new JPanel();

        JButton start_game = new JButton("Start game");
        JButton quit_game = new JButton("Quit game");

        buttonCommunicator.setData(ButtonType.START, start_game);
        buttonCommunicator.setData(ButtonType.QUIT, quit_game);

        mainMenu.add(start_game);
        mainMenu.add(quit_game);

        return mainMenu;
    }
}

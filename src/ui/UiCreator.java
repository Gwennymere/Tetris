package ui;

import communication.ButtonCommunicator;

import javax.swing.*;

public class UiCreator {
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

    public static JPanel createIngameView(ButtonCommunicator buttonCommunicator) {
        JPanel view = new JPanel();

        JButton pause_game = new JButton("Pause");
        JButton quit_game = new JButton("Back to Menu");

        buttonCommunicator.setData(ButtonType.PAUSE, pause_game);
        buttonCommunicator.setData(ButtonType.QUIT, quit_game);

        view.add(pause_game);
        view.add(quit_game);

        return view;
    }
}

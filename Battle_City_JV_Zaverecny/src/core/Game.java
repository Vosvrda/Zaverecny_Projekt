package core;

import javax.swing.*;

public class Game {
    private GamePanel panel;
    private GameWindow window;

    public Game() {
        this.panel = new GamePanel();
        this.window = new GameWindow(panel);
        this.panel.requestFocus();
        this.panel.startGameThread();


    }
}

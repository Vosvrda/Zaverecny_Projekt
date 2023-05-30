package core;

import javax.swing.*;

public class GameWindow {
    private JFrame window;

    public GameWindow(GamePanel panel) {
        this.window = new JFrame();
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setResizable(false);
        this.window.setTitle("Battle City");
        this.window.setLocationRelativeTo(null);
        this.window.add(panel);
        this.window.pack();
        this.window.setVisible(true);
    }
}

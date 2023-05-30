package core;

import Entity.Player;
import Tile.TileManager;
import input.KeyListener;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    public final int TileSize = 48;
    public final int Col = 16;
    public final int Row = 16;
    public final int Width = TileSize * Col;
    public final int Height = TileSize * Row;
    Thread gameThread;
    KeyListener keyListener = new KeyListener();
    Player player = new Player(this,keyListener);
    TileManager tileManager = new TileManager(this);
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public int FPS = 120;

    public GamePanel() {
        this.setPreferredSize(new Dimension(Width,Height));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyListener);
        this.setFocusable(true);

    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }


    public void run(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null){
            currTime = System.nanoTime();
            delta += (currTime - lastTime) / drawInterval;
            timer += (currTime - lastTime);
            lastTime = currTime;
            if (delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;

            }
            if (timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update(){
        player.update();

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tileManager.draw(g2);
        player.draw(g2);

        g2.dispose();

    }
}

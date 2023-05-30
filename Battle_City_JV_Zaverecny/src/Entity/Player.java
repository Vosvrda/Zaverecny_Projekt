package Entity;

import core.GamePanel;
import input.KeyListener;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GamePanel panel;
    KeyListener keyListener;


    public Player(GamePanel panel, KeyListener keyListener) {
        this.panel = panel;
        this.keyListener = keyListener;
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        worldX = 500;
        worldY = 700;
        speed = 2;
        direction = "down";
    }
    public void getPlayerImage(){
        try{
            up = ImageIO.read(getClass().getResourceAsStream("/image/playerTank_up.png"));
            down = ImageIO.read(getClass().getResourceAsStream("/image/playerTank_down.png"));
            left = ImageIO.read(getClass().getResourceAsStream("/image/playerTank_left.png"));
            right = ImageIO.read(getClass().getResourceAsStream("/image/playerTank_right.png"));
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public void update() {
        if (keyListener.upPressed == true) {
            direction = "up";
            worldY -= speed;
        }
        if (keyListener.downPressed == true) {
            direction = "down";
            worldY += speed;
        }
        if (keyListener.leftPressed == true) {
            direction = "left";
            worldX -= speed;
        }
        if (keyListener.rightPressed == true) {
            direction = "right";
            worldX += speed;
        }
        collisionOn = false;
        panel.collisionChecker.checkTile(this);

        }



    public void draw(Graphics2D g2) {
        BufferedImage image1 = null;
        switch (direction){
            case "up" :
                image1 = up;
                break;
            case "down" :
                image1 = down;
                break;
            case "left" :
                image1 = left;
                break;
            case "right" :
                image1 = right;
                break;
        }
        g2.drawImage(image1,worldX,worldY,panel.TileSize, panel.TileSize,null);
    }
}

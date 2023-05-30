package Tile;


import core.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static javax.imageio.ImageIO.read;

public class TileManager {
    GamePanel panel;
    Tile[] tile;
public int mapTileNum [] [];
    public TileManager(GamePanel panel) {
        this.panel = panel;
        tile = new Tile[5];
        mapTileNum = new int [panel.Col] [panel.Row];
        getTileImage();
        loadMap("/maps/map.txt");
    }
    public void loadMap(String filePath){
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            while (col < panel.Col && row < panel.Row){
                String line = br.readLine();
                while (col < panel.Col){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }if (col == panel.Col){
                    col = 0;
                    row ++;
                }
            }
            br.close();
        }catch (Exception e){

        }
    }
    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].tiles = ImageIO.read(getClass().getResourceAsStream("/image/trees.png"));

            tile[1] = new Tile();
            tile[1].tiles = ImageIO.read(getClass().getResourceAsStream("/image/wall_brick.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].tiles = ImageIO.read(getClass().getResourceAsStream("/image/wall_steel.png"));
            tile[2].collision = true;
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while (col < panel.Col && row < panel.Row){
            int tileNum = mapTileNum[col][row];
        g2.drawImage(tile[tileNum].tiles,x,y,panel.TileSize, panel.TileSize, null);
        col++;
            x = 0;
        row++;
        y += panel.TileSize;
        }
    }
}

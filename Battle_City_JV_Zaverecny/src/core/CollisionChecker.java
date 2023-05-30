package core;

import Entity.Entity;

public class CollisionChecker {
        GamePanel panel;
        public CollisionChecker(GamePanel panel){
            this.panel = panel;
        }
        public void checkTile(Entity entity){

                int entLeftWorldX = entity.worldX + entity.solidArea.x;
                int entRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
                int entTopWorldY = entity.worldY + entity.solidArea.y;
                int entBottWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

                int entLeftCol = entLeftWorldX/ panel.TileSize;
                int entRightCol = entRightWorldX/ panel.TileSize;
                int entTopRow = entTopWorldY/ panel.TileSize;
                int entBottRow = entBottWorldY/ panel.TileSize;

                int tileNum1, tileNum2;
                switch (entity.direction){
                        case "up":
                                entTopRow = (entTopWorldY - entity.speed)/ panel.TileSize;
                                tileNum1 = panel.tileManager.mapTileNum[entLeftCol][entTopRow];
                                break;
                        case "down":
                                entBottRow = (entBottWorldY - entity.speed)/ panel.TileSize;
                                break;
                        case "left":
                                entTopRow = (entTopWorldY - entity.speed)/ panel.TileSize;
                                break;
                        case "right":
                                entTopRow = (entTopWorldY - entity.speed)/ panel.TileSize;
                                break;
                }
        }
}

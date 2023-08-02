package src.tile;

import src.GamePanel;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNumber[][];
    public String currentMap;

    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[10];
        mapTileNumber = new int[gp.maxWorldCol][gp.maxWorldRow]; // [23][59]

        getTileImage();
        currentMap = "kidsRoom";
        loadMapKidsRoom();
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/src/pictures/Tiles/BlueTile.png"));// blue =
                                                                                                             // backtround
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/src/pictures/Tiles/RedTile.png"));// red= wall
            tile[1].collision = true;// red wall has collision

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/src/pictures/map.png"));// downStairs

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/src/pictures/Tiles/RedTile.png"));
            tile[2].closet = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/src/pictures/Tiles/RedTile.png"));// teleport
            tile[4].teleport = true; // tiles

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/src/pictures/upstairs_map.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/src/pictures/kidRoom.png"));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/src/pictures/PARENTROOM.png"));

        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public void loadMapDownStairs() {
        currentMap = "downStairs";
        mapTileNumber = new int[gp.maxWorldCol][gp.maxWorldRow];
        // fill in entire top layer with wall tiles

        mapTileNumber[42][13] = 1;
        // Kitchen Walls
        for (int i = 0; i < gp.maxWorldCol; i++) {// Kitchen wall H
            mapTileNumber[i][5] = 1;

        }
        for (int i = 0; i < gp.maxWorldCol; i++) {// Kitchen wall H
            mapTileNumber[i][24] = 1;
        }
        for (int i = 0; i < 4; i++) {// Kitchen wall H
            mapTileNumber[i][18] = 1;
        }
        for (int i = 0; i < 9; i++) {
            mapTileNumber[i][10] = 1;
        }
        for (int i = 4; i < 9; i++) {
            mapTileNumber[1][i] = 1;
        }

        // V main Walls
        for (int i = 0; i < gp.maxWorldRow; i++) {// left wall V
            mapTileNumber[0][i] = 1;
        }
        for (int i = 0; i < gp.maxWorldRow; i++) {// middle wall 1 V
            mapTileNumber[15][i] = 1;
        }

        // Dining walls
        for (int i = 15; i < 18; i++) {// doorway open
            mapTileNumber[15][i] = 0;
        }
        for (int i = 16; i < gp.maxWorldCol; i++) {// doorway Book RightS H
            mapTileNumber[i][18] = 1;
        }
        for (int i = 18; i < gp.maxWorldRow; i++) {// doorway LeftS V
            mapTileNumber[14][i] = 1;
        }
        for (int i = 18; i < gp.maxWorldRow; i++) {// doorway LeftS V
            mapTileNumber[3][i] = 1;
        }
        for (int i = 3; i < 9; i++) {// dining counter
            mapTileNumber[i][14] = 1;
            mapTileNumber[i][13] = 1;
        }
        for (int i = 6; i < 12; i++) {// dining counter

            mapTileNumber[i][20] = 1;
            mapTileNumber[i][21] = 1;
            mapTileNumber[i][22] = 1;
        }

        // fireplace
        for (int i = 16; i < 29; i++) {// fireplace wall H
            mapTileNumber[i][11] = 1;
        }
        mapTileNumber[27][12] = 1;// table
        for (int i = 12; i < 15; i++) { // fireplace Wall V hallway Door
            mapTileNumber[28][i] = 1;

        }

        // East Hallway
        for (int i = 28; i < 43; i++) {// Hallway top wall H
            mapTileNumber[i][14] = 1;
        }

        // Stairs Room
        for (int i = 7; i < 13; i++) {
            mapTileNumber[42][i] = 1;
        }
        for (int i = 42; i < 60; i++) {
            mapTileNumber[i][10] = 1;
        }

        // washroom
        for (int i = 0; i < 25; i++) { // washroom eastWall V
            mapTileNumber[60][i] = 1;
        }
        for (int i = 53; i < 60; i++) {// sin+toilet H
            mapTileNumber[i][11] = 1;
        }
        for (int i = 0; i < 16; i++) { // washroom eastWall V
            mapTileNumber[53][i] = 1;
        }
        mapTileNumber[59][17] = 1;// flowerPot vvvvv
        mapTileNumber[59][16] = 1;
        mapTileNumber[48][10] = 0;
        mapTileNumber[47][10] = 0;

        mapTileNumber[50][11]=1;
        mapTileNumber[51][11]=1;
        mapTileNumber[52][11]=1;


        mapTileNumber[1][9]=1;

        // upstairs tiles for teleport
        mapTileNumber[48][9] = 4;
        mapTileNumber[47][9] = 4;

        //closet tiles

        //closet left
        mapTileNumber[31][15] = 2;
        mapTileNumber[32][15] = 2;
        //closet right
        mapTileNumber[51][12] = 2;
        mapTileNumber[52][12] = 2;
    }

    public void loadMapUpStairs() {
        currentMap = "upStairs";
        mapTileNumber = new int[gp.maxWorldCol][gp.maxWorldRow];
        for (int i = 0; i < 25; i++) {// hallway up
            mapTileNumber[i][7] = 1;
        }
        for (int i = 2; i < 8; i++) {
            mapTileNumber[24][i] = 1;
        }
        for (int i = 24; i < 35; i++) {// closet wall
            mapTileNumber[i][4] = 1;
        }
        for (int i = 24; i < 29; i++) {// closet wall
            mapTileNumber[i][5] = 1;
        }

        for (int i = 3; i < 12; i++) {
            mapTileNumber[35][i] = 1;
        }
        for (int i = 0; i < 36; i++) {
            mapTileNumber[i][12] = 1;
        }
        for (int i = 0; i < 15; i++) {
            mapTileNumber[0][i] = 1;
        }
        mapTileNumber[9][7] = 1;

        // teleport tiles
        mapTileNumber[34][10] = 4;
        mapTileNumber[33][10] = 4;

        // teleport tiles Kids Bedroom
        mapTileNumber[12][7] = 4;
        mapTileNumber[13][7] = 4;

        // Left upstair door
        mapTileNumber[5][7] = 4;
        mapTileNumber[6][7] = 4;

        mapTileNumber[26][6]=2;
        mapTileNumber[25][6]=2;
        mapTileNumber[27][6]=2;

    }

    public void loadMapKidsRoom() {
        currentMap = "kidsRoom";
        mapTileNumber = new int[gp.maxWorldCol][gp.maxWorldRow];

        for (int i = 0; i < 10; i++) {
            mapTileNumber[i][5] = 1;
        }
        mapTileNumber[3][6] = 1;
        mapTileNumber[2][5] = 1;

        for (int i = 0; i < 10; i++) {
            mapTileNumber[0][i] = 1;
        }

        for (int i = 6; i < 10; i++) {
            mapTileNumber[2][i] = 1;
        }

        for (int i = 10; i < 18; i++) {
            mapTileNumber[3][i] = 1;
            mapTileNumber[7][i] = 1;
        }

        for (int i = 4; i < 8; i++) {
            mapTileNumber[8][i] = 1;
        }
        mapTileNumber[9][8] = 1;
        mapTileNumber[10][9] = 1;
        mapTileNumber[8][10] = 1;
        mapTileNumber[9][10] = 1;

        // teleport tile kids
        mapTileNumber[4][16] = 4;
        mapTileNumber[5][16] = 4;
        mapTileNumber[6][16] = 4;
    }

    public void loadMapParentsRoom() {
        currentMap = "parentsRoom";
        mapTileNumber = new int[gp.maxWorldCol][gp.maxWorldRow];

        for(int i = 0; i<13;i++){
            mapTileNumber[i][5]=1;
        }
        mapTileNumber[2][6] =1;
        mapTileNumber[1][6] =1;
        mapTileNumber[0][7] =1;
        mapTileNumber[0][8] =1;

        for(int i =0; i<5;i++){
            mapTileNumber[i][9]=1;
        }
        for(int i =8; i<12;i++){
            mapTileNumber[i][9]=1;
        }
        for(int i=5;i<8;i++){
            mapTileNumber[i][6]=1;
            mapTileNumber[i][7]=1;
        }
        for(int i=4;i<13;i++){
            mapTileNumber[12][i]=1;
        }
        mapTileNumber[4][10]=1;
        mapTileNumber[8][10]=1;
        //teleport Tiles Parents Out
        mapTileNumber[6][11]=4;
        mapTileNumber[7][11]=4;
        mapTileNumber[5][11]=4;

        mapTileNumber[9][6]=2;
        mapTileNumber[10][6]=2;

    }

    public void loadMap(String filePath) {// useless
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();

                while (col < gp.maxWorldCol) {
                    String numbers[] = line.split(" ");

                    int value = Integer.parseInt(numbers[col]);

                    mapTileNumber[col][row] = value;
                    System.out.println("HI");
                    row++;
                }

                if (row == gp.maxWorldRow) {
                    row = 0;
                    col++;
                }
            }

            br.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void draw(Graphics2D g2) {
        // Automation for ground below
        int worldCol = 0;
        int worldRow = 0;

        if (currentMap.equals("downStairs")) {
            // while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            //     int tileNum = mapTileNumber[worldCol][worldRow]; // [23][59]

            //     int worldX = worldCol * gp.tileSize;
            //     int worldY = worldRow * gp.tileSize;

            //     int screenX = worldX - gp.player.worldX + gp.player.screenX;
            //     int screenY = worldY - gp.player.worldY + gp.player.screenY;

            //     // if (worldX > gp.player.worldX - gp.tileSize * 3 &&
            //     //         worldX < gp.player.worldX + gp.tileSize * 3 &&
            //     //         worldY > gp.player.worldY - gp.tileSize * 3 &&
            //     //         worldY < gp.player.worldY + gp.tileSize * 3) {
            //        g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            //     // }

            //     worldRow++;

            //     if (worldRow == gp.maxWorldRow) {
            //         worldRow = 0;
            //         worldCol++;
            //     }
            // }
            // if (gp.player.worldY <= 615 - gp.tileSize) {
            //     g2.drawImage(tile[0].image, 289 * gp.scale + gp.tileSize - gp.player.worldX + gp.player.screenX,
            //             189 * gp.scale + gp.tileSize - gp.player.worldY + gp.player.screenY,
            //             gp.scale * 97,
            //             gp.scale * 32,
            //             null);
            // }
            g2.drawImage(tile[3].image, gp.tileSize - gp.player.worldX +gp.player.screenX, gp.tileSize - gp.player.worldY + gp.player.screenY,59 *gp.tileSize,23 * gp.tileSize, null);
        }

        else if (currentMap.equals("upStairs")) {
            // while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            //     int tileNum = mapTileNumber[worldCol][worldRow]; // [23][59]

            //     int worldX = worldCol * gp.tileSize;
            //     int worldY = worldRow * gp.tileSize;

            //     int screenX = worldX - gp.player.worldX + gp.player.screenX;
            //     int screenY = worldY - gp.player.worldY + gp.player.screenY;

            //     // if (worldX > gp.player.worldX - gp.tileSize * 3 &&
            //     //         worldX < gp.player.worldX + gp.tileSize * 3 &&
            //     //         worldY > gp.player.worldY - gp.tileSize * 3 &&
            //     //         worldY < gp.player.worldY + gp.tileSize * 3) {
            //          g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            //     // }

            //     worldRow++;

            //     if (worldRow == gp.maxWorldRow) {
            //         worldRow = 0;
            //         worldCol++;
            //     }
            // }
            g2.drawImage(tile[5].image, gp.tileSize - gp.player.worldX + gp.player.screenX,gp.tileSize - gp.player.worldY + gp.player.screenY, 59 * gp.tileSize, 23 * gp.tileSize, null);
        }

        else if (currentMap.equals("kidsRoom")) {
            // while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            //     int tileNum = mapTileNumber[worldCol][worldRow]; // [23][59]

            //     int worldX = worldCol * gp.tileSize;
            //     int worldY = worldRow * gp.tileSize;

            //     int screenX = worldX - gp.player.worldX + gp.player.screenX;
            //     int screenY = worldY - gp.player.worldY + gp.player.screenY;

            //     // if (worldX > gp.player.worldX - gp.tileSize * 3 &&
            //     //         worldX < gp.player.worldX + gp.tileSize * 3 &&
            //     //         worldY > gp.player.worldY - gp.tileSize * 3 &&
            //     //         worldY < gp.player.worldY + gp.tileSize * 3) {
            //         g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            //     // }

            //     worldRow++;

            //     if (worldRow == gp.maxWorldRow) {
            //         worldRow = 0;
            //         worldCol++;
            //     }
            // }
            g2.drawImage(tile[6].image, gp.tileSize - gp.player.worldX + gp.player.screenX,gp.tileSize - gp.player.worldY + gp.player.screenY, 59 * gp.tileSize, 23 * gp.tileSize, null);
        }

        else if (currentMap.equals("parentsRoom")) {
            // while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            //     int tileNum = mapTileNumber[worldCol][worldRow]; // [23][59]

            //     int worldX = worldCol * gp.tileSize;
            //     int worldY = worldRow * gp.tileSize;

            //     int screenX = worldX - gp.player.worldX + gp.player.screenX;
            //     int screenY = worldY - gp.player.worldY + gp.player.screenY;

            //     // if (worldX > gp.player.worldX - gp.tileSize * 3 &&
            //     //         worldX < gp.player.worldX + gp.tileSize * 3 &&
            //     //         worldY > gp.player.worldY - gp.tileSize * 3 &&
            //     //         worldY < gp.player.worldY + gp.tileSize * 3) {
            //          g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            //     // }

            //     worldRow++;

            //     if (worldRow == gp.maxWorldRow) {
            //         worldRow = 0;
            //         worldCol++;
            //     }
            // }
            g2.drawImage(tile[7].image, gp.tileSize - gp.player.worldX + gp.player.screenX,gp.tileSize - gp.player.worldY + gp.player.screenY, 59 * gp.tileSize, 23 * gp.tileSize, null);
        }
    }

}

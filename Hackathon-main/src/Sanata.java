package src;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Random;

public class Sanata extends Characters {

   // Create an AI Santa that has two modes, one that roams around aimlessly and
   // one that pathfinds towards the player increasing in difficulty


    int sanata_x = 0;
    int sanata_y = 0;
    int sanataNumber = 1;
    int santaCounter = 0;
    int buffertime = 0;
   public Sanata(GamePanel gp) {
       super(gp);
       setDirection = "down";
       speed = 1;
       defaultSanata();
       getSanataImage();
   }

   public void defaultSanata() {
       // Set his default position at the beginning of the game
       sanata_x = 0;
       sanata_y = 0;
       speed = 1;
       setDirection = "right";
       solidArea = new Rectangle(sanata_x, sanata_y, gp.tileSize, gp.tileSize );
   }

   public void getSanataImage() {
       // Load the player images
       try {
           // Load images
           up1 = ImageIO.read(getClass().getResourceAsStream("/src/pictures/sanataSprites/santa_sprite1.png"));
           up2 = ImageIO.read(getClass().getResourceAsStream("/src/pictures/sanataSprites/santa_sprite2.png"));
           up3 = ImageIO.read(getClass().getResourceAsStream("/src/pictures/sanataSprites/santa_sprite3.png"));
           up4 = ImageIO.read(getClass().getResourceAsStream("/src/pictures/sanataSprites/santa_sprite4.png"));

           down1 = ImageIO.read(getClass().getResourceAsStream("/src/pictures/sanataSprites/santa_sprite1.png"));
           down2 = ImageIO.read(getClass().getResourceAsStream("/src/pictures/sanataSprites/santa_sprite1.png"));
           down3 = ImageIO.read(getClass().getResourceAsStream("/src/pictures/sanataSprites/santa_sprite1.png"));
           down4 = ImageIO.read(getClass().getResourceAsStream("/src/pictures/sanataSprites/santa_sprite1.png"));

           left1 = ImageIO.read(getClass().getResourceAsStream("/src/pictures/sanataSprites/santa_sprite1.png"));
           left2 = ImageIO.read(getClass().getResourceAsStream("/src/pictures/sanataSprites/santa_sprite1.png"));
           left3 = ImageIO.read(getClass().getResourceAsStream("/src/pictures/sanataSprites/santa_sprite1.png"));
           left4 = ImageIO.read(getClass().getResourceAsStream("/src/pictures/sanataSprites/santa_sprite1.png"));

           right1 = ImageIO.read(getClass().getResourceAsStream("/src/pictures/sanataSprites/santa_sprite1.png"));
           right2 = ImageIO.read(getClass().getResourceAsStream("/src/pictures/sanataSprites/santa_sprite1.png"));
           right3 = ImageIO.read(getClass().getResourceAsStream("/src/pictures/sanataSprites/santa_sprite1.png"));
           right4 = ImageIO.read(getClass().getResourceAsStream("/src/pictures/sanataSprites/santa_sprite1.png"));

       } catch (IOException e) {
           // TODO Auto-generated catch block
           // CATCH ERRORS
           e.printStackTrace();
       }
   }

   public static int getRandomNumber(int min, int max) {
       Random random = new Random();
       return random.nextInt(max - min) + min;
   }

   // This is where we draw the character
   public void draw(Graphics2D g2) {

       BufferedImage image = null;

        // update the santa animation
        
        if (sanataNumber == 1){
                image = right1;
        }
        else if (sanataNumber ==2){
                image = right2;
        }
        else if (sanataNumber == 3){
                image = right3;
        }
        else if (sanataNumber == 4){
                image = right4;
        }
        

        g2.drawImage(image, sanata_x, sanata_y, gp.tileSize, gp.tileSize * 2, null);

   }

   String movement_mode = null;
   // replace anger bar with whatever the variable it is going to be
   int angerbar;
   int distance_run;

   public void update() {

       if (angerbar == 1) {
           movement_mode = "pathfinding";
       } else {
           movement_mode = "roaming";
       }


       if (movement_mode == "pathfinding") {
            if (buffertime == 0){
                buffertime = getRandomNumber(0,6);
                distance_run = getRandomNumber(0,6);

            }
            buffertime --;
       } else if (movement_mode == "roaming") {
           // if
           // buffertime = getRandomNumber(0,5);
           // distance_run = getRandomNumber(0,3);

       }

       // update santa animation
       if (sanataNumber == 1){
                sanataNumber = 2;
        }
        else if (sanataNumber ==2){
                sanataNumber = 3;
        }
        else if (sanataNumber == 3){
                sanataNumber = 4;
        }
        else if (sanataNumber == 4){
                sanataNumber = 1;
        }


       // Anger bar will trigger the difference between randomly roaming and
       // pathfinding towards you
       // For random roaming AI
       // Random number generator will decide how many tiles he moves in what direction
       // and the interval between movements
       // For pathfinding AI
       // Paths towards you but doesnt make a beeline for you so aggresively, he will
       // pause and move in different directions every so often
   }
}

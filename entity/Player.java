package com.rpg.entity;

import com.rpg.GamePanel;
import com.rpg.KeyHandler;
import com.rpg.UtilityTool;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

// import java.awt.Color;


public class Player extends Entity {
    
    GamePanel gp;
    KeyHandler keyH;
    
    // Display the character at the center of the map with screenX and Y 
    public final int screenX; 
    public final int screenY;
    public int hasKey = 0; // Indicate how many key the player has 
    int standCounter = 0;

    public Player(GamePanel gamePanel, KeyHandler keyH){

        this.gp = gamePanel;
        this.keyH = keyH;

        // Arithmetic position to center the player at the center of the map
        screenX = gp.screenWidth / 2 - (gp.tileSize/2);
        screenY = gp.screenHeight / 2 - (gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;
        

        
        setDefautValues();
        getPlayerImage();
    }
    
    public void setDefautValues(){
        
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";
        String classpath = System.getProperty("java.class.path");
        System.out.println(classpath);
    }
    
    public void getPlayerImage(){
      
        up1 = setup("boy_up_1");
        up2 = setup("boy_up_2");
        down1 = setup("boy_down_1");
        down2 = setup("boy_down_2");
        left1 = setup("boy_left_1");
        left2 = setup("boy_left_2");
        right1 = setup("boy_right_1");
        right2 = setup("boy_right_2");
    }

    public BufferedImage setup(String imageName){
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/player/" + imageName +  ".png"));
            image = uTool.scaleImage(image,gp.tileSize, gp.tileSize);

        }catch(IOException e){
            e.printStackTrace();
        }

        return image;
    }


    public void update(){
         // METHOD FOR THE CHARACTER MOVEMENT 
         // Get called 60 times per second

         if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true ){

            if(keyH.upPressed == true){
                direction = "up";
                // Move up the character
            }else if(keyH.downPressed == true){
                direction = "down";
                // Move down
            }else if(keyH.leftPressed == true){
                direction = "left";
                // Move left
            }else if(keyH.rightPressed == true){
                direction = "right";
                //Move right 
            }

            // Check the tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // Check Object collision 
            int objIndex = gp.cChecker.checkObject(this,true);
            pickUpObject(objIndex);

            // If collision is false then player can move 

            if(collisionOn == false){
                switch(direction){
                    case "up": worldY -= speed; break;
                    case "down": worldY += speed; break;
                    case "left": worldX -= speed; break;
                    case "right":worldX += speed; break;
                }
            }
            // Increase the counter once it hits 10 it changes the sprite importer with the imageIO every 10 frames 
            spriteCounter++;
            if(spriteCounter > 9){
                if(spriteNum == 1 ){
                    spriteNum = 2;
                }
                else if(spriteNum ==2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
         }else{
            standCounter++;

            if(standCounter == 20){
                spriteNum = 1;
                standCounter = 0;
            }
            spriteNum = 1;
         }
    }

    public void pickUpObject(int i){
        // Index is set as 999, to avoid being used by the object array index. We check if the object is touched
        if(i != 999){
        
            // The object disappear if we touch it so its set as null 
            //gp.obj[i] = null;

            String objectName = gp.obj[i].name;

            switch(objectName){
                case "key":
                gp.playSE(1);
                // We call playSE that contains the sound methods that contains the array where we set our sounds FX.
                    hasKey++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("You've obtained a key " );
                    break;

                case "door":
                    if(hasKey > 0){
                        gp.playSE(3);
                        gp.obj[i] = null;
                    hasKey--;
                    gp.ui.showMessage("You have opened a door");
                    }else{
                        gp.ui.showMessage("You need a key");
                    }
                    
                    break;

                case "boots":
                gp.playSE(2);
                // Same here but with a different index for a different sound FX
                // Once you get the boots objects, it disappear and the speed goes faster
                    speed += 3;
                    gp.obj[i] = null;
                    gp.ui.showMessage("Speed up ");
                    break;
                
                case "treasure":
                    gp.ui.gameFinished = true;
                    gp.stopMusic();
                    gp.playSE(4);
                    break;
            }
        }
    }

    public void draw(Graphics2D g2){

        // g2.setColor(Color.white);
        // g2.fillRect(x,y, gp.tileSize, gp.tileSize);

        // Drawing the images for the player direction through a switch case 
        BufferedImage image = null;

        switch(direction){
            case "up":
            if(spriteNum == 1 ){
                image = up1;
            }
            if(spriteNum == 2 ){
                image = up2;
            }
            break;
            case "down":
            if(spriteNum == 1){
                image = down1;
            }
            if(spriteNum == 2){
                image = down2;
            }
            break;
            case "left":
            if(spriteNum == 1){
                image = left1;
            }
            if(spriteNum == 2){
                image = left2;
            }
            break;
            case "right":
            if( spriteNum == 1){
                image = right1;
            }
            if(spriteNum == 2){
                image = right2;
            }
            break;
        }

        g2.drawImage(image, screenX, screenY, null);
    }
}

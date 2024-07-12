package com.rpg;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import com.rpg.object.ObjectKey;

public class UI {
    
    GamePanel gp;
    Font font_35, arial_80Bold;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;

    // Timer UI
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0"); // We display decimal 

    public UI(GamePanel gp){

        this.gp = gp;
        font_35 = new Font("Hebrew", Font.CENTER_BASELINE, 35);
        arial_80Bold = new Font("Arial", Font.BOLD, 45);
        ObjectKey key = new ObjectKey(gp);
        keyImage = key.image;
    }

    public void showMessage(String text){

        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){
        // Draw the key + the text  

        if(gameFinished == true ){
            
            g2.setFont(arial_80Bold);
            g2.setColor(Color.yellow);

            String text;
            int textLength;
            int x;
            int y;

            // Treasure found message
            text = " You found the treasure";
            textLength =(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLength/ 2;
            y = gp.screenHeight/2 - (gp.tileSize* 3);
            g2.drawString(text, x, y);

            // Timer message
            text = " Your time is :" + dFormat.format(playTime) + "!";
            textLength =(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLength/ 2;
            y = gp.screenHeight/2 - (gp.tileSize* 5);
            g2.drawString(text, x, y);



            // Game completed message
            g2.setFont(arial_80Bold);
            g2.setColor(Color.yellow);
            text = " Congratulations !";
            textLength =(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            // Text position
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 + (gp.tileSize * 2);
            g2.drawString(text, x, y);

            // Stop the game if we find the treasure
            gp.gameThread = null;
        }else{

            g2.setFont(font_35);
            g2.setColor(Color.black);
            g2.drawImage(keyImage, gp.tileSize/2,gp.tileSize/2 , gp.tileSize,gp.tileSize,null);
            g2.drawString("x"+ gp.player.hasKey,74,65);

            //TIME

            playTime +=(double)1/60;
            g2.drawString("Time: " + dFormat.format(playTime), gp.tileSize* 12, 45); // Position timer

    
            // MESSAGE
            if(messageOn == true){
    
                g2.setFont(g2.getFont().deriveFont(35F));
                g2.drawString(message, gp.tileSize/2, gp.tileSize*5);
    
                messageCounter++;
    
                if(messageCounter > 100){
                    messageCounter = 0; 
                    messageOn = false;
                }
            }
        }
    }
}

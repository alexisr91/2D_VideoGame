package com.rpg.object;

import java.io.IOException;
import javax.imageio.ImageIO;

import com.rpg.GamePanel;

public class ObjectTreasure extends SuperObject  {
    GamePanel gp;

    public ObjectTreasure(GamePanel gp){

        this.gp = gp;
        
        name = "treasure";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/treasure.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

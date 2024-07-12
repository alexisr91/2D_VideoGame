package com.rpg.object;

import java.io.IOException;
import javax.imageio.ImageIO;

import com.rpg.GamePanel;

public class ObjectBoots extends SuperObject  {
    GamePanel gp;

    public ObjectBoots(GamePanel gp){
        this.gp = gp;
       
        name = "boots";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/boots.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

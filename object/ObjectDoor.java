package com.rpg.object;

import java.io.IOException;
import javax.imageio.ImageIO;

import com.rpg.GamePanel;


public class ObjectDoor extends SuperObject {
    GamePanel gp;

    public ObjectDoor(GamePanel gp){

        this.gp = gp;
        
        name = "door";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
    }
}

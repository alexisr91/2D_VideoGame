package com.rpg;

import com.rpg.object.ObjectBoots;
import com.rpg.object.ObjectTreasure;
import com.rpg.object.ObjectDoor;
import com.rpg.object.ObjectKey;

public class AssetSetter{
    
    GamePanel gp;
    
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){

        // We set object's location in the map by using the tileSize col and row 
        // Each instanciation represent, one object created 
        gp.obj[0] = new ObjectKey(gp);
        gp.obj[0].worldX = 23 * gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;

        gp.obj[1] = new ObjectKey(gp);
        gp.obj[1].worldX = 23 * gp.tileSize;
        gp.obj[1].worldY = 40 * gp.tileSize;

        gp.obj[2] = new ObjectKey(gp);
        gp.obj[2].worldX = 38 * gp.tileSize;
        gp.obj[2].worldY = 8 * gp.tileSize;

        gp.obj[3] = new ObjectDoor(gp);
        gp.obj[3].worldX = 10 * gp.tileSize;
        gp.obj[3].worldY = 11 * gp.tileSize;

        gp.obj[4] = new ObjectDoor(gp);
        gp.obj[4].worldX = 8 * gp.tileSize;
        gp.obj[4].worldY = 28 * gp.tileSize;


        gp.obj[5] = new ObjectDoor(gp);
        gp.obj[5].worldX = 12 * gp.tileSize;
        gp.obj[5].worldY = 22 * gp.tileSize;

        gp.obj[6] = new ObjectTreasure(gp);
        gp.obj[6].worldX = 10 * gp.tileSize;
        gp.obj[6].worldY = 7 * gp.tileSize;

        gp.obj[7] = new ObjectBoots(gp);
        gp.obj[7].worldX = 37 * gp.tileSize;
        gp.obj[7].worldY = 42 * gp.tileSize;



    }
}

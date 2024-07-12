package com.rpg;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import com.rpg.entity.Player;
import com.rpg.object.SuperObject;
import com.rpg.tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
    
    // Screen settings

    final int originalTileSize = 16; // 16x16 TILE, size of any object on the game by px
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; // 48X48 tile 
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768px
    public final int screenHeight = tileSize * maxScreenRow; // 576px 

    // World settings

    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;

    //FPS
    int FPS = 60;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Sound sound = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public Player player = new Player(this,keyH);
    public SuperObject obj[] = new SuperObject[10]; // we display 10 objects at the same time 
    Thread gameThread; // Something you can start and stop. The thread run until you stop it 
    
    public GamePanel(){
        // Constructor
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        // Dimension will set the JPanel Size
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame(){
        
        aSetter.setObject();
        playMusic(0);
        setMusicVolume(-5); // Gain control of the main volume
    }

    public void startGameThread(){

        gameThread = new Thread(this); // We're passing GamePanel class to this thread's constructor. That's how you instantiate a thread 
        gameThread.start(); // You have to call the method start to run the thread
    }

    @Override
    public void run(){

        double drawInterval = 1000000000/FPS; // 0.0166
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null){

            //1. UPDATE informatoion such as character position
            update();
            //2. DRAW draw the screen with the updated info 
            repaint();

            
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                // how much time remainng until the next 
                remainingTime = remainingTime / 1000000;

                if(remainingTime < 0 ){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);
                // the Sleep method is a break in thread that stops the thread

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
        }
    }

  /*   @Override
    public void run(){

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null){

            currentTime = System.nanoTime();

            delta += ( currentTime - lastTime ) / drawInterval;
            timer += ( currentTime - lastTime );
            lastTime = currentTime;

            if( delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if( timer>= 1000000000){
                System.out.println("FPS : " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    } */

    public void update(){
       
        player.update();
        
    }
    
    
    
    public void paintComponent(Graphics g){
        // Graphics is a class that has man functions to draw objetcs on the screen
        super.paintComponent(g);
        // Super : the main class (JPanel)
        Graphics2D g2 = (Graphics2D)g;
        
        // Tile
        tileM.draw(g2);

        // Objects 
        for(int i =0; i< obj.length; i++){
            // We scan the obj array one by one
            if(obj[i] != null){
            // We check if the slot isn't empty to avoid NullPointer error
                obj[i].draw(g2,this);
            }
        }

       
        // Player
        player.draw(g2);

        // UI
        ui.draw(g2);
        
    

        g2.dispose();
        // Disposes of this graphics context and releases any system resources that it is using

    }

    public void playMusic(int i){

        sound.setFile(i);
        sound.play();
        sound.loop();
        
    }

    public void stopMusic(){
        sound.stop();
    }

    public void playSE(int i ){

        sound.setFile(i);
        sound.play();
    }

    public void setMusicVolume(float volume){
        sound.setVolume(volume);
    }

  

}   

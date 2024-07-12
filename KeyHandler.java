package com.rpg;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// This entire class is going to handle all the buttons you play with 
public class KeyHandler implements KeyListener {
    
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e){

    }

    @Override
    public void keyPressed(KeyEvent e){
        // Key pressing's affectation/assignation
        int code = e.getKeyCode();
        // Return an interger keyCode associated with they key in this event.

        upPressed = (code == KeyEvent.VK_Z) || (code == KeyEvent.VK_UP);
        // Since I can't use the || operator I have to compare the boolean and the integer with this type of syntax
        downPressed = (code == KeyEvent.VK_Z) || (code == KeyEvent.VK_DOWN);

        leftPressed = (code == KeyEvent.VK_Z) || (code == KeyEvent.VK_LEFT);

        rightPressed = (code == KeyEvent.VK_Z) || (code == KeyEvent.VK_RIGHT);

        
    }


    @Override
    public void keyReleased(KeyEvent e){
        
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_Z || code == KeyEvent.VK_UP){
            upPressed = false;
            System.out.println("upPressed");
        }

        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            downPressed = false;
            System.out.println("downPressed");
        }


        if(code == KeyEvent.VK_Q || code == KeyEvent.VK_LEFT){
            leftPressed = false;
            System.out.println("leftPressed");
        }

        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
            rightPressed = false;
            System.out.println("rightPressed");
            
        }
    }
    
}

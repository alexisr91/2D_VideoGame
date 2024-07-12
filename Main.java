package com.rpg;

import javax.swing.JFrame;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        JFrame window = new JFrame();
        GamePanel gamePanel = new GamePanel();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Slayersonline");
        window.addKeyListener(gamePanel.keyH);
        window.add(gamePanel);
        window.pack();
        //Causes this Window to be sized to fit the preferred size and layouts of its subcomponents
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamePanel.setupGame();
        gamePanel.startGameThread();
        
    }
}

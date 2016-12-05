

import greenfoot.*;
import javax.swing.JOptionPane; 
import javax.swing.JInternalFrame;

public class PlayNowButton extends Buttons
{   
   
    Proxy proxy=new Proxy();
    private GreenfootImage img = new GreenfootImage("play!.png");
    public static String name;
   
    
    
    public void act() 
    {
        setImage(img);
        if(Greenfoot.mouseClicked(this))
        {
            StartGameScreen.stopSound();
            String inputValue = JOptionPane.showInputDialog("Enter Name");
            name=inputValue;
            proxy.addPlayer(inputValue);
        
        }
    }    
    
    
    
}
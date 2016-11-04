

import greenfoot.*;


public class PlayNowButton extends Buttons
{   private GifImage gif = new GifImage("play_button.gif");
   
    public void act() 
    {
        setImage(gif.getCurrentImage());
        
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new StartGameScreen());
            StartGameScreen world = (StartGameScreen)getWorld();
          
        }
    }    
}
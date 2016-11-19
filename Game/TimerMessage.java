import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class TimerMessage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TimerMessage extends Message
{
    /**
     * Act - do whatever the TimerMessage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public TimerMessage()
    {
        
    }
    
    public TimerMessage(String labelText)  
    {
        GreenfootImage label = new GreenfootImage(labelText,25,Color.white,null);  
        setImage(label);          
    }
    
    public void setMessage(World world, String labelText, int xPos, int yPos) {
        Actor message = new TimerMessage(labelText);
        world.addObject(message, xPos, yPos);
    }    
}

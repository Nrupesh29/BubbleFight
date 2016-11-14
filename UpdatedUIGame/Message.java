import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Message here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Message extends Actor
{
    /**
     * Act - do whatever the Message wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Message()
    {
        
    }
    
    public Message(String labelText)  
    {
        GreenfootImage label = new GreenfootImage(labelText,25,Color.black,null);  
        setImage(label);          
    }
    
    public void setMessage(World world, String labelText, int xPos, int yPos) {
        Actor message = new Message(labelText);
        world.addObject(message, xPos, yPos);
    }    
}

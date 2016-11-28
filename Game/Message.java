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
    protected String message;
    public Message()
    {

    }

    public Message(String labelText)  
    {
        message = labelText;
        GreenfootImage label = new GreenfootImage(labelText,25,Color.black,null);  
        setImage(label);          
    }
    
    public void updateLocation(int x, int y){
        setLocation(x,y);
    }

    public void setMessage(World world, String labelText, int xPos, int yPos) {
        Actor message = new Message(labelText);
        world.addObject(message, xPos, yPos);
    }   
    
   
    public String getMessage(){
        return message;        
    }
    
    public void destroy(){
        if(getWorld() != null){
            getWorld().removeObject(this);
        }
   }
}

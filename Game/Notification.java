import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Notification here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Notification extends Message
{
    public Notification(String labelText, Color color)  
    {
        message = labelText;
        GreenfootImage label = new GreenfootImage(labelText,25,color,null);  
        setImage(label);     
    }

    public void act() 
    {
        int r = getImage().getTransparency();

        if (r>3) {
            r -= 3;
            getImage().setTransparency(r);
            setLocation(getX(),getY()-1);
        }else{
            getWorld().removeObject(this);
        }
    }    
}

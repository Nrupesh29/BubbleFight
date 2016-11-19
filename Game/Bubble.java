import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bubble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bubble extends Actor
{
    String number;
    
    /**
     * Act - do whatever the Bubble wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Bubble(String number)
    {
        this.number = number;
    }
    
    public void act() 
    {
        Message message = new Message();
        message.setMessage(getWorld(), number, getX(), getY());
    }
}

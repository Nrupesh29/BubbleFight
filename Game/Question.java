import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Timer;
import java.util.TimerTask;

/**
 * Write a description of class Question here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Question extends Actor
{
    /**
     * Act - do whatever the Question wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Message message = new Message();
        message.setMessage(getWorld(), "1001 + 1101 + 1010", 630, getY());
        
        TimerMessage m = new TimerMessage();
        m.setMessage(getWorld(), "02:00", 380, getY());
    }    
}
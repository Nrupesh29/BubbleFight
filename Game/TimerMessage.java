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

    private int second = 0;

    public TimerMessage(String labelText)  
    {
        super(labelText);
    }

    public TimerMessage(int s)  
    {            
        second = s;
        message = timeConversion(second);
        GreenfootImage label = new GreenfootImage(message,25,Color.black,null);  
        setImage(label); 
    }

    private static String timeConversion(int totalSeconds) {
        final int MINUTES_IN_AN_HOUR = 60;
        final int SECONDS_IN_A_MINUTE = 60;

        int seconds = totalSeconds % SECONDS_IN_A_MINUTE;
        int totalMinutes = totalSeconds / SECONDS_IN_A_MINUTE;
        int minutes = totalMinutes % MINUTES_IN_AN_HOUR;
        int hours = totalMinutes / MINUTES_IN_AN_HOUR;

        return (minutes > 9?minutes:"0"+minutes) + ":" + (seconds > 9?seconds:"0"+seconds);
    }

    public void setMessage(int s, int xPos, int yPos) {

        TimerMessage tm = new TimerMessage(s);
        if(getWorld() != null)
            getWorld().addObject(tm, xPos, yPos);
    }

}

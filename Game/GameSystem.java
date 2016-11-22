import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class GameSystem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameSystem extends Actor
{
    public int pause = 50;
    private int speed = 5;
    private int seaY = 800;
    private int seaMinX = 200;
    private int seaMaxX = 900;

    public GameSystem(){

    }

    public void act() 
    {
        //prepare coord

        if(pause>0)
            pause--;
        if(pause == 0)
        {
            // Add your action code here.

            Random r = new Random();
            int result = r.nextInt(seaMaxX-seaMinX) + seaMinX;

            Label label = new Label();
            Bubble b = new Bubble(label, speed);
            getWorld().addObject(b,result,seaY);
            getWorld().addObject(label,result,seaY);
            pause = 50;

        }
    }    
}

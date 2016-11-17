import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Balloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Balloon extends Actor
{
    private int speed;
    private Label label;
    public Balloon(Label l, int sp){
        label = l;       
        speed = sp;
    }

    public void act() 
    {
        // Add your action code here.
        setLocation(getX(), getY() - speed);
        label.updateLocation(getX(), getY() - speed);
        if (getY() <= 0)
        {           
            getWorld().removeObject(this);
            label.destroy();
        }

    }    

}

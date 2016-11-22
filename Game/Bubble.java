import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bubble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bubble extends Actor
{
    private int speed;
    private Label label;

    /**
     * Act - do whatever the Bubble wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Bubble(Label l, int sp){
        label = l;       
        speed = sp;
    }

    public void act() 
    {
        // Message message = new Message();
        //message.setMessage(getWorld(), number, getX(), getY());
        setLocation(getX(), getY() - speed);
        label.updateLocation(getX(), getY() - speed);
        if (getY() <= 0)
        {           
            getWorld().removeObject(this);
            label.destroy();
        }
    }
}

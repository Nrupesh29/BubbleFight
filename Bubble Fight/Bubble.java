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
    private Answer label;

    /**
     * Act - do whatever the Bubble wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Bubble(Answer l, int sp){
        label = l;       
        speed = sp;
    }

    public void act() 
    {
        setLocation(getX(), getY() - speed);
        label.updateLocation(getX(), getY() - speed);
        if (getY() <= 0)
        {           
            destroy();
        }
    }

    public Answer getAnswer(){
        return label;
    }

    public void destroy(){
        getWorld().removeObject(this);
        label.destroy();
    }

}

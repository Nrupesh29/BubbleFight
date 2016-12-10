import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExitButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExitButton extends Button
{
    private boolean hovering;
    /**
     * Act - do whatever the ExitButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (!hovering && Greenfoot.mouseMoved(this))
        {
            //set red text image
            hovering = true;
            setImage(new GreenfootImage("exitHoverButton.png"));
        }
        if (hovering && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            // set blue text image
            hovering = false;
            setImage(new GreenfootImage("exitButton.png"));
        }
        if (Greenfoot.mouseClicked(this)) {
            System.exit(0);
        }
    }    
}

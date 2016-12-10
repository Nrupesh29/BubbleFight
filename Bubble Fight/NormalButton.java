import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalButton extends Button
{
    private boolean hovering;
    private World world;

    public NormalButton(World w){
        world = w;
    }

    public void act() 
    {
        if (!hovering && Greenfoot.mouseMoved(this))
        {
            //set red text image
            hovering = true;
            setImage(new GreenfootImage("normalHoverButton.png"));

        }
        if (hovering && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            // set blue text image
            hovering = false;
            setImage(new GreenfootImage("normalButton.png"));

        }
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(world);

            PlayWorld pw = (PlayWorld) world;
            pw.startGame();

        }
    }    

    
}

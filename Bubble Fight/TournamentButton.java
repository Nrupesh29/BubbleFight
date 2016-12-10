import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TournamentButton extends Button
{
    private boolean hovering;
    private World world;
    private boolean flip;

    public TournamentButton(World w){
        world = w;
    }

    public void act() 
    {
        if (!hovering && Greenfoot.mouseMoved(this))
        {
            //set red text image
            hovering = true;
            setImage(new GreenfootImage("tournamentHoverButton.png"));

        }
        if (hovering && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            // set blue text image
            hovering = false;
            setImage(new GreenfootImage("tournamentButton.png"));

        }
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(world);

            SelectTournamentWorld pw = (SelectTournamentWorld) world;
            pw.addTournament();
            
        }
    }    

    public void flipImage(){
        GreenfootImage img = getImage();
        img.mirrorHorizontally();
        setImage(img);
    }
}

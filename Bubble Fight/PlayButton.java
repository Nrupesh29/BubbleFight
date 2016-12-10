import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayButton extends Button
{
    private boolean hovering;
    private World world;
    private boolean flip;

    public PlayButton(World w){
        world = w;
    }

    public PlayButton(World w, boolean f    ){
        world = w;
        flip = f;
        if(flip){
            flipImage();
        }
    }

    public void act() 
    {
        if (!hovering && Greenfoot.mouseMoved(this))
        {
            //set red text image
            hovering = true;
            setImage(new GreenfootImage("playHoverButton.png"));
            if(flip){
                flipImage();
            }
        }
        if (hovering && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            // set blue text image
            hovering = false;
            setImage(new GreenfootImage("playButton.png"));
            if(flip){
                flipImage();
            }
        }
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(world);

            if(!flip){
                if (world instanceof PlayWorld) {
                    PlayWorld pw = (PlayWorld) world;
                    pw.startGame();
                }

                if (world instanceof IntroWorld) {
                    IntroWorld pw = (IntroWorld) world;
                    pw.reset();
                }
                if (world instanceof SelectTournamentWorld) {
                    SelectTournamentWorld pw = (SelectTournamentWorld) world;
                    pw.addTournament();
                }

            }else{
                if (world instanceof IntroWorld) {
                    IntroWorld pw = (IntroWorld) world;
                    pw.reset();
                }
            }
        }
    }    

    public void flipImage(){
        GreenfootImage img = getImage();
        img.mirrorHorizontally();
        setImage(img);
    }
}

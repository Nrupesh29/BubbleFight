import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IntroWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroWorld extends World
{

    /**
     * Constructor for objects of class IntroWorld. 
     * 
     */
    private MyWorld world;
    public IntroWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1150, 600, 1);      

    }

    public void setWorld(MyWorld w){
        world = w;
        
        addObject( new PlayButton(world.modeW), 420, 400 ) ; 
        addObject( new HelpButton(), 580, 400 ) ;
        addObject( new ExitButton(), 740, 400 ) ;
    }
}

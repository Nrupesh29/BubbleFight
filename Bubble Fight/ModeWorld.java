import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class ModeWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ModeWorld extends World
{

    /**
     * Constructor for objects of class ModeWorld.
     * 
     */
    private MyWorld world;
    public ModeWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1150, 600, 1);
        // world = w;

    }

    public void setWorld(MyWorld w){
        world = w;
        //System.out.println(world.modeW);

        //Message normalText = new Message("Normal", Color.blue,50);
        //Message tournamentText = new Message("Tournament", Color.blue,50);

        PlayButton backB = new PlayButton(world.introW, true);


        //addObject( normalText, 350, 350 ) ;
        //addObject( tournamentText, 800, 350 ) ;

        addObject( new NormalButton(world.playW), 350, 430 ) ;
        addObject( new TournamentButton(world.selectTW), 800, 430 ) ;
        addObject( backB, 50, 50 ) ;
    }
}

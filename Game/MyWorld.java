import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public IntroWorld introW;
    public ModeWorld modeW;
    public PlayWorld playW;
    public SelectTournamentWorld selectTW;
    public GameOverWorld gameOverW;
    public final String API_URL = "http://sample-env.xtfzxnrydy.us-west-1.elasticbeanstalk.com/api/";
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1150, 600, 1);

        introW = new IntroWorld();
        modeW = new ModeWorld();
        playW = new PlayWorld();
        selectTW = new SelectTournamentWorld();
        gameOverW = new GameOverWorld();

        introW.setWorld(this);
        modeW.setWorld(this);
        playW.setWorld(this);
        selectTW.setWorld(this);
        gameOverW.setWorld(this);

        int[] array = {0,0};
        gameOverW.setResult(null,true,null); 

        Greenfoot.setWorld(selectTW);
       // Greenfoot.setWorld(gameOverW);
    }

}

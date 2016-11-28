import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayWorld extends World
{

    /**
     * Constructor for objects of class PlayWorld.
     * 
     */
    public PlayWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1150, 600, 1);
     
        QAManager qaManager = new QAManager();
        QuestionBar questionBar = new QuestionBar(qaManager);

        qaManager.attach(questionBar);

        GameSystem gamesystem = new GameSystem(qaManager);
        addObject(gamesystem,855,42);


        // birds        
        Player blueBird = new BlueBird(this,gamesystem, true, 2);
        Player redBird = new RedBird(this,gamesystem, true, 1);
        blueBird.setEnemy(redBird);
        redBird.setEnemy(blueBird); 

        addObject( questionBar, 580, 45 ) ;
        addObject( new Sea(), 570, 800 ) ;
        addObject( new LeftStone(), 50, 800 ) ;
        addObject( new RightStone(), 1100, 800 ) ;
        addObject( blueBird, 50, 500 ) ;
        addObject( redBird, 1100, 500 ) ;

        gamesystem.startGame();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

    }
}

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
        // GreenfootImage background = new GreenfootImage("playBackground.png");
        // setBackground(background);
        // AnswerManager answerManager = new AnswerManager();
        // addObject(answerManager, 0, 0);

        Message life1 = new Message();
        life1.setMessage(this, "x2", 50, 50);
        Message life2 = new Message();
        life2.setMessage(this, "x2", 1130, 50);

        // birds        
        Player blueBird = new BlueBird( true, 2);
        Player redBird = new RedBird( true, 1);
        blueBird.setEnemy(redBird);
        redBird.setEnemy(blueBird); 

        addObject( new Question(), 580, 45 ) ;
        addObject( new Sea(), 570, 800 ) ;
        addObject( new LeftStone(), 50, 800 ) ;
        addObject( new RightStone(), 1100, 800 ) ;
        addObject( blueBird, 50, 500 ) ;
        addObject( redBird, 1100, 500 ) ;
        addObject( new Life(), 18, 50 ) ;
        addObject( new Life(), 1100, 50 ) ;
        addObject( new Energy100(), 1105, 20 ) ;
        addObject( new Energy100(), 45, 20 ) ;

        GameSystem gamesystem = new GameSystem();
        addObject(gamesystem,855,42);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

    }
}

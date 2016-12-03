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
    private MyWorld world;
    private Tournament tournament = null;
    private GameSystem gameSystem;
    private Message player1;
    private Message player2;
    public PlayWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1150, 600, 1);

    }

    public void setTournament(Tournament t){
        tournament = t;
    }

    public void setWorld(MyWorld w){
        world = w;

        QAManager qaManager = new QAManager();
        QuestionBar questionBar = new QuestionBar(qaManager);

        qaManager.attach(questionBar);

        gameSystem = new GameSystem(qaManager);
        addObject(gameSystem,855,42);

        // birds        
        Player blueBird = new BlueBird(this,gameSystem, true, 2);
        Player redBird = new RedBird(this,gameSystem, true, 1);
        blueBird.setEnemy(redBird);
        redBird.setEnemy(blueBird); 

        addObject( questionBar, 580, 45 ) ;
        addObject( new Sea(), 570, 800 ) ;
        addObject( new LeftStone(), 50, 800 ) ;
        addObject( new RightStone(), 1100, 800 ) ;
        addObject( blueBird, 50, 500 ) ;
        addObject( redBird, 1100, 500 ) ;
        //
        player1 = new Message("Player 1");
        player2 = new Message("Player 2");
        addObject( player1, 50, 80) ;
        addObject( player2, 1100, 80 ) ;
        gameSystem.startGame();
    }

    public void startGame(){
        gameSystem.startGame();
        System.out.println(world.selectTW.tournament.getCurrent().player1.toString());

    }

}

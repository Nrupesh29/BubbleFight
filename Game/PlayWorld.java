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
    private Player blueBird;
    private Player redBird;
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

        gameSystem = new GameSystem(qaManager,this);
        addObject(gameSystem,855,42);      

        addObject( questionBar, 580, 45 ) ;
        addObject( new Sea(), 570, 800 ) ;
        addObject( new LeftStone(), 50, 570 ) ;
        addObject( new RightStone(), 1100, 570 ) ;

        //
        //for test
        gameSystem.startGame();
    }

    public void startGame(){
        gameSystem.startGame();
        for(Bubble b : getObjects(Bubble.class)){
            b.destroy();
        };

        // birds    
        removeObject(blueBird);
        removeObject(redBird);
        if(blueBird != null)
            blueBird.destroy();
        if(redBird != null)
            redBird.destroy();

        blueBird = new BlueBird(this,gameSystem, true, 2);
        redBird = new RedBird(this,gameSystem, true, 1);
        blueBird.setEnemy(redBird);
        redBird.setEnemy(blueBird); 

        addObject( blueBird, 50, 505 ) ;
        addObject( redBird, 1100, 505 ) ;

        //
        removeObject(player1);
        removeObject(player2);

        if(tournament ==null){
            player1 = new Message("Player 1");
            player2 = new Message("Player 2");
        }
        else{

            try {

                System.out.println(world.selectTW.tournament.getCurrent().player1.toString());
                player1 = new Message(world.selectTW.tournament.getCurrent().player1.get("name").toString());
                player2 = new Message(world.selectTW.tournament.getCurrent().player2.get("name").toString());

            } catch (Exception e){
            }
        }

        addObject( player1, player1.getImageLabel().getWidth()/2 + 10, 80) ;
        addObject( player2, 1150 - player1.getImageLabel().getWidth()/2 - 10, 80 ) ;
    }

    public void gameOver(){
        if(blueBird.getState() instanceof WinState){
            world.gameOverW.setResult(tournament,true,null);
        }else{
            world.gameOverW.setResult(tournament,false,null);
        }

        Greenfoot.setWorld( world.gameOverW);
    }

    public void timeOut(){
        int[] array = {blueBird.getCorrectAnswerCount(),redBird.getCorrectAnswerCount()};
        if(blueBird.getCorrectAnswerCount() > redBird.getCorrectAnswerCount()){
            world.gameOverW.setResult(tournament,true,array);
        }

        if(blueBird.getCorrectAnswerCount() < redBird.getCorrectAnswerCount()){
            world.gameOverW.setResult(tournament,false,array);
        }

        Greenfoot.setWorld( world.gameOverW);
    }
}

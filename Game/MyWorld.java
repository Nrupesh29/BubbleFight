import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private System system;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        
        
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        Player player1 = new Player(false,true);
        addObject(player1,48,309);

        Player player2 = new Player(true,true);
        addObject(player2,487,191);

        Ground ground = new Ground();
        addObject(ground,33,392);

        Ground ground2 = new Ground();
        addObject(ground2,556,392);

        // Balloon balloon = new Balloon();
        // addObject(balloon,302,345);
        Pipe pipe = new Pipe();
        addObject(pipe,245,384);
        // balloon.setLocation(381,350);

        system = new System();
        addObject(system,0,0);
        // Label label = new Label("dsaf");
        // addObject(label,245,139);
        Label label = new Label();
       addObject(label,296,110);
    }
}

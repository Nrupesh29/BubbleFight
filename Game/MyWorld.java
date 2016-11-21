import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1150, 600, 1);
        //GreenfootImage background = new GreenfootImage("background.png");
        //setBackground(background);
        addObject( new PlayButton(), 420, 400 ) ;
        addObject( new HelpButton(), 580, 400 ) ;
        addObject( new ExitButton(), 740, 400 ) ; 
    }
}

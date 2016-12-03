import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedBird extends Player
{

    /**
     * Act - do whatever the RedBird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public RedBird(World w,GameSystem gameSystem,  boolean controllable, int c){
        super(w,gameSystem,true, controllable,c);

    }

    public RedBird(){
        super();}
}
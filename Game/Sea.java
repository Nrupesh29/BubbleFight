import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sea extends Actor
{
    public Sea()  
    {  
        GreenfootImage image = getImage();  
        image.scale(image.getWidth() - 130, image.getHeight() - 60);  
        setImage(image);  
    }  

    /**
     * Act - do whatever the Sea wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AnswerMessage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Answer extends Message
{
   

    public Answer(String labelText)  
    { 
        // GreenfootImage label = new GreenfootImage(labelText,25,Color.white,null);  
        // setImage(label);          
        super(labelText);
    }

    public void act() 
    {
        // Add your action code here.
    }   

    public void updateLocation(int x, int y){
        setLocation(x,y);
    }

    public void destroy(){
        getWorld().removeObject(this);
    }
}

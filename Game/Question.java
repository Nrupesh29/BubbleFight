import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Question here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Question extends Message
{
    private Answer answer;
    public Question(String question, Answer a)  
    {
        super(question);
        answer = a;
    }

    public void act() 
    {
        // Add your action code here.
    }    
    
    public void updateLocation(int x, int y){
        setLocation(x,y);
    }
}

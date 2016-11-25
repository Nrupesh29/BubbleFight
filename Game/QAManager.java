import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.ArrayList;
/**
 * Write a description of class AnswerManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QAManager extends Actor implements IObject
{
    private Question question;
    private ArrayList<IObserver> observers = new ArrayList<>();
    public QAManager(){

    }
    
    public void generateQuestion(){
        Random r = new Random();
        int a = r.nextInt(50-1) + 1;
        int b = r.nextInt(50-1) + 1;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        Answer answer = new Answer((a+b)+"");
        question = new Question(Integer.toBinaryString(a) + " + " + Integer.toBinaryString(b),answer);
        notifyUpdateQuestion();
    }

    public Question getQuestion(){
        return question;
    }

    public void attach(IObserver o){
        observers.add(o);
    };

    public void detach(IObserver o){
        observers.remove(o);
    };

    public void notifyUpdateQuestion(){
        for(IObserver obj : observers){
            obj.updateQuestion();
        }
    };

    public void act() 
    {

    }    
}

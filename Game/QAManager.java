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
    private int delay = 0;
    Random random;

    public QAManager(){
        random = new Random();
    }

    public void generateQuestion(){

        int a = random.nextInt(10-1) + 1;
        int b = random.nextInt(10-1) + 1;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        Answer answer = new Answer((a+b)+"");
        if(question != null){
            question.destroy();
        }
        question = new Question(Integer.toBinaryString(a) + " + " + Integer.toBinaryString(b),answer);
        notifyUpdateQuestion();
    }

    public Answer generateAnswer(){
        //add delay for incorrect answer
        if(delay == 0){
            delay = random.nextInt(7-2) + 2;
        }

        delay--;

        if(delay == 0){
            return new Answer(getQuestion().getAnswer().getMessage());
        }

        return new Answer(random.nextInt(50)+"");

    }
    
    public boolean checkQuestion(Answer a){
        return a.getMessage() == question.getAnswer().getMessage();
    }

    public Question getQuestion(){
        return question;
    }

    public void attach(IObserver o){
        observers.add(o);
    }

    public void detach(IObserver o){
        observers.remove(o);
    }

    public void notifyUpdateQuestion(){
        for(IObserver obj : observers){
            obj.updateQuestion();
        }
    }

    public void act() 
    {

    }    
}

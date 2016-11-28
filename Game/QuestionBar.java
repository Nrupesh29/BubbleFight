import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Timer;
import java.util.TimerTask;

/**
 * Write a description of class Question here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuestionBar extends Actor implements IObserver
{
    QAManager pqManager;

    public void act() 
    {
        // Message message = new Message();
        // message.setMessage(getWorld(), "1001 + 1101 + 1010", 630, getY());

    }    

    public QuestionBar(QAManager qa){
        pqManager = qa;
        // .updateLocation();
        //getWorld().addObject(pqManager.getQuestion(),630,45);
        // TimerMessage m = new TimerMessage();
        // m.setMessage(getWorld(), "02:00", 380, getY());
    }

    public void updateQuestion(){
        getWorld().addObject(pqManager.getQuestion(),630,40);
    };
}
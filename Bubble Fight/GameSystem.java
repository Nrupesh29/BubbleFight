import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class GameSystem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameSystem extends Actor
{
    public int pause = 70;
    private int speed = 2;
    private int seaY = 800;
    private int seaMinX = 300;
    private int seaMaxX = 850;

    private int timer = 60;
    private int second = 0;
    private long start = 0;
    private long current = 0;

    private final String API_URL = "http://sample-env.xtfzxnrydy.us-west-1.elasticbeanstalk.com/api/";

    TimerMessage timerMessage;

    QAManager pqManager;
    private PlayWorld world;
    public GameSystem(QAManager qa,PlayWorld w) {
        pqManager = qa;
        world = w;
    }

    public void startGame(){
        current = 0;
        second = timer;
        createTimerMessage(second);
        start = System.currentTimeMillis();
        generateQuestion();

    }

    public void generateQuestion(){
        pqManager.generateQuestion();
    }

    public boolean checkQuestion(Answer a){
        return pqManager.checkQuestion(a);
    }

    public void createTimerMessage(int s){
        timerMessage = TimerMessage.getInstance(s);
        getWorld().addObject(timerMessage,375,45);
    }

    public void act() 
    {
        //prepare coord

        if(pause>0)
            pause--;
        if(pause == 0)
        {
            // Add your action code here.

            Random r = new Random();
            int result = r.nextInt(seaMaxX - seaMinX) + seaMinX;
            Answer label = pqManager.generateAnswer();
            // System.out.println(label.getMessage());
            Bubble b = new Bubble(label, speed);
            getWorld().addObject(b,result,seaY);
            getWorld().addObject(label,result,seaY);
            pause = 70;

        }

        //timer
        if(start > 0 && System.currentTimeMillis() - start > current + 1000 && second > 0){
            current = System.currentTimeMillis() - start;

            second--;

            timerMessage.destroy();
            createTimerMessage(second);

        }
        
        if(second == 0){
            second = -1;
            world.timeOut();
        }
    }    

}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private double fallSpeed = 0;
    private double acceleration = 0.2;
    private boolean isLeft = true;
    
    private boolean controllable = false;
    private final String[] controller1 = {"up","down","left","right"};
    private final String[] controller2 = {"w","s","a","d"};
    private String[] controller = null;

    public Player(boolean isLeft, boolean controllable){
        this.isLeft = isLeft ;
        this.controllable = controllable ;

        if(!isLeft){
            flipImage();
            this.controller = controller1;
        }else{
            this.controller = controller2;            
        }
    }

    public void act() 
    {
        // Add your action code here.

        if(controllable){            
            int speed = 3;
            if(Greenfoot.isKeyDown(controller[0])){
                setLocation(getX(), getY() - speed);
                fallSpeed = 0;  
            }else{
                checkFall();
            }
            // if(Greenfoot.isKeyDown("down"))
            // setLocation(getX(), getY() + speed);

            if(Greenfoot.isKeyDown(controller[2])){
                setLocation(getX() - speed, getY());

                if(!isLeft){
                    flipImage();
                }

                isLeft = true;
            }

            if(Greenfoot.isKeyDown(controller[3])){
                setLocation(getX() + speed, getY());

                if(isLeft){
                    flipImage();
                }

                isLeft = false;
            }
        }
    }    

    public void flipImage(){
        GreenfootImage img = getImage();
        img.mirrorHorizontally();
        setImage(img);
    }

    public boolean onGround()
    {
        Object under = getOneObjectAtOffset(0, getImage().getHeight()/2 + 2, Ground.class);
        return under != null;
    }

    public void checkFall()
    {
        if (onGround()) {
            fallSpeed = 0;  
        }
        else {
            fall();
        }
    }

    public void fall()
    {
        setLocation (getX(), getY() + (int) Math.floor(fallSpeed));
        fallSpeed += acceleration;
    }
}

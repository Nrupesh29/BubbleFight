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

    public Player(boolean isLeft, boolean controllable){
        this.isLeft = isLeft ;
        this.controllable = controllable ;
        if(!isLeft){
            flipImage();
        }
    }

    public void act() 
    {
        // Add your action code here.
        if(controllable){
            int speed = 3;
            if(Greenfoot.isKeyDown("up")){
                setLocation(getX(), getY() - speed);
                fallSpeed = 0;  
            }else{
                checkFall();
            }
            // if(Greenfoot.isKeyDown("down"))
            // setLocation(getX(), getY() + speed);

            if(Greenfoot.isKeyDown("left")){
                setLocation(getX() - speed, getY());

                if(!isLeft){
                    flipImage();
                }

                isLeft = true;
            }


            if(Greenfoot.isKeyDown("right")){
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
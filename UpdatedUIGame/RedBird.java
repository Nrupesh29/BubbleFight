import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedBird extends Player
{
    private double fallSpeed = 0;
    private double acceleration = 0.2;
    private boolean isLeft = true;
    private boolean controllable = false;
    /**
     * Act - do whatever the RedBird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public RedBird(boolean isLeft, boolean controllable){
        this.isLeft = isLeft ;
        this.controllable = controllable ;
    }
    
    public void act() 
    {
        // Add your action code here.
        if(controllable){
            int speed = 3;
            if(Greenfoot.isKeyDown("w")){
                setLocation(getX(), getY() - speed);
                fallSpeed = 0;  
            }else{
                checkFall();
            }
            // if(Greenfoot.isKeyDown("down"))
            // setLocation(getX(), getY() + speed);

            if(Greenfoot.isKeyDown("a")){
                setLocation(getX() - speed, getY());

                if(!isLeft){
                    flipImage();
                }

                isLeft = true;
            }


            if(Greenfoot.isKeyDown("d")){
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
        Object under = getOneObjectAtOffset(0, getImage().getHeight()/2 + 2, Stone.class);
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
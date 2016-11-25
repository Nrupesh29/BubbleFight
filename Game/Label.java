import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Label here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Label extends Actor
{
    private int speed;
    public Label(){
        //super();
        // speed = sp;
        String text = "0";
        GreenfootImage img = new GreenfootImage(text.length()*20,30);
        img.drawString(text,2,20);
        setImage(img);

    }

    public void act() 
    {
        //setLocation(0,0);

    }    
  public void updateLocation(int x, int y){
        setLocation(x,y);
    }

    public void destroy(){
        getWorld().removeObject(this);
    }
   
}

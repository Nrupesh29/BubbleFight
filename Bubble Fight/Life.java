import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Life here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Life extends Actor
{
    Message life;
    int lifeCount;
    int x;
    int y;
    World world;
    public Life(World w,int xc, int yc,int l){
        lifeCount = l;
        x=xc;
        y=yc;
        world = w;
        life = new Message("x"+lifeCount);
        world.addObject(life,x, y);

    }

    public void loseLife(){
        if(lifeCount > 0){
            lifeCount--;
            life.destroy();
            life = new Message("x"+lifeCount);
            world.addObject(life,x, y);
        }
    }

    public void destroy() 
    {
        life.destroy();
        world.removeObject(this);
    }    
}

import java.lang.System.*;
import java.util.*;
/**
 * Write a description of class System here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class System  
{
    // instance variables - replace the example below with your own
    private int x;
    private MyWorld world;
    /**
     * Constructor for objects of class System
     */
    public System(MyWorld world)
    {
        this.world = world;
        List array = world.getObjects(Pipe.class);
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}

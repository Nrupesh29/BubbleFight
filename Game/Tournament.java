/**
 * Write a description of class Tournament here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import org.json.*;
import java.util.ArrayList;
public class Tournament  
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Tournament
     */
    private JSONObject json;
    private ArrayList<Match> list;
    public Tournament(JSONObject j)
    {
        json = j;
        list = new ArrayList<Match>();
    }

    public void addMatch(JSONObject m, JSONObject p1, JSONObject p2){
        list.add(new Match(m,p1,p2));
    }

    public class Match{
        public JSONObject match;
        public JSONObject player1;
        public JSONObject player2;
        public Match(JSONObject m, JSONObject p1, JSONObject p2){
            match =m;
            player1 = p1;
            player2 = p2;
        }
    }

}

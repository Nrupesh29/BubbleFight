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
    public ArrayList<Match> list;
    int id, index;
    
    public Tournament(JSONObject j)
    {
        json = j;
        list = new ArrayList<Match>();
    }
    
    public void setId (int id) {
        this.id = id;
    }
    
    public int getTournamentId() {
        return this.id;
    }

    public void addMatch(JSONObject m, JSONObject p1, JSONObject p2){
        list.add(new Match(m,p1,p2));
    }
    
    public Match findMatch(JSONObject j){
        Match m = null;
        for(int i = 0; i < list.size();i++){
            if(list.get(i).match == j){
                m = list.get(i);
                break;
            }
        }
        return m;
    }

    public void setCurrent(Match m){
        for(int i = 0; i < list.size();i++){
            if(list.get(i) == m){
                list.get(i).setCurrent(true);
            }else{
                list.get(i).setCurrent(false);                
            }
        }
    }
    
    public Match getCurrent(){
        for(int i = 0; i < list.size();i++){
            if(list.get(i).current){
                return list.get(i);
            }
        }
        return null;
    }
   

}

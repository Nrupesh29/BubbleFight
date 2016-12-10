import org.json.*; 
public class Match{
    public JSONObject match;
    public JSONObject player1;
    public JSONObject player2;
    public boolean current;
    public Match(JSONObject m, JSONObject p1, JSONObject p2){
        match =m;
        player1 = p1;
        player2 = p2;
        current = false;
    }

    public void setCurrent(boolean c){
        current = c;
    }
    
    public JSONObject getMatchDetails(){
        return match;
    }
    
    public JSONObject getP1Details(){
        return player1;
    }
    
    public JSONObject getP2Details(){
        return player2;
    }
}
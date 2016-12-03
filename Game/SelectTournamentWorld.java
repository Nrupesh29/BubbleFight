import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.awt.Color;
import org.restlet.*;
import org.restlet.resource.ClientResource;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.json.*;
/**
 * Write a description of class SelectTournamentWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectTournamentWorld extends World
{

    /**
     * Constructor for objects of class SelectTournamentWorld.
     * 
     */
    private MyWorld world;
    private final String API_URL = "http://sample-env.xtfzxnrydy.us-west-1.elasticbeanstalk.com/api/";
    public Tournament tournament;
    private DropDownList listMatches;
    public SelectTournamentWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1150, 600, 1);   

        ArrayList cities = new ArrayList<String>();
        cities.add("Taipei City");
        cities.add("New Taipei City df gdfgdg");
        cities.add("Taichung City");
        cities.add("Tainan City");
        cities.add("Kaohsiung City");

        //player
        BlueBird bluebird = new BlueBird();
        addObject(bluebird,250,250);
        RedBird redbird = new RedBird();
        addObject(redbird,900,250);

        addObject( new Message("VS", Color.green,100), 575, 250 ) ;
        try {
            loadTournaments();

        } catch (Exception e){
            System.out.println(e);
            // Deal with e as you please.
            //e may be any type of exception at all.

        }

    }

    public void loadTournaments()throws Exception{
        String url = API_URL + "tournaments";
        ClientResource helloClientresource = new ClientResource(url); 
        JsonRepresentation rep = new JsonRepresentation("{array:"+helloClientresource.get().getText()+"}");
        JSONObject json = rep.getJsonObject();
        System.out.println(json.toString());
        JSONArray list = json.getJSONArray("array");
        System.out.println(list.toString());

        if(list.length() > 0){
            tournament = new Tournament(list.getJSONObject(0));
            DropDownList listD = new DropDownList(list, 0, this,"tournament");
            addObject(listD, 575, 100);
            addObject( new Message("Select Tournament", Color.blue,50), 575, 50 ) ;
            loadMatches(list.getJSONObject(0));
        }else{
            System.out.println("no tournaments");
        }
    }

    public void removeMatchesD(){
        if(listMatches != null){
            listMatches.collapseList();
            removeObject(listMatches);
        }
    }

    public void loadMatches(JSONObject obj)throws Exception{
        removeMatchesD();
        String url = API_URL + "match-tournament/"+obj.get("id");
        ClientResource helloClientresource = new ClientResource(url); 
        JsonRepresentation rep = new JsonRepresentation("{array:"+helloClientresource.get().getText()+"}");
        JSONObject json = rep.getJsonObject();
        System.out.println(json.toString());
        JSONArray list = json.getJSONArray("array");
        System.out.println(list.toString());

        for (int i = 0; i < list.length(); i++) {
            JSONObject j = list.getJSONObject(i);
            ClientResource cl1 = new ClientResource(API_URL+"player/"+j.get("player_one_id")); 
            JsonRepresentation rep1 = new JsonRepresentation(cl1.get());
            JSONObject json1 = rep1.getJsonObject();

            ClientResource cl2 = new ClientResource(API_URL+"player/"+j.get("player_two_id")); 
            JsonRepresentation rep2 = new JsonRepresentation(cl2.get());
            JSONObject json2 = rep2.getJsonObject();

            j.put("name",json1.get("name") + " vs "+ json2.get("name"));
            tournament.addMatch(j,json1,json2);
        }
        // System.out.println(list.toString());

        if(list.length() > 0){ 
            listMatches = new DropDownList(list, 0, this,"match");            
            addObject(listMatches, 575, 320);
            Match m = tournament.findMatch(list.getJSONObject(0));
            tournament.setCurrent(m);
            System.out.println(tournament.getCurrent().player1.toString());
        }else{
            System.out.println("no matches");
        }
    }

    public void setWorld(MyWorld w){
        world = w;

        PlayButton backB = new PlayButton(world.modeW, true);
        addObject( backB, 50, 50 ) ;

        addObject( new PlayButton(world.playW), 575, 500 ) ;
    }

}

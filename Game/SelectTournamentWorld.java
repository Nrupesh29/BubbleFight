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

    public Tournament tournament;
    private DropDownList listMatches;
    DropDownList listD;
    
    public SelectTournamentWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1150, 600, 1);   

        

        //player
        BlueBird bluebird = new BlueBird();
        addObject(bluebird,250,250);
        RedBird redbird = new RedBird();
        addObject(redbird,900,250);

        addObject( new Message("V/S", Color.yellow,50), 575, 250 ) ;

    }

    public void loadTournaments()throws Exception{
        String url = world.API_URL + "tournaments";
        //System.out.println(world);
        ClientResource helloClientresource = new ClientResource(url); 
        JsonRepresentation rep = new JsonRepresentation("{array:"+helloClientresource.get().getText()+"}");
        JSONObject json = rep.getJsonObject();
        //System.out.println(json.toString());
        JSONArray list = json.getJSONArray("array");
        //System.out.println(list.toString());

        if(list.length() > 0){
            tournament = new Tournament(list.getJSONObject(0));
            listD = new DropDownList(list, 0, this,"tournament");
            addObject(listD, 575, 100);
            addObject( new Message("SELECT TOURNAMENT", Color.yellow,30), 575, 50 ) ;
            loadMatches(list.getJSONObject(0));
        }else{
            //System.out.println("no tournaments");
        }
    }

    public void removeMatchesD(){
        if(listMatches != null){
            listMatches.collapseList();
            removeObject(listMatches);
        }
    }

    public void loadMatches(JSONObject obj) throws Exception {
        removeMatchesD();
        //tournament = new Tournament(obj);
        tournament.setId(obj.getInt("id"));
        String url = world.API_URL + "match-tournament/"+obj.get("id");
        //ClientResource helloClientresource = new ClientResource(url); 
        //JsonRepresentation rep = new JsonRepresentation("{array:"+helloClientresource.get().getText()+"}");
        ResourceHandler rh = new ResourceHandler();
        String JSON_STRING = rh.sendGetRequest(url);
        //System.out.println("Hello1: " + JSON_STRING);
        JSONObject jsonObject = new JSONObject("{array:" + JSON_STRING + "}");
        JSONArray result = jsonObject.getJSONArray("array");
        /*JSONObject json = rep.getJsonObject();
        System.out.println(json.toString());
        JSONArray list = json.getJSONArray("array");
        JSONArray listFilter = new JSONArray();
        System.out.println(list.toString());*/
        JSONArray listFilter = new JSONArray();

        for (int i = 0; i < result.length(); i++) {
            //JSONObject j = result.getJSONObject(i);
            JSONObject jo = result.getJSONObject(i);
            //String id = ;
            /*ClientResource cl1 = new ClientResource(world.API_URL+"player/" + jo.getString("player_one_id")); 
            JsonRepresentation rep1 = new JsonRepresentation(cl1.get());
            JSONObject json1 = rep1.getJsonObject();*/
            //System.out.println("Hello2: " + jo.getString("player_one_id"));
            
            
            if(jo.getInt("player_one_id") != 0)
            {
                if(jo.getInt("player_two_id") != 0) 
                {
                    String JSON_STRING_1 = rh.sendGetRequest(world.API_URL+"player/" + jo.getString("player_one_id"));
                    JSONObject jo1 = new JSONObject(JSON_STRING_1);

                    String JSON_STRING_2 = rh.sendGetRequest(world.API_URL+"player/" + jo.getString("player_two_id"));
                    JSONObject jo2 = new JSONObject(JSON_STRING_2);
                    
                    jo.put("name",jo1.getString("name") + "  v/s  "+ jo2.getString("name"));
                    tournament.addMatch(jo,jo1,jo2);

                    if(jo.get("winner_id") instanceof String){

                    }else{
                        listFilter.put(jo);
                    }
                }
            }
        }
        //System.out.println(listFilter.toString());

        if(listFilter.length() > 0){      
            listMatches = new DropDownList(listFilter, 0, this,"match");  
            addObject(listMatches, 575, 320);
            Match m = tournament.findMatch(listFilter.getJSONObject(0));
            tournament.setCurrent(m);
        }else{
            listFilter.put(new JSONObject().put("name","no match"));
            listMatches = new DropDownList(listFilter, 0, this,"match");  
            addObject(listMatches, 575, 320);
            //System.out.println("no matches");
        }
        
    }

    public void setWorld(MyWorld w){
        world = w;

        PlayButton backB = new PlayButton(world.modeW, true);
        addObject( backB, 50, 50 ) ;

        addObject( new PlayButton(world.playW), 575, 500 ) ;
        try {
            loadTournaments();
            
        } catch (Exception e){
            System.out.println(e);
            // Deal with e as you please.
            //e may be any type of exception at all.

        }
    }

    public void addTournament(){
        world.playW.setTournament(tournament);
        
    }
}

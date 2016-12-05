import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.io.IOException;
import org.restlet.resource.ResourceException;
import org.restlet.*;
import org.restlet.resource.ClientResource;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.json.*;
import org.restlet.data.MediaType;
import org.restlet.data.Form;
import java.util.HashMap;

/**
 * Write a description of class GameOverWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverWorld extends World
{
    private MyWorld world;
    private Tournament tournament = null;
    private Message player1;
    private Message player2;
    private Message p1Status;
    private Message p2Status;
    private Message p1Point;
    private Message p2Point;
    /**
     * Constructor for objects of class GameOverWorld.
     * 
     */
    public GameOverWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1150, 600, 1);
        //player
        BlueBird bluebird = new BlueBird();
        addObject(bluebird,240,250);
        RedBird redbird = new RedBird(); 
        addObject(redbird,900,250);
        addObject( new Message("VS", Color.green,100), 575, 250 ) ;

    }

    public void setWorld(MyWorld w){
        world = w;

        PlayButton backB = new PlayButton(world.introW, true);
        addObject( backB, 50, 50 ) ;

    }

    public void setResult(Tournament t, boolean isOneWin, int[] points){
        int winner = 0;
        removeObject(player1);
        removeObject(player2);
        removeObject(p1Status);
        removeObject(p2Status);
        removeObject(p1Point);
        removeObject(p2Point);
        //
        tournament = t;
        if(tournament == null){
            player1 = new Message("Player 1");
            player2 = new Message("Player 2");
        }
        else{

            try {

                //System.out.println(world.selectTW.tournament.getCurrent().player1.toString());
                player1 = new Message(world.selectTW.tournament.getCurrent().player1.get("name").toString());
                player2 = new Message(world.selectTW.tournament.getCurrent().player2.get("name").toString());

            } catch (Exception e){
            }
        }

        addObject( player1, player1.getImage().getWidth()/2 + 210, 320) ;
        addObject( player2, 1150 - player1.getImage().getWidth()/2 - 210, 320) ;

        //
        System.out.println( points);
        if(points != null){
            p1Point = new Message(points[0]+" correct answers(s)", Color.black,30);
            p2Point = new Message(points[1]+" correct answers(s)", Color.black,30);
            addObject( p1Point, p1Point.getImage().getWidth()/2 + 150, 380) ;
            addObject( p2Point, 1150 - p2Point.getImage().getWidth()/2 - 140, 380) ;
        }
        if(points != null && points[0] == points[1]){

            p1Status = new Message("DRAW", Color.blue,50);
            p2Status = new Message("DRAW", Color.blue,50);

        }else{
            if(isOneWin){
                p1Status = new Message("WIN", Color.yellow,50);
                p2Status = new Message("LOSE", Color.red,50);
                winner = 1;
            }else{
                p1Status = new Message("LOSE", Color.red,50);
                p2Status = new Message("WIN", Color.yellow,50);
                winner = 2;
            }            
        }

        addObject( p1Status, p1Status.getImage().getWidth()/2 + 200, 180) ;
        addObject( p2Status, 1150 - p2Status.getImage().getWidth()/2 - 200, 180) ;

        updateDatabase(tournament,winner);
    }

    private void updateDatabase(Tournament t, int winner){
        if(winner == 0){
            return;
        }

        try{
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();

            if(t == null){ 

                ResourceHandler cr = new ResourceHandler();
                HashMap<String, String> data = new HashMap<>();

                data.put("playerOneId", "1");
                data.put("playerTwoId", "2");
                data.put("winnerId", winner==1?"1":"2");
                data.put("matchDate", dateFormat.format(date));
                data.put("matchScore", winner==1?"1 - 0":"0 - 1");

                String str = cr.sendPostRequest(world.API_URL+"match", data);

                System.out.println(str);

            }else{
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

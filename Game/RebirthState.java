
/**
 * Write a description of class RebirthState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RebirthState implements State
{
    private Player player;
    public RebirthState(Player player){
        this.player = player;
    };

    public void initialize(){
        if(player.isAlive()){
            player.setState(player.getUnBeatableState());            
        }else{
            player.setState(player.getLoseState());
        }
    };

    public void answerIncorrect(){};

    public void fallToTheSea(){};

    public void doAttack(Player p){

    };

    public void beAttack(){

    };

    public void answerCorrect(){};
}

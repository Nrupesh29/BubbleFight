
/**
 * Write a description of class UnBeatableState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UnBeatableState implements State
{
    private Player player;
    public UnBeatableState(Player player){
        this.player = player;

    };

    public void initialize(){
        //TODO after 2 second
        if(player.hasEnergy()){
            player.setState(player.getEnergyState());
        }else{
            player.setState(player.getNormalState());
        }
    };

    public void answerIncorrect(){};

    public void fallToTheSea(){};

    public void doAttack(){};

    public void beAttack(){};

    public void answerCorrect(){};
}

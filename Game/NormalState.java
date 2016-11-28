
/**
 * Write a description of class RebirthState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalState implements State
{
    private Player player;
    public NormalState(Player player){
        this.player = player;
    };

    public void initialize(){
        if(player.hasEnergy()){
            player.setState(player.getEnergyState());
        }
    };

    public void answerIncorrect(){
        player.setState(player.getRebirthState());
    };

    public void fallToTheSea(){
        player.loseLife();
        player.setState(player.getRebirthState());
    };

    public void doAttack(){

    };

    public void beAttack(){
        player.loseLife();
        player.setState(player.getRebirthState());

    };

    public void answerCorrect(){
        initialize();
    };
}

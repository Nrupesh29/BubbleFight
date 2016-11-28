
/**
 * Write a description of class RebirthState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnergyState implements State
{
    private Player player;
    public EnergyState(Player player){
        this.player = player;
    };

    public void initialize(){

    };

    public void answerIncorrect(){
        player.setState(player.getRebirthState());
    };

    public void fallToTheSea(){
        player.loseLife();
        player.setState(player.getRebirthState());
    };

    public void doAttack(){
        player.getEnemy().getState().beAttack();
    };

    public void beAttack(){
        player.loseLife();
        player.setState(player.getRebirthState());

    };

    public void answerCorrect(){};
}

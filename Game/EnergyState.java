import java.awt.Color;
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
        player.addNotification("Incorrect answer.\nRelocated.",Color.blue);
    };

    public void fallToTheSea(){
        player.loseLife();
        player.setState(player.getRebirthState());
        player.addNotification("Fall to the sea.\nLose 1 life.",Color.red);
    };

    public void doAttack(){
        player.getEnemy().getState().beAttack();
    };

    public void beAttack(){
        player.loseLife();
        player.setState(player.getRebirthState());
        player.addNotification("Is attacked.\nLose 1 life.",Color.red);
    };

    public void answerCorrect(){
        player.addNotification("Correct answer.\nGet 1 point.",Color.orange);
    };
}

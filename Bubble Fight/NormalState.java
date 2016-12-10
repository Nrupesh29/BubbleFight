import java.awt.Color;
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
        player.addNotification("Incorrect answer.\nRelocated.",Color.blue);
    };

    public void fallToTheSea(){
        player.loseLife();
        player.setState(player.getRebirthState());
        player.addNotification("Fall to the sea.\nLose 1 life & relocated.",Color.red);
    };

    public void doAttack(){

    };

    public void beAttack(){
        player.loseLife();
        player.setState(player.getRebirthState());
        player.addNotification("Is attacked.\nLose 1 life.",Color.red);
    };

    public void answerCorrect(){
        initialize();
        player.addNotification("Correct answer.\nGet 1 point.",Color.orange);
    };
}

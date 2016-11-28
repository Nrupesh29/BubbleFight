
/**
 * Write a description of class ProtectedState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProtectedState implements State
{
    private Player player;
    public ProtectedState(Player player){
        this.player = player;
    };
    
    public void initialize(){};

    public void answerIncorrect(){
        player.addIncorrectAnswer();
        player.setState(player.getRebirthState());
    };

    public void fallToTheSea(){
        //remove 1 life
        player.loseLife();
        player.setState(player.getRebirthState());

    };

    public void doAttack(Player p){
        p.beAttack();
    };

    public void beAttack(){
        //System.out.println("User is protected");
    };

    public void answerCorrect(){
        player.addCorrectAnswer();
    };
}


/**
 * Write a description of class UnProtectedState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UnProtectedState implements State
{
    private Player player;
    public UnProtectedState(Player player){
        this.player = player;
    };

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
        //remove 1 life
        player.loseLife();
        player.setState(player.getRebirthState());
    };

    public void answerCorrect(){
        player.addCorrectAnswer();
    };
}

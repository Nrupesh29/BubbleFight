
/**
 * Write a description of class LoseState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoseState implements State
{
    private Player player;
    public LoseState(Player p){
        player = p;
    };
    public void initialize(){
        player.gameOver();
    };
    public void answerIncorrect(){};

    public void fallToTheSea(){};

    public void doAttack(){
    };

    public void beAttack(){
    };

    public void answerCorrect(){};
}

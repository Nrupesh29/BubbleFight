
/**
 * Write a description of class WinState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinState implements State
{
    public Player player;
    public WinState(Player player){
        this.player = player;
    };
    public void initialize(){};
    public void answerIncorrect(){};

    public void fallToTheSea(){};

    public void doAttack(){
    };

    public void beAttack(){
    };

    public void answerCorrect(){};
}

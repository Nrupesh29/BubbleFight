
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

    public void answerIncorrect(){};

    public void fallToTheSea(){};

    public void attack(){};

    public void getAttack(){};

    public void answerCorrect(){};
}

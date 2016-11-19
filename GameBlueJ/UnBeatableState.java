
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
        //TODO after 2 second
        if(player.isProtected()){
            player.setState(player.getProtectedState());
        }else{
            player.setState(player.getUnProtectedState());
        }
    };

    public void answerIncorrect(){};

    public void fallToTheSea(){};

    public void doAttack(Player p){};

    public void beAttack(){};

    public void answerCorrect(){};
}

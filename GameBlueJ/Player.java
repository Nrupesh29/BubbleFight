
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    State protectedState;
    State unProtectedState;
    State unBeatableState;
    State rebirthState;
    State loseState;
    State winState;

    State state = protectedState;
    
    public Player(){
        protectedState = new ProtectedState(this);
        unProtectedState = new UnProtectedState(this);
        unBeatableState = new UnBeatableState(this);
        rebirthState = new RebirthState(this);
        loseState = new LoseState(this);
        winState = new WinState(this);
    }

    public void setState(State s){
        state = s;
    }

    public State getState() {
        return state;
    }

    public State getProtectedState() {
        return protectedState;
    }

    public State getUnProtectedState() {
        return unProtectedState;
    }

    public State getUnBeatableState() {
        return unBeatableState;
    }

    public State getRebirthState() {
        return rebirthState;
    }

    public State getLoseState() {
        return loseState;
    }

    public State getWinState() {
        return winState;
    }
}

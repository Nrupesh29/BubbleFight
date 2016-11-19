
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
    int lifeCount;
    int protectionCount;
    int answerCorrectCount;
    int answerIncorrectCount;

    Player enemy;

    public Player(){
        protectedState = new ProtectedState(this);
        unProtectedState = new UnProtectedState(this);
        unBeatableState = new UnBeatableState(this);
        rebirthState = new RebirthState(this);
        loseState = new LoseState(this);
        winState = new WinState(this);

        lifeCount = 2;
        protectionCount = 2;
        answerCorrectCount = 0;
        answerIncorrectCount = 0;
    }

    public void setEnemy(Player p){
        enemy = p;
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

    public int countLife(){
        return lifeCount;    
    }

    public void loseLife(){
        lifeCount--;
    }

    public boolean isAlive(){
        return lifeCount > 0;
    }

    public boolean isProtected(){
        return protectionCount > 0;
    }

    public void loseOneProtection(){
        protectionCount--;
    }

    public void beAttack(){
        state.beAttack();
    }

    public void addCorrectAnswer(){
        answerCorrectCount++;
        enemy.loseOneProtection();
    }

    public void addIncorrectAnswer(){
        answerIncorrectCount++;
    }

    public void answerQuestion(){
        //TODO check answer
        if(true){
            state.answerCorrect();
        }else{
            state.answerIncorrect();
        }
    }
}

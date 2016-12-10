
/**
 * Write a description of interface State here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface State
{
    /**
     * An example of a method header - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the result produced by sampleMethod 
     */
    public void initialize();

    public void answerIncorrect();

    public void fallToTheSea();

    public void doAttack();

    public void beAttack();

    public void answerCorrect();
}

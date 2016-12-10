/**
 * Write a description of class IObserver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IObject
{
    public void attach(IObserver o);

    public void detach(IObserver o);

    public void notifyUpdateQuestion();
}

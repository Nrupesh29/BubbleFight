import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor 
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

    public String name;

    private double fallSpeed = 0;
    private double acceleration = 0.2;
    private boolean isLeft = true;
    private boolean controllable = false;

    private final String[] controller1 = {"up","down","left","right"};
    private final String[] controller2 = {"w","s","a","d"};
    private String[] controller = null;
    private int originX = 0;
    private int originY = 0;

    public Player(boolean isLeft, boolean controllable, int c){
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

        this.isLeft = isLeft ;
        this.controllable = controllable ;       

        if(c == 1){            
            this.controller = controller1;
        }else{
            this.controller = controller2;            
        }

    }

    public void act() 
    {
        //set origin
        if(originX == 0 && originY == 0){
            //System.out.println(this.getX());
        originX = this.getX();
        originY = this.getY();
        }

        // controller by key
        if(controllable){            
            int speed = 3;
            if(Greenfoot.isKeyDown(controller[0])){
                setLocation(getX(), getY() - speed);
                fallSpeed = 0;  
            }else{
                checkFall();
            }
            // if(Greenfoot.isKeyDown("down"))
            // setLocation(getX(), getY() + speed);

            if(Greenfoot.isKeyDown(controller[2])){
                setLocation(getX() - speed, getY());

                if(!isLeft){
                    flipImage();
                }

                isLeft = true;
            }

            if(Greenfoot.isKeyDown(controller[3])){
                setLocation(getX() + speed, getY());

                if(isLeft){
                    flipImage();
                }

                isLeft = false;
            }
        }

        //fall to the sea
        Actor sea = getOneIntersectingObject(Sea.class);
        if(sea != null){
            System.out.println(sea);
            System.out.println("fall to the sea");
            fallToTheSea();
        }

    }    

    public void flipImage(){
        GreenfootImage img = getImage();
        img.mirrorHorizontally();
        setImage(img);
    }

    public boolean onGround()
    {
        Object under = getOneObjectAtOffset(0, getImage().getHeight()/2 + 2, Stone.class);
        return under != null;
    }

    public void checkFall()
    {
        if (onGround()) {
            fallSpeed = 0;  
        }
        else {
            fall();
        }
    }

    public void fall()
    {
        setLocation (getX(), getY() + (int) Math.floor(fallSpeed));
        fallSpeed += acceleration;
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

    public void fallToTheSea(){
        setToOriginLocation();
        if(state != null)
            state.fallToTheSea();
    }

    public void setToOriginLocation(){
         setLocation(originX,originY);
    }
}

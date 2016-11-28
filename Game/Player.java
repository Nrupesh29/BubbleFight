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

    State state;
    int lifeCount;
    int protectionCount;
    int answerCorrectCount;
    int answerIncorrectCount;

    Player enemy;
    World world;

    public String name;

    private double fallSpeed = 0;
    private double acceleration = 0.2;
    private boolean isLeft = true;
    private boolean controllable = false;

    private final String[] controller1 = {"up","down","left","right"};
    private final String[] controller2 = {"w","s","a","d"};
    private String[] controller = null;
    private final int[] playerLocations1 = {1130,50, 1100, 50, 1105, 20};
    private final int[] playerLocations2 = {50,50,18, 50,45, 20};
    private int[] playerLocations;    
    private int originX = 0;
    private int originY = 0;
    private Life life;
    private Energy energyBar;
    private int energyCount;

    private GameSystem gameSystem;

    public Player(World w,GameSystem gs, boolean isLeft, boolean controllable, int c){

        world=w;
        gameSystem = gs;
        protectedState = new ProtectedState(this);
        unProtectedState = new UnProtectedState(this);
        unBeatableState = new UnBeatableState(this);
        rebirthState = new RebirthState(this);
        loseState = new LoseState(this);
        winState = new WinState(this);
        state = protectedState;

        lifeCount = 2;
        energyCount = 0;
        protectionCount = 2;
        answerCorrectCount = 0;
        answerIncorrectCount = 0;

        this.isLeft = isLeft ;
        this.controllable = controllable ;       

        if(c == 1){            
            this.controller = controller1;
            playerLocations = playerLocations1;

        }else{
            this.controller = controller2;     
            playerLocations = playerLocations2;

        }
        setUpPlayer();

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

        //touch bubble
        Bubble bubble = (Bubble) getOneIntersectingObject(Bubble.class);
        if(bubble != null){
            System.out.println("tough bubble");
            answerQuestion(bubble);
        }

    }    

    public void setUpPlayer(){
        life = new Life(world,playerLocations[0],playerLocations[1],lifeCount);
        world.addObject( life, playerLocations[2],playerLocations[3] ) ;          
        energyBar = new Energy0();
        world.addObject( energyBar, playerLocations[4],playerLocations[5] ) ;        
    }

    public void updateEnergyBar(){
        if(energyCount == 1){
            world.removeObject( energyBar );
            energyBar = new Energy50();
            world.addObject( energyBar, playerLocations[4],playerLocations[5] ) ;        
        }
        if(energyCount > 1){
            world.removeObject( energyBar );
            energyBar = new Energy100();
            world.addObject( energyBar, playerLocations[4],playerLocations[5] ) ;        
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
        System.out.println("state: " +s);     
        if(state instanceof RebirthState){
            System.out.println("rebirth");

        }
        state.initialize();

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
        life.loseLife();
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

    public void answerQuestion(Bubble b){
        b.destroy();
        //TODO check answer
        if(gameSystem.checkQuestion(b.getAnswer())){
            System.out.println("correct");
            //state.answerCorrect();
            energyCount++;
            updateEnergyBar();
            gameSystem.generateQuestion();
        }else{
            System.out.println("incorrect");
            // state.answerIncorrect();
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

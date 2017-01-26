import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ghostbusters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghostbusters extends World
{
    private int score;
    private int time;
    private int gameState;
    /**
     * Constructor for objects of class Ghostbusters.
     * 
     */
    public Ghostbusters()
    {    
        super(650, 300, 1);
        TitleScreen begin = new TitleScreen();
        Greenfoot.setWorld(begin);
        score = 0;
        time = 3000;
        showScore();
        showTime();
        setPaintOrder(TitleScreen.class, Slimer.class, Venkman.class, Ecto1.class);
        prepare();
        
    }
    
     public void act() 
    {
        if (Greenfoot.getRandomNumber(100) < 3)
        {
            addObject(new Slimer(), 779, Greenfoot.getRandomNumber(360));
        }
         if (Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(new City(), 649, 250);
        }
        countTime();
    }
    
    private void prepare()

    {

        Venkman venkman = new Venkman();
        addObject(venkman,83,336);
        venkman.setLocation(49,250);
        City city = new City();
        addObject(city,635,225);
        city.setLocation(635,225);
        City city2 = new City();
        addObject(city2,395,208);
        city2.setLocation(145,306);
        City city3 = new City();
        addObject(city3,496,178);
        City city4 = new City();
        addObject(city4,454,100);
        city3.setLocation(496,178);
        city4.setLocation(3,171);
        Ecto1 ecto1 = new Ecto1();
        addObject(ecto1,143,261);
        ecto1.setLocation(146,253);
    }
    
    public void showScore(){
        showText("Score: " + score, 80, 25);
    }
    
    private void showTime(){
        showText("Time: " + time, 550, 25);
    }
    
    public void addScore(int points){
        score += points;
        showScore();
        
        if(score < 0 ){
            Greenfoot.stop();
        }
    }
    
    private void countTime(){
        time--;
        showTime();
        
        if(time <= 0 ){
            showEndMessage();
            Greenfoot.stop();
        }
    }
    
    private void showEndMessage(){
        showText("You Won, you're a true Ghostbuster!", 325, 145);
        showText("Your final score: " + score + " points", 325, 165);
    }
}

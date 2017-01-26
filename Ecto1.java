import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ecto1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ecto1 extends Actor
{
    private int reloadCounter = 10;
    //How long it takes for the proton to shoot again
    public void act() 
    {
        checkKeyPress();
        checkFire();
        checkCollision();
        reloadCounter++;
    } 
    public void checkFire()
    {
       if(Greenfoot.isKeyDown("w")) {
           if( reloadCounter >= 10){
               getWorld().addObject(new Proton(), this.getX() + 250, this. getY() - 30);
               reloadCounter = 0;
               //adds proton to world when the w key is clicked
           }
       }
    }
    /**
     * Check whether a keyboard key has been pressed and react if it has.
     */
    private void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("a")) 
        {
            setLocation(getX()-4, getY());
            //Moves ecto1 left when a key is pressed
        }
        
        if (Greenfoot.isKeyDown("d")) 
        {
            setLocation(getX()+4, getY());
            //Moves ecto1 right when d key is pressed
        }
    }
      private void checkCollision(){
          Ghostbusters world = (Ghostbusters)getWorld();
        if (isTouching(Slimer.class)){
            world.addScore(-100);
            removeTouching(Slimer.class);
            //Ifecto1 touches slimer, -100 points from score
        }
    }   
}

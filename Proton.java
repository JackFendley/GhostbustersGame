import greenfoot.*;
/**
 * Write a description of class Proton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Proton extends Actor
{
    /**
     * Act - do whatever the Proton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkCollision();
       setLocation(getX() + speed, getY());
       if (getX() >= 649) 
        {
            getWorld().removeObject(this);
        }
        //Checks to see if Proton has reached the edge of the world if so, removes proton
        
    }
       private void checkCollision(){
        Ghostbusters world = (Ghostbusters)getWorld();
        if (isTouching(Slimer.class)){
            world.addScore(20);
            removeTouching(Slimer.class);
        }
        //If proton hits slimer, slimer will be removed
    }
    private int speed = 10;
    //How fast the proton moves
}


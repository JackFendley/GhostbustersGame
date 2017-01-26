import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class City here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class City extends Actor
{
    /**
     * Act - do whatever the City wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
          setLocation(getX()-1, getY());
        //Where the city spawns
        if (getX() == 0) 
        {
            getWorld().removeObject(this);
            //If city hits the edge of the world, removes the city
        }
    }    
}

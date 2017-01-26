import greenfoot.*;
/**
 * Write a description of class Venkman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Venkman extends Actor
{
    private final int MAX_Y = 350;
    //How high venkman can jump
    private int jumpCounter = 20;
    //How long it takes to jump again
    private int reloadCounter = 10;
    //How long it takes for the proton to shoot again
    /**
     * Act - do whatever the Venkman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeyPress();
        checkFire();
        checkCollision();
        if(getY() < 270 && jumpCounter >= 0){
            setLocation(getX(), getY()+1);
        }  else if( getY() == 270 ){
            jumpCounter = 20;
        }
        reloadCounter++;
    } 
    public void checkFire()
    {
       if(Greenfoot.isKeyDown("enter"))
       {
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
        if (Greenfoot.isKeyDown("space")) 
        {
            if(jumpCounter > 0){
                setLocation(getX(), getY()-4);
                jumpCounter--;
                //Allows venkman to jump if space key is pressed
            }
        }
        
        if (Greenfoot.isKeyDown("left")) 
        {
            setLocation(getX()-4, getY());
            //Moves venkman left when left arrow key is pressed
        }
        
        if (Greenfoot.isKeyDown("right")) 
        {
            setLocation(getX()+4, getY());
            //Moves venkman right when right arrow key is pressed
        }
    }
      private void checkCollision(){
          Ghostbusters world = (Ghostbusters)getWorld();
        if (isTouching(Slimer.class)){
            world.addScore(-100);
            removeTouching(Slimer.class);
            //If venkman touches slimer, -100 points from score
        }
    }
}

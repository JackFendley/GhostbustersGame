import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    private PlayButton playButton;
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(650, 300, 1); 
        getBackground().scale(650, 300);
        //size of world / image
        playButton = new PlayButton();
        addObject(playButton, getWidth()-310, getHeight() -40);
        
        //adds play button
    }
    
     public void act()
    {
        //check if mouse clicks the play button
        checkMouse();
    }

    /**
     * Checks for mouse movement and clicks.
     */
    public void checkMouse()
    {
        //start the game if the player clicks on the play button
        if(Greenfoot.mouseClicked(playButton))
            Greenfoot.setWorld(new Ghostbusters());
    }
}

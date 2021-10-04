import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */
public class gameby extends titleelements

{private GreenfootImage gameby=new GreenfootImage("a game by kev.png");

    private int transparent;
    public gameby()
    {transparent=0;
        setImage(gameby);
    }
    /**
     * Act - do whatever the gameby wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {if (transparent<255)
        
        transparent++;
        gameby.setTransparency(transparent);}

        


}

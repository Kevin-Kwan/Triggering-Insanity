import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Kevin
 * @version 1.0.0
 */
public class pressspace extends titleelements

{private GreenfootImage pressspace=new GreenfootImage("pressstart.png");
    
    private int transparent;
    public pressspace()
    {transparent=255;
        setImage(pressspace);
    }
    /**
     * Act - do whatever the pressspace wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {counter++;
        if (counter%60==0)
        transparent=255;
        else if (counter%30<15)
        transparent=0;
        else
        transparent=255;
       
        pressspace.setTransparency(transparent);}

        


}

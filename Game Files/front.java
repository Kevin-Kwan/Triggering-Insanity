import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */
public class front extends titleelements

{ private GreenfootImage front=new GreenfootImage("blank.png");
    private int x,y;
    private int counter=0;
    private int loop=30;
    private boolean getxy=false;
    private int transparent;
    public front()
    {transparent=255;
        setImage(front);
    }
    /**
     * Act - do whatever the front wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {if (transparent>0)
        {
        transparent--;}
        front.setTransparency(transparent);
}
}


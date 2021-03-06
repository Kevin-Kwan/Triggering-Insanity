import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Koolkev246
 * @version 1.0.0
 */
public class skull extends titleelements

{private GreenfootImage skull=new GreenfootImage("IMG_0675.JPG.png");

    private int transparent;
    public skull()
    {transparent=0;
        setImage(skull);
    }
    /**
     * Act - do whatever the skull wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {if (transparent<255)
        {
        transparent++;}
        skull.setTransparency(transparent);
        if (getxy==false)
        {
            x=getX();
        y=getY();
        getxy=true;
        }
        counter++;
        if (counter<=loop/2)
        {
        this.setLocation(x,y++);
    }
        else if (counter<=loop)
        {this.setLocation(x,y--);}
        else
        {
    counter=0;
}
}
}
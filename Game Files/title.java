import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Kevin
 * @version 1.0.0
 */
public class title extends titleelements

{private GreenfootImage title=new GreenfootImage("triggeringinsanity.png");
    
    public title()
    {transparent=0;
        setImage(title);
    }
    /**
     * Act - do whatever the title wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {if (transparent<255)
        {
        transparent++;}
        counter++;
        title.setTransparency(transparent);
        if (getxy==false)
        {
            x=getX();
        y=getY();
        getxy=true;
        }
        
        if (counter<=loop/2)
        {
        this.setLocation(x,y--);
    }
        else if (counter<=loop)
        {this.setLocation(x,y++);}
        else
        {
    counter=0;
}
}
}

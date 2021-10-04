import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Kevin
 * @version 1.0.0
 */
public class rightin extends titleelements

{private GreenfootImage leftneko=new GreenfootImage("right neko.png");
    
    private boolean getxy=false;
    public rightin()
    {
        setImage(leftneko);
    }
    /**
     * Act - do whatever the leftfadein wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {counter++;
       
        if (getxy==false)
        {
            x=getX();
        y=getY();
        getxy=true;
        }
        if (counter>=850&&counter<=890)
        {
        if (x>640)
       x-=20;
        this.setLocation(x,getY());}
    }

        


}

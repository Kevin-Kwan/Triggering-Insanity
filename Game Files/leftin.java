import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Koolkev246
 * @version 1.0.0
 */
public class leftin extends titleelements

{private GreenfootImage leftneko=new GreenfootImage("leftneko.png");
    private int x,y;
    private int counter=0;
    private int loop=30;
    private boolean getxy=false;
    public leftin()
    {
        setImage(leftneko);
    }
    /**
     * Act - do whatever the leftfadein wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {if (getxy==false)
        {
            x=getX();
        y=getY();
        getxy=true;
        }
        if (x<640)
       x+=20;
        this.setLocation(x,getY());}

        


}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */
public class lightning extends enemy
{
    private static GreenfootImage lightning = new GreenfootImage("lightning.png");
    private boolean destruct=true;
    private boolean triggered=false;
    private int xvel,yvel;
    private Challenger player=null;
    private boolean boundset;
    private boolean hastrigger=false;
    public lightning()
    {
        setSkin("lightning.png");
        hastrigger=true;
        setHp(1);
    }
    public lightning(boolean cannotdie)
    {
        setSkin("lightning.png");
        hastrigger=true;
        destruct=cannotdie;setHp(1);
    }
public lightning(int xvel,int yvel,boolean cannotdie)
{
        setVelocityY(yvel);
        setVelocityX(xvel);
       hastrigger=false;
       destruct=cannotdie;setHp(1);
}
    
    public void act()
    {if (getWorld()!=null)
        {
        destroyBullets(destruct);
        hurt();
        checkBoundaries();}
        
if (hastrigger==false)
 move();
        }
        public void checkBoundaries()
        {if (getWorld()!=null)
            if (getX()<2||getX()>1278||getY()<2||getY()>718)
            getWorld().removeObject(this);
        }
        }



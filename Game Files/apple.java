import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */
public class apple extends enemy
{
    private static GreenfootImage apple = new GreenfootImage("apple.png");
    private boolean destruct=false;
    private boolean triggered=false;
    private int xvel,yvel;
    private Challenger player=null;
    private boolean boundset;
    private boolean hastrigger=false;
    public apple()
    {
        setSkin("apple.png");
        hastrigger=true;
        setHp(1);
    }
    public apple(boolean cannotdie)
    {
        setSkin("apple.png");
        hastrigger=true;
        destruct=cannotdie;setHp(1);
    }
public apple(int xvel,int yvel,boolean cannotdie)
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



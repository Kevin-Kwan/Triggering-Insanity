import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Koolkev246 a.k.a Kevin Kwan
 * @version 1.0.0
 */
public class movinghazard extends enemy
{
    private boolean destruct=true;
private static double speed = 8;
private int xpos;
private int ypos;
public int xxspeed;
public int yyspeed;
private int ttime;
private int starttime=0;
private Challenger playerOn = null;
public boolean goingoneway=true;
public boolean twodirection=true;

    public movinghazard(String block, int xspeed, int yspeed, int time, boolean comeback)
    {

        xxspeed=xspeed;
        yyspeed=yspeed;
        ttime=time;
        setSkin(block);
        twodirection=comeback;
}
        // Add your action code here.
      public void act()
      {
          destroyBullets(destruct);
          checkTouching();
       if (twodirection)
       {
          if (starttime<=ttime/2)
          {goingoneway=true;
            setVelocityX(xxspeed);
                setVelocityY(yyspeed);
    move();
    starttime++;
        }
        else if (starttime<=ttime)
        {goingoneway=false;
            
            setVelocityX(-xxspeed);
                setVelocityY(-yyspeed);
    move();
    starttime++;
        }
        
        else
        {goingoneway=true;
           starttime=0;
        }}
        else
        {
            if (starttime<ttime)
          {goingoneway=true;
            setVelocityX(xxspeed);
                setVelocityY(yyspeed);
    move();
    starttime++;
        }
    }

    
           // setLocation(getX() + direction, getY()); // direction being specified
// check to see if player is on 'this' platform

if (this.isTouching(Challenger.class))
{
    WorldsHandler.onhaz=this;
}
else
{
    WorldsHandler.onhaz=null;
}
if ((this.equals(((WorldsHandler) getWorld()).onPlatform))&&(((WorldsHandler) getWorld()).player!=null))
{ // if so, move the player
    Challenger playerOn = ((WorldsHandler) getWorld()).player;
    
    if (goingoneway)
    {
    playerOn.setLocation(playerOn.getX() + xxspeed, playerOn.getY()+yyspeed);

}
else
playerOn.setLocation(playerOn.getX() - xxspeed, playerOn.getY()-yyspeed);
}
        }
        public void setSkin(String skin)
        {
            setImage(skin);
        }
        public boolean checkTouching()
    {
        if (isTouching(Challenger.class))
        {
            return true;
            
        }
        else
        {
        return false;
    }
    
}
public void setPlayerOn(Challenger player)
{
    playerOn = player;
}
    }



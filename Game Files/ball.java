import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Koolkev246 a.k.a Kevin Kwan
 * @version 1.0.0
 */
public class ball extends enemy
{private boolean destruct=true;
    private int i=0;
        public ball()
    {
  setSkin("shield_3.png");
}
public ball(int xvel,int yvel,boolean cannotdie)
{setSkin("shield_3.png");
    setVelocityY(yvel);
        setVelocityX(xvel);
     
       destruct=cannotdie;
       setHp(10);
}
public void act()
{
    hurt();
    destroyBullets(destruct);
    setRotation(i);
    i+=(getVelocityX()+getVelocityY());
    move();
    if (this.getWorld()!=null)
    {
    checkBoundaries();
}
}
public int rotate()
{
    return getRotation();
}
public void doscale(int x,int y)
{GreenfootImage image=getImage();
    image.scale(x,y);
    setImage(image);
}
}

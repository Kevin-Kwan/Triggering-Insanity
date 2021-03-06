import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Koolkev246 a.k.a Kevin Kwan
 * @version 1.0.0
 */
public class mirrorblock extends hazard
{
        public mirrorblock(String blocktype)
    {
setSkin(blocktype);
}
public void act()
{
hurt();
    LeftBullet bull1=(LeftBullet) getOneTouchedObject(LeftBullet.class);
    RightBullet bull2=(RightBullet) getOneTouchedObject(RightBullet.class);
    if (touch(LeftBullet.class))
    {
    bull1=bull1;
    getWorld().addObject(new RightBullet(), getX()+32, getY());}
    getWorld().removeObject(bull1);
    
    if (touch(RightBullet.class)){
    bull2=bull2;
    getWorld().addObject(new LeftBullet(), getX()-32, getY());}
    getWorld().removeObject(bull2);

}
}


import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Koolkev246 a.k.a Kevin Kwan
 * @version 1.0.0
 */
public class killerblock extends enemy
{
    private static GreenfootImage killerblock = new GreenfootImage("killerblock.png");
    private static final double speed = 8;
    private boolean destruct=true;
    public killerblock()
    {
        setSkin("killerblock.png");
    }
    public void act()
    {
        destroyBullets(destruct);
    }
    public void movement()
    {
    }
    /**
     * Act - do whatever the CopyOfmoon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
}

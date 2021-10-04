import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */
public class bird extends enemy
{
    private static GreenfootImage[] flapRightImages;
    private static GreenfootImage[] flapLeftImages;
    private static boolean facingLeft=false;
    private static final double speed = 8;
    private Animation flapLeft;
    private Animation flapRight;
    private boolean destruct=false;
    public bird()
    {
    }
    public void act()
    {
        destroyBullets(destruct);
    }
        public static void bringImages()
        {
        }
        public void movement()
        {
        }
    /**
     * Act - do whatever the bird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
}

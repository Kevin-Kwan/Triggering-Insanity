import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */
public class moon extends enemy
{
    private static GreenfootImage[] moonImages;
    private boolean destruct=false;
    private int piccount=5;
    private static double speed = 8;
    public moon()
    {
  setImage(new GreenfootImage("moon1.png"));
          setHp(100);
            }
            
    
    public void act()
    {
destroyBullets(destruct);
        hurt();
        checkBoundaries();
        //for loop to count num of bullets as healht
    }
        
    }

    /**
     * Act - do whatever the moon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    


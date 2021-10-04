import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */
public class door extends Actor
{private static GreenfootImage[] doorOpen;
    private Animation openingDoor;
    

    public void act() 
    {
        if(isTouching(Challenger.class))
            
           nextLevel();
    }    
     public static void bringImages()
        {
        }
    public void nextLevel()
    {if (getWorld() instanceof Experimental)
            {
                Greenfoot.setWorld(new Level1());
            }
        if (getWorld() instanceof Tutorial)
            {
                Greenfoot.setWorld(new Experimental());
            }
        if (getWorld() instanceof Level1)
            {
               Greenfoot.setWorld(new Disco());
            }
            if (getWorld() instanceof Disco)
            {
               Greenfoot.setWorld(new Patience());
            }
      if (getWorld() instanceof Patience)
            {
               Greenfoot.setWorld(new EndScreen());
            }
            
    }
}

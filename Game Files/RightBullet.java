import greenfoot.*;
/**
 * 
 * @author Koolkev246 a.k.a Kevin Kwan
 * @version 1.0.0
 */
public class RightBullet extends hazard
{
private songPlayer shoot=new songPlayer("bruh.mp3");

   public void act()
   {hurt();
       {
       setLocation(getX() + 15, getY());
        checkBoundaries();
    }
    
   }
   
   
    }
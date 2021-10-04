import greenfoot.*;
/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */
public class LeftBullet extends hazard
{

   public void act()
   {hurt();
       setLocation(getX() - 15, getY());
       checkBoundaries();
   }
   
   
 
}

import greenfoot.*;
/**
 * 
 * @author Koolkev246 a.k.a Kevin Kwan
 * @version 1.0.0
 */
public class block extends moving
{
    private boolean destruct=true;
    public block(String image)
    {
        setSkin(image);
}

        // Add your action code here.
      public void act()
      {
          destroyBullets(destruct);
      
        }
       
}

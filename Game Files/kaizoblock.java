import greenfoot.*; 
/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */

public class kaizoblock extends moving
{
    private boolean destruct=true;
    private String blocktype;
    public kaizoblock(String whatappears)
    {
        blocktype=whatappears;
}
        // Add your action code here.
      public void act()
      {
          destroyBullets(destruct);
          checkTouching();
        }
        
        public void checkTouching()
    {
    if (isTouching(Challenger.class))
        {
            setSkin(blocktype);
            
        
}

    }

}

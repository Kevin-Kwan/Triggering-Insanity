import greenfoot.*; 
/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */
public class invisblock extends moving
{
    private boolean destruct=true;
    public invisblock()
    {
}
        // Add your action code here.
      public void act()
      {
          destroyBullets(destruct);

        }
        
        public void checkTouching()
    {
    if (isTouching(Challenger.class))
        {
            setSkin("block.png");
            
        
}

    }

}

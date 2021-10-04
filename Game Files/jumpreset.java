import greenfoot.*;
/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */
public class jumpreset extends Platform
{private Challenger player=null;

    public void act() 
    {
        if (this.isTouching(Challenger.class))
        {
        player=(Challenger) getWorld().getObjects(Challenger.class).get(0);
        player.doubleJump=0;
        getWorld().removeObject(this);}
    }    
}

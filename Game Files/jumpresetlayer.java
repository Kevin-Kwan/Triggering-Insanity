import greenfoot.*;  
/**
 * 
 * @author Koolkev246 a.k.a Kevin Kwan
 * @version 1.0.0
 */
public class jumpresetlayer extends moving
{private Challenger player=null;
    /**
     * Act - do whatever the jumpresetlayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public jumpresetlayer(int rotate)
    {GreenfootImage image=getImage();

        
        setImage(image);
    }
    public void act() 
    {
        if (this.isTouching(Challenger.class))
        {
        player=(Challenger) getWorld().getObjects(Challenger.class).get(0);
        player.doubleJump=0;
        }
    }    
}

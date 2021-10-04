import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */
public class Blood extends SmoothMover
{
    private Vector gravity = new Vector(90, 1.5);
    private int force = 15;
    
    public Blood()
    {
        int direction = Greenfoot.getRandomNumber(360);
        int speed = Greenfoot.getRandomNumber(force);
        increaseSpeed( new Vector(direction, speed));
        
        // random image size
        GreenfootImage img = getImage();
        int width = 4;
        int height = 4;
        img.scale (width, height);
        
        this.setRotation(Greenfoot.getRandomNumber(360));
    }
    
    /**
     * Act - do whatever the Debris wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void syncObject()
{
    Actor actor = getOneIntersectingObject(movingblock.class);
    if (actor != null)
    {
        actor.setLocation(getX(), getY());
        actor.setRotation(getRotation());
    }
}
    public void act() 
    {
        increaseSpeed(gravity);
        movingblock plat=(movingblock) getOneTouchedObject(movingblock.class);
        if (touch(Platform.class)||touch(moving.class)||touch(block.class)||touch(hazard.class)||this.isAtEdge())
        {if (touch(movingblock.class))
            {plat=plat;
                    if (plat.goingoneway)
    {
    setLocation(getX() + plat.xxspeed, getY()+plat.yyspeed);

}
else
{
setLocation(getX() - plat.xxspeed, getY()-plat.yyspeed);
}}
            
            else
            {
            force=0;
        gravity=new Vector(0,0);
        stopMove();
        
    }
    }else
        move();
    }    
}

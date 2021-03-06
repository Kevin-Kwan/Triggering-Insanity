import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * This class contains two methods for pixel-perfect collision-detection
 * 
 * @author (Busch2207 (Moritz L.)) 
 * @version (09.11.2013)
 */
public class SmoothMover extends Collision
{
    private Vector speed = new Vector();
    private Challenger player;
    private double x = 0;
    private double y = 0;

    public SmoothMover()
    {
    }
    
    /**
     * Create new thing initialised with given speed.
     */
    public SmoothMover(Vector speed)
    {
        this.speed = speed;
    }
    public void setLocation(double x, double y)
    {
        this.x = x;
        this.y = y;
        super.setLocation((int) x, (int) y);
    }

    public void setLocation(int x, int y)
    {
        setLocation((double) x, (double) y);
    }

    /**
     * Move forward one step.
     */
    public void move() 
    {
        x = x+ speed.getX();
        y =y + speed.getY();
        
        if (outOfWorld()) {
           setLocation(x, y);
        }
        else {
            setLocation(x, y);
        }
    }
    public void stopMove()
    {
        setLocation(x,y);

    }
    
    private boolean outOfWorld()
    {
        return    (x >= getWorld().getWidth())
               || (x < 0) 
               || (y >= getWorld().getHeight())
               || (y < 0) ;
    }
    
    /**
     * Increase the speed with the given vector.
     */
    public void increaseSpeed(Vector s) 
    {
        speed.add(s);
    }
    
    /**
     * Return the current speed.
     */
    public Vector getSpeed() 
    {
        return speed;
    }
}

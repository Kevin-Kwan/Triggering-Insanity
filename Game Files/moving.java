import greenfoot.*; 
/**
 * 
 * @author Koolkev246 a.k.a Kevin Kwan
 * @version 1.0.0
 */
public abstract class moving extends Platform
{
    private double x = 0;
    private double y = 0;
    private double velocityX; // in pixels per act() call
    private double velocityY; // in pixels per act() call
    private Animation anim;
public static songPlayer sung=new songPlayer("Circus - Theme Song.mp3");
    /**
     * Default constructor sets velocity to 0.0.
     */
    public moving()
    {
    
}

    public moving(double newVelocityX, double newVelocityY)
    {
        velocityX = newVelocityX;
        velocityY = newVelocityY;
    }

    public void move()
    {
        setLocation(x + velocityX, y + velocityY);
        if (anim != null)
        {
            anim.update();
            setImage(anim.getImage());
        }
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

  
    public double getExactX()
    {
        return x;
    }

  
    public double getExactY()
    {
        return y;
    }

 
    public double getVelocityX()
    {
        return velocityX;
    }

 
    public double getVelocityY()
    {
        return velocityY;
    }

  
    public void setVelocityX(double newvelocityX)
    {
        velocityX = newvelocityX;
    }

    
    public void setVelocityY(double newVelocityY)
    {
        velocityY = newVelocityY;
    }

 
    public void setAnimation(Animation newAnim)
    {
        anim = newAnim;
    }

  
    public Animation getAnimation()
    {
        return anim;
    }


    public int getHeight()
    {
        return getImage().getHeight();
    }

  
    public int getWidth()
    {
        return getImage().getWidth();
    }
   }

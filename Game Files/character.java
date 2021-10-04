import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A smooth moving player superclass with animation support.
 *
 * @author Kevin Kwan
 * @version 1.0.0
 */
public abstract class character extends Collision
{
    private double x = 0;
    private double y = 0;
    private double velocityX; // in pixels per act() call
    private double velocityY; // in pixels per act() call
    private Animation anim;

    /**
     * Default constructor sets velocity to 0.0.
     */
    public character()
    {
    }

    /**
     
     *
     * @param newVelocityX The x component of the velocity.
     * @param newVelocityY The y component of the velocity.
     */
    public character(double newVelocityX, double newVelocityY)
    {
        velocityX = newVelocityX;
        velocityY = newVelocityY;
    }

    
    /**
     * Move based on velocity.
     */
    public void move()
    {
        setLocation(x + velocityX, y + velocityY);
        if (anim != null)
        {
            anim.update();
            setImage(anim.getImage());
        }
    }

    /**
     * Allows precise tracking of the location and eventually calls
     * the built-in 'setLocation' method of Actor.
     *
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     */
    public void setLocation(double x, double y)
    {
        this.x = x;
        this.y = y;
        super.setLocation((int) x, (int) y);
    }

    /**
     * Override the default 'setLocation' method to keep our coordinates
     * up-to-date.
     *
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     */
    public void setLocation(int x, int y)
    {
        setLocation((double) x, (double) y);
    }

    /**
     * Returns the double precision value of the x-location.
     *
     * @return The double precision value of the x-location
     */
    public double getExactX()
    {
        return x;
    }

    /**
     * Returns the double precision value of the y-location.
     *
     * @return The double precision value of the y-location
     */
    public double getExactY()
    {
        return y;
    }

    /**
     * Gets the horizontal velocity of this Sprite in
     * pixels per act() call.
     *
     * @return The x horizontal velocity of this Sprite.
     */
    public double getVelocityX()
    {
        return velocityX;
    }

    /**
     * Gets the vertical velocity of this Sprite in
     * pixels per act() call.
     *
     * @return The y velocity of this Sprite.
     */
    public double getVelocityY()
    {
        return velocityY;
    }

    /**
     * Sets the horizontal velocity of this Sprite in
     * pixels per act() call.
     *
     * @param newvelocityX The new x velocity
     */
    public void setVelocityX(double newvelocityX)
    {
        velocityX = newvelocityX;
    }

    /**
     * Sets the vertical velocity of this Sprite in
     * pixels per act() call.
     *
     * @param newVelocityY The new y velocity
     */
    public void setVelocityY(double newVelocityY)
    {
        velocityY = newVelocityY;
    }

    /**
     * Sets the Animation to play for this Sprite.
     *
     * @param newAnim The default Animation for this sprite.
     */
    public void setAnimation(Animation newAnim)
    {
        anim = newAnim;
    }

    /**
     * Returns this Sprite's current animation.
     *
     * @return The current animation.
     */
    public Animation getAnimation()
    {
        return anim;
    }

    /**
     * Returns the height of this Sprite's image.
     *
     * @return Height of the current image.
     */
    public int getHeight()
    {
        return getImage().getHeight();
    }

    /**
     * Returns the width of this Sprite's image.
     *
     * @return Width of the current image.
     */
    public int getWidth()
    {
        return getImage().getWidth();
    }
}

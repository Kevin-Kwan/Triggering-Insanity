import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */
public class speechbubbles extends textmaking
{
    /**
     * Act - do whatever the text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public speechbubbles(String text, String font,int xsize, int ysize, int x,int y,int z,int xx,int yy,int zz, boolean bold, boolean italic, int fontsize, int numlines)
    
        {      GreenfootImage image = new GreenfootImage(xsize,ysize);
           image.setColor(new Color(xx,yy,zz));
           image.fill();
           image.setTransparency(180);
image.setFont(new Font(font,bold,italic,(int)(fontsize)));
image.setColor(new Color(x,y,z));
image.drawString(text,0,(int)(image.getHeight()/numlines));
setImage(image);
    }
  
    public void act() 
    {if (this!=null)
        if (isTouching(Challenger.class)==false)
        {
            getWorld().removeObject(this);
    }    
}}

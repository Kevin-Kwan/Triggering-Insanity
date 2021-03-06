import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Koolkev246 a.k.a Kevin Kwan
 * @version 1.0.0
 */
public class makecoloredtextnofill extends textmaking
{
    /**
     * Act - do whatever the text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public makecoloredtextnofill(String text, String font,int xsize, int ysize, int x,int y,int z, boolean bold, boolean italic, int fontsize)
    
        {        GreenfootImage image = new GreenfootImage(xsize,ysize);
image.setFont(new Font(font,bold,italic,(int)(fontsize)));
image.setColor(new Color(x,y,z));
image.drawString(text,0,(int)(image.getHeight()*0.5));
setImage(image);
    }
    public void act() 
    {
        // Add your action code here.
    }    
}

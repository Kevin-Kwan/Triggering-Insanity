import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */
public class makecoloredtext extends textmaking
{
    /**
     * Act - do whatever the text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public makecoloredtext(String text, String font,int xsize, int ysize, int x,int y,int z, int xx,int yy,int zz, boolean bold, boolean italic, int fontsize)
    
        {      GreenfootImage image = new GreenfootImage(xsize,ysize);
           image.setColor(new Color(xx,yy,zz));
           image.fill();
image.setFont(new Font(font,bold,italic,(int)(fontsize)));
image.setColor(new Color(x,y,z));
image.drawString(text,0,(int)(image.getHeight()*0.5));
setImage(image);
    }
    public makecoloredtext()
    {
//       getBackground().drawImage(new makecoloredtext().createTheText("hi"+timer/60,100,100,"Courier New",false,false,10),400,400);

    }
    public void act() 
    {
}}

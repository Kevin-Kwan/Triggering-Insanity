import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color.*;
/**
 * 
 * @author Koolkev246 a.k.a Kevin Kwan
 * @version 1.0.0
 */
public class sign extends Platform
{

    private String text;
    private int xsize;
    private int ysize;
    private int fontsize;
    private speechbubbles speech=null;
    private int numlines;
    private String font;
    /**
     * Act - do whatever the sign wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public sign(String text, int thexsize, int theysize, int thefontsize, int numlines, String font) {
       this.text=text;
       xsize=thexsize;
       ysize=theysize;
       fontsize=thefontsize;
       this.numlines=numlines;
       this.font=font;
    }
    public void act() 
    {speech=new speechbubbles(text,font,xsize,ysize,0,0,0,255,255,255,true,false,fontsize,numlines);
       Actor signtouch=getOneIntersectingObject(Challenger.class);
        if (signtouch==null)
        {
          getWorld().removeObject(speech);
        }
        else
        {
        getWorld().addObject(speech,getX(),getY()-ysize/2-32);
    }
}}

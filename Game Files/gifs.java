import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */
public class gifs extends Actor
{ private String img;
    private GifImage gif;
    public gifs(String img)
   {
       
    {
        this.img = img;
        gif = new GifImage( img );
    }}
    public void act()
    {
        setImage(gif.getCurrentImage() );
    }

    
}
   
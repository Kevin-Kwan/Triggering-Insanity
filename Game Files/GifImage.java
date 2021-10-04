import greenfoot.*;
/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */
public class GifImage  
{
    private String img;
    public GifImage( String img )
    {
        this.img = img;
    }
    public GreenfootImage getCurrentImage()
    {
        return new GreenfootImage( img );
    }
}
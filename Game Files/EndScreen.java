import greenfoot.*;
/**
 * 
 * @author Koolkev246 a.k.a Kevin Kwan
 * @version 1.0.0
 */
public class EndScreen extends World
{
 private GreenfootImage back=new GreenfootImage("wallhaven.png");
private int counter;
private int transparent;
private int duration;
private boolean mute;
 private static songPlayer sung=new songPlayer("Edge of Infinity (Minnesota Remix).mp3");
    public EndScreen()
    {
        super(1280, 720, 1);
       WorldsHandler.stopSounds();
        enemy.ClownStop();
        EndScreen.mute();
        sung.setLoud(30);
sung.playSong();


        setBackground(back);
        addObject(new end(),640,360);

        addObject(new title(),640,380);
       addObject(new skull(),640,350);
       addObject(new front(),640,360);
    }
 
    public void act()
    {counter++;
        if (counter==360)
        {
             addObject(new gameby(),640,360);
        }
if(Greenfoot.isKeyDown("p")){
     mute=true;
     WorldsHandler.stopSounds();
    }
if(Greenfoot.isKeyDown("l")){
     mute=false;
    }
      muteHandler();
      
      
      if (Greenfoot.getKey()=="space")
        {
        Greenfoot.setWorld(new TitleScreen());
    sung.stopSong();
    }

       
    }
    public static void mute()
    {
        sung.stopSong();
    }
    public void muteHandler()
{
    if (mute==true)
        {WorldsHandler.stopSounds();
            sung.stopSong();
        }
        else
        {
            sung.playSong();
        }
}
}

import greenfoot.*;
/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */
public class TitleScreen extends World
{
 private GreenfootImage back=new GreenfootImage("startbackground.png");
private int counter;
private int transparent;
private int duration;
public static boolean mute=false;
 private static songPlayer sung=new songPlayer("Edge of Infinity (Minnesota Remix).mp3");
    public TitleScreen()
    {
        super(1280, 720, 1);
        Greenfoot.start();
        Greenfoot.setSpeed(50);
       WorldsHandler.stopSounds();
        enemy.ClownStop();
        TitleScreen.mute();
        sung.setLoud(30);
sung.playSong();
        back.scale(1280,720);
        setBackground(back);
        addObject(new pressspace(),640,360);
        if (checkExistenceRight()==false)
        {
        addObject(new rightin(),1200,360);
    }
        addObject(new title(),640,380);
       addObject(new skull(),640,350);
       addObject(new front(),640,360);
       
    }
 
    public void act()
    {counter++;
        if(Greenfoot.isKeyDown("p")){
     mute=true;
     WorldsHandler.stopSounds();
    }
if(Greenfoot.isKeyDown("l")){
     mute=false;
    }

      muteHandler();
      {if (Greenfoot.getKey()=="space")
        {
        Greenfoot.setWorld(new Tutorial());
    sung.stopSong();
    }
}
        if (counter==360)
        {
             addObject(new gameby(),640,360);
        }
        if (counter==690&&checkExistenceLeft()==false)
        {
            addObject(new leftin(),500,360);
        }

        if (counter==14460)
        {counter=0;
        }

    }
    public boolean checkExistenceLeft()
{if (getObjects(leftin.class).size()!=0)
    {
    return true;
}
else
{return false;
}
}
public boolean checkExistenceRight()
{if (getObjects(rightin.class).size()!=0)
    {
    return true;
}
else
{return false;
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
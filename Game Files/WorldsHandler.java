import greenfoot.*;  
import java.util.*;
/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */
public abstract class WorldsHandler extends World
{
    private door nextLevel=new door();
    public static Challenger player=null;
    public static boolean mute=false;
    public static Platform onPlatform = null;
    public static hazard onhaz = null;
    private static songPlayer elundiscore=new songPlayer("5fa29647-37d3-49ed-8bc2-07d0cae5aac4.mp3"),seven=new songPlayer("b3e0e78b-712b-4b76-bad7-4027d5118bd7.mp3"), uurr=new songPlayer("ee99880d-4489-46e8-afca-2a78827ce56b.mp3"), LLLLL=new songPlayer("06c0e28e-5d06-4d30-9e1d-a164b703b860.mp3"),sans=new songPlayer("Sans Park.mp3");
    private boolean seeboundaries=false;
    public static boolean goodsong=true;
    public static boolean godmode=false;
    // actors that show text
    Actor speedDisplay = new Actor(){}, fpsDisplay = new Actor(){};
    // arrow actors to be clicked on
    Actor arrowLeft = new Actor(){}, arrowRight = new Actor(){};
    // control fields
    boolean hasSet, hasBegun;
    // setting and counter fields
    int speed = 50, frames;
    
    public WorldsHandler()
    {    
        super(1280, 720, 1);
        Greenfoot.setSpeed(speed);
         showText("\u00a9 Kevin 2020",95,700);
         showText("Deaths: "+displayDeaths(),50,11);
        showText("Press [P] to Mute Music",1170,11);
        showText("Press [L] to Unmute Music",1157,27);
        showText("Press [O] to Change Death Music \n(Will Apply on Next Death)",1128,57);
        stopSounds();
        updateFPS(); // set initial image of fps text
        // add the four actors into the world
        addObject(fpsDisplay, 1230,705);
    }
        
       public void setDoor(int x, int y)
    {
         addObject(nextLevel, x, y);
    }
       public void setWorldBorder()
   {
       if (checkExistence()&&player.isAtEdge())
       dead();
    }
        public void background(String img)
    {
        GreenfootImage back=new GreenfootImage(img);

        back.scale(1280,720);
        setBackground(back);
    }
  public int displayDeaths()
  {
      return CountingDeaths.showDeaths();
     
    }
    public void killinarea(int x,int xx, int y, int yy)
    {if (withinArea(x,xx,y,yy))
 {
     dead();
    }
    }
public void spawnPlayer()
{Challenger.bringImages();
}
    public static void stopSounds()
{
     Level1.stopLevelSong();
     Experimental.stopLevelSong();
     Tutorial.stopLevelSong();
     Disco.stopLevelSong();
     Patience.stopLevelSong();
        TitleScreen.mute();
        hazard.ClownStop();
            elundiscore.stopSong();
    seven.stopSong();
    uurr.stopSong();
    LLLLL.stopSong();
            sans.stopSong();
}
public static boolean getMute()
{
    return mute;
}
public void deathProcess()
{
         if(checkExistence()==true)
        {
    killself();
respawn();}
    else
    {
        respawn();}
}
public void killself()
{
    if(Greenfoot.isKeyDown("k")&&
               player.isittouch()==false)
            {stopSounds();
            dead();
            
            
}
if (Greenfoot.isKeyDown("u"))
            {
                if (this instanceof Experimental)
            {
                Greenfoot.setWorld(new Level1());
            }
        if (this instanceof Tutorial)
            {
                Greenfoot.setWorld(new Experimental());
            }
        if (this instanceof Level1)
            {
               Greenfoot.setWorld(new Disco());
            }
            if (this instanceof Disco)
            {
               Greenfoot.setWorld(new Patience());
            }
      if (this instanceof Patience)
            {
               Greenfoot.setWorld(new EndScreen());
            }}
}
public void respawn()
{
  if(Greenfoot.isKeyDown("r"))
    {stopSounds();
        if (this instanceof Level1)
            {stopSounds();
                CountingDeaths.increaseDeath(); 
                Greenfoot.setWorld(new Level1());
            }
            if (this instanceof Tutorial)
            {stopSounds();
                CountingDeaths.increaseDeath(); 
                Greenfoot.setWorld(new Tutorial());
            }
            if (this instanceof Experimental)
            {stopSounds();
                CountingDeaths.increaseDeath(); 
                Greenfoot.setWorld(new Experimental());
            }
        if (this instanceof Disco)
            {stopSounds();
                CountingDeaths.increaseDeath(); 
                Greenfoot.setWorld(new Disco());
            }
        if (this instanceof Patience)
            {stopSounds();
                CountingDeaths.increaseDeath(); 
                Greenfoot.setWorld(new Patience());
            }
        }
    }
public void mutemusic()
{
 if(Greenfoot.isKeyDown("p")){
     mute=true;
     stopSounds();
    }
    if(Greenfoot.isKeyDown("o")){
     if (goodsong)
     {
         goodsong=false;
        }
        else
        goodsong=true;
    }
 if(Greenfoot.isKeyDown("l")){
     mute=false;
     if (this instanceof Level1)
            {Level1.playLevelSong();
            }
    if        (this instanceof Experimental)
            {Experimental.playLevelSong();
            }
    if (this instanceof Tutorial)
            {Tutorial.playLevelSong();
            }
    if (this instanceof Patience)
            {Patience.playLevelSong();
            }
if (this instanceof Disco)
            {Disco.playLevelSong();
            }
    }
}
public boolean checkExistence()
{if (getObjects(Challenger.class).size()!=0)
    {
    return true;
}
else
{return false;
}
}
public static void setDeathVolumes()
{
    sans.setLoud(60);
        elundiscore.setLoud(100);
    seven.setLoud(100);
    uurr.setLoud(100);
    LLLLL.setLoud(100);
}
public static void playDeathSongs()
{
    if (goodsong)
                 sans.playSong();
                 else{
        elundiscore.playSong();
    seven.playSong();
    uurr.playSong();
    LLLLL.playSong();}
}
public  boolean withinArea(int x,int xx,int y, int yy)
{if (seeboundaries==true)
    {
        addObject(new indicator(),x,y); //remove this later
    addObject(new indicator(),xx,y);
    addObject(new indicator(),x,yy);
    addObject(new indicator(),xx,yy);

}
    if (checkExistence()==true)
    {
    if ((player.getX()) >= x && player.getX() <= xx && player.getY() >= y && player.getY() <= yy)
        {
            return true;
            
            }
             }
    return false;
}
public void dead()
{stopSounds();
    if (this!=null)
    {
    stopSounds();
    setDeathVolumes();
        player.explode();
        if (WorldsHandler.getMute()==false)
             {stopSounds();
                 playDeathSongs();
                 
    }
                            this.removeObjects(getObjects(Challenger.class));
                                    this.addObject(new Gameover(), this.getWidth() / 2, this.getHeight() / 2);         
        }
      }     
      public void updateFPS()
    {
        fpsDisplay.setImage(new GreenfootImage("FPS: "+frames, 30, Color.BLACK, null));
    }
    public void fpsComplete()
    {
        
        // check for mouse clicks on arrow actors to change the scenario speed
        int d = 0; // field to hold any change in speed
        if (Greenfoot.mouseClicked(arrowLeft)) d--; // left arrow clicked sets change field to -1
        if (Greenfoot.mouseClicked(arrowRight)) d++; // right arrow clicked sets change field to 1
        if (d != 0 && speed+d > 0 && speed+d <= 100)
        { // change requested and speed will stay within range
            // reset frame counter and control fields
            frames = 0;
            hasSet = false;
            hasBegun = false;
            // change the speed
            speed += d;
            Greenfoot.setSpeed(speed);
            // update the display texts
            updateFPS();
        }
        // get current fractional part of seconds of system time (0 to 999 milliseconds)
        int millis = (int)(System.currentTimeMillis()%1000);
        // code to begin the timing
        if (!hasSet && !hasBegun)
        { // time has not begun and we are not set to begin
            if (millis > 100) hasSet = true; // we are set to begin if past first 1/10 of a second
            return;
        }
        if (hasSet && !hasBegun)
        { // time has not begun, but we are set to begin
            if (millis < 100) { hasBegun = true; hasSet = false; } // zero tick, unset and begin time
            return;
        }
        // code to run the timing
        frames++; // count this frame
        if (!hasSet && hasBegun)
        { // must wait for 1/10 of a second before looking for first 1/10 of a second again
            if (millis > 100) hasSet = true; // reset after 1/10 of a second past last tick
            return;
        }
        if (hasSet && hasBegun)
        { // looking for next first 1/10 of a second
            if (millis < 100)
            { // next tick
                hasSet = false; // not looking for tick
                updateFPS(); // update text display of fps actor
                frames = 0; // reset the frames counter
            }
        }
    }
        }


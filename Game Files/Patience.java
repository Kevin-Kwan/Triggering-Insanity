import greenfoot.*;
/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */
public class Patience extends WorldsHandler
{
    
    private int colorchangetimer=15;
    private static int counter=0;
    private static int testtime=0;
    private static int timer=17400;
    private makecoloredtextnofill center;
    private GreenfootImage pic = new GreenfootImage(1280, 720);
    private static songPlayer song=new songPlayer("moon hydrogen.mp3");
    private boolean added=false;
    private ball jumpover=new ball(-10,0,false);
            

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Patience()
    { 
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super();
        timer=17400;
        counter=testtime;
        stopSounds();
        song.setLoud(30);
        background("level2.jpg");
        showText("Deaths: "+displayDeaths(),50,11);
        showText("Press [P] to Mute Music",1170,11);
        showText("Press [L] to Unmute Music",1157,27);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {spawnPlayer();
        addObject(new Challenger(), 640, 520);
        player=(Challenger) getObjects(Challenger.class).get(0);
        
        for (int x = 16; x < getWidth(); x+=32)

            addObject(new block("invis.png"),x,559);
            center=new makecoloredtextnofill("Test your patience.","Courier New",1050,110,255,255,255,false,false,90);
        addObject(center,640,360);
        showText("Time Left: "+(timer/60)+" seconds",640,400);
    }

    public void act()
    {
        counter++;
        if (counter%60==0&&counter<=17400)
        {timer-=60;
             showText("Time Left: "+(timer/60)+" seconds",640,400);
}
       if (checkExistence())
       {
        if (counter>timer&&added==false)
        {removeObject(center);
            center=new makecoloredtextnofill("Well done.","Courier New",525,105,255,255,255,false,false,90);
            addObject(center,640,360);
             door door = new door();
             addObject(door, 640,450);
             jumpover=new ball(-10,0,false);
        jumpover.doscale(140,140);
        addObject(jumpover,1279,485);
        jumpover=new ball(10,0,false);
        jumpover.doscale(140,140);
        addObject(jumpover,1,485);
            added=true;
        }
 if (withinArea(0,1280,532,720))
 {
     dead();
    }
    setWorldBorder();
} 
            
        muteHandler();
        if(checkExistence()==true)
        {
    killself();
respawn();}
    else
    {
        respawn();}
        mutemusic();
fpsComplete();
    }

    
 public static void stopLevelSong()
    {
        song.stopSong();
    }

    public static void playLevelSong()
    {
        song.playSong();
    }
    public void muteHandler()
{
    if (mute==true)
        {stopSounds();
            song.stopSong();
        }
        else
        {
            song.playSong();
        }
}
   
}


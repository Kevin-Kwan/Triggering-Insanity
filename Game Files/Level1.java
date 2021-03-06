
import greenfoot.*;
/**
 * 
 * @author Koolkev246 a.k.a Kevin Kwan
 * @version 1.0.0
 */
public class Level1 extends WorldsHandler
{
    private int counter=0;
    private ball jumpover=new ball(-10,0,false);
    private static songPlayer song=new songPlayer("Looptroop - Dont Hate The Player (Instrumental).mp3");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Level1()
    { 
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super();
       
        counter=0;
        stopSounds();
        song.setLoud(50);
        
        background("d8lb5c6-bcc12231-656f-4a30-9f3a-4cc004706978.png");

        
       


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
    {

        for (int x = 16; x < getWidth(); x+=32)
            addObject(new block("grasslayer.png"),x,559);
        for (int y = 0; y < getWidth(); y+=32)
        {addObject(new block("block.png"),0,y);
            addObject(new jumpresetlayer(90),0,y);
        }
        for (int y = 96; y < 550; y+=32)
            addObject(new block("block.png"),128,y);
        for (int y = 0; y < 450; y+=32)
            addObject(new block("block.png"),256,y);

        spawnPlayer();
        addObject(new Challenger(), 50,515);
        player=(Challenger) getObjects(Challenger.class).get(0);
        door door = new door();
        addObject(door, 1265,520);
        Platform movingplat1=new movingblock("block.png",0,1,900,true);
        addObject(movingplat1,160,96);
        Platform movingplat2=new movingblock("block.png",0,1,900,true);
        addObject(movingplat2,192,96);
        Platform movingplat3=new movingblock("block.png",0,1,900,true);
        addObject(movingplat3,224,96);

        spike spike = new spike(90);
        addObject(spike,160,128);
        spike spike1 = new spike(270);
        addObject(spike1,224,192);
        spike spike2 = new spike(90);
        addObject(spike2,160,256);
        spike spike3 = new spike(270);
        addObject(spike3,224,256+64);
        spike spike4 = new spike(90);
        addObject(spike4,160,256+64+64);
        spike spike5 = new spike(270);
        addObject(spike5,224,256+64+64+64);
        for (int i=320;i<1280;i+=90)
        {
            addObject(new spike(0),i,540);
        }
        spike spike18 = new spike(90);
        addObject(spike18,160,544);
    }

    public void act()
    {
        if (mute==true)
        {stopSounds();
            song.stopSong();
        }
        else
        {
            song.playSong();
        }
        if (checkExistence()==false)
        {
            song.stopSong();
        }
 if (withinArea(0,1280,532,720))
 {
     dead();
    }
    setWorldBorder();
        if (withinArea(320,1280,0,720))
        {counter++;
            if (counter==30)
            {
            jumpover=new ball(-10,0,false);
        jumpover.doscale(140,140);
        addObject(jumpover,1279,485);
    }
    if (counter==0)
    {
        if (counter==30)
            {
            jumpover=new ball(-10,0,false);
        jumpover.doscale(140,140);
        addObject(jumpover,1279,485);
    }}
    if (counter==120)
    {
        jumpover=new ball(-10,0,false);
            
        jumpover.doscale(140,140);
        addObject(jumpover,1279,485);
    }
    if (counter==120)
    {
        jumpover=new ball(-10,0,false);
            
        jumpover.doscale(140,140);
        addObject(jumpover,1279,485);
    }
    if (counter==240)
    {
        jumpover=new ball(-10,0,false);
            
        jumpover.doscale(140,140);
        addObject(jumpover,1279,485);
    }
        }

       
        
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


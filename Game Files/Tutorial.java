import greenfoot.*;
/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */
public class Tutorial extends WorldsHandler
{

    private static songPlayer song=new songPlayer("Foster The People - Best Friend (Wave Racer Remix).mp3");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Tutorial()
    { 
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super();
        
        
        stopSounds();
        song.setLoud(30);
        
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
        // addObject(new apple(),373,153);
        // addObject(new block("block.png"),100,100);
        // Platform movingplat1=new movingblock("block.png",0,1,100,true);
        // addObject(movingplat1,400,500);
        // Platform movingplat2=new movingblock("block.png",0,1,100,true);
        // addObject(movingplat2,550,500);
        // addObject(new door(),1200, 550);
        addObject(new makecoloredtextnofill("Nothing in this world\nis as it seems...","Courier New",375,200,0,0,0,false,false,30),361,124);
        for (int x = 16; x < getWidth(); x+=32)

            addObject(new block("grasslayer.png"),x,559);
        // addObject(mon,1200,5);
        // addObject(new spike(),575,400);

        //    door door2 = new door();
        //   addObject(door2,950,493);

        sign sign = new sign("Controls:\nUse [W] or [UP ARROW] to jump.\nDouble tap [W] or [UP ARROW] to double-jump.\nUse [A] or [LEFT ARROW] to move left.\nUse [D] or [RIGHT ARROW] to move right.\nUse [SPACE] to shoot. ", 500, 150,20,6,"Times New Roman");
        addObject(sign,272,540);
        sign sign1 = new sign("Objective: Reach the green door to beat the level.\nSimple, right?", 440, 50,20,3,"Times New Roman");
        addObject(sign1,650,443);
        //apple apple = new apple(-10, 10, 0, 720, 0, 15);
        //addObject(apple,652,60);
        spawnPlayer();
        addObject(new Challenger(), 1, 525);
        player=(Challenger) getObjects(Challenger.class).get(0);

        block block41 = new block("grass block.png");
        addObject(block41,665,475);
        block block42 = new block("grass block.png");
        addObject(block42,633,474);
        block42.setLocation(633,475);
        block block43 = new block("grass block.png");
        addObject(block43,812,288);
        block43.setLocation(756,345);
        block block44 = new block("grass block.png");
        addObject(block44,788,345);
        block block45 = new block("grass block.png");
        addObject(block45,999,333);
        block45.setLocation(999,345);
        door door = new door();
        addObject(door,998,301);
    }

    public void act()
        {
        muteHandler();
      
deathProcess();
 killinarea(0,1280,532,720);
    setWorldBorder();
       
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
        if (checkExistence()==false)
        {
            song.stopSong();
        }
}
}


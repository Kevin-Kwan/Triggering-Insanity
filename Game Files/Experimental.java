
import greenfoot.*;
/**
 * 
 * @author Koolkev246 a.k.a Kevin Kwan
 * @version 1.0.0
 */
public class Experimental extends WorldsHandler
{
    private moon mon=new moon();
    public static boolean moontriggered=false;
    private apple app;
    private apple apple2;
    public static boolean appletriggered=false;
    public static boolean appletriggered2=false;
private int pathcounter=0;

    private static songPlayer song=new songPlayer("Defqwop - Into the Ether.mp3");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Experimental()
    { 
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super();
        moontriggered=false;
        appletriggered=false;
appletriggered2=false;
        stopSounds();
        song.setLoud(30);
        background("d8lb5c6-bcc12231-656f-4a30-9f3a-4cc004706978.png");
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {spawnPlayer();

       Platform movingplat1=new movingblock("block.png",0,1,100,true);
        addObject(movingplat1,465,450);
       Platform movingplat2=new movingblock("block.png",1,0,100,true);
        addObject(movingplat2,497,450);
        for (int x = 16; x < getWidth(); x+=32)

            addObject(new block("grasslayer.png"),x,559);
        saw saw = new saw();
        addObject(saw,1131,492);
        door door = new door();
        addObject(door,1254,527);
        unfairblock unfairblock = new unfairblock("block.png");
        addObject(unfairblock,837,540);
        spike spike = new spike();
        addObject(spike,985,539);
        jumpreset jumpreset = new jumpreset();
        addObject(jumpreset,1037,473);
        jumpreset jumpreset2 = new jumpreset();
        addObject(jumpreset2,1092,416);
        jumpreset jumpreset3 = new jumpreset();
        addObject(jumpreset3,1163,381);
        jumpreset jumpreset4 = new jumpreset();
        addObject(jumpreset4,1023,411);
        jumpreset jumpreset5 = new jumpreset();
        addObject(jumpreset5,1102,347);
        jumpreset jumpreset6 = new jumpreset();
        addObject(jumpreset6,998,446);
        jumpreset.setLocation(1039,484);

        kaizoblock kaizoblock2 = new kaizoblock("block.png");
        addObject(kaizoblock2,644,348);
        kaizoblock kaizoblock3 = new kaizoblock("block.png");
        addObject(kaizoblock3,676,348);
        kaizoblock kaizoblock4 = new kaizoblock("block.png");
        addObject(kaizoblock4,708,348);
        addObject(mon,304,25);

        block block41 = new block("grass block.png");
        addObject(block41,417,352);
        block block40 = new block("grass block.png");
        addObject(block40,449,352);
        block block42 = new block("grass block.png");
        addObject(block42,520,352);
        block block39 = new block("grass block.png");
        addObject(block39,552,352);
        block block43 = new block("halfslab.png");
        addObject(block43,356,436);
        block block44 = new block("block.png");
        addObject(block44,606,448);
        image block45 = new image("tree.png");
        addObject(block45,790,483);

        apple apple = new apple();
        addObject(apple,764,461);
        apple2 = new apple();
        addObject(apple2,820,450);
        app=new apple();
        addObject(app,781,413);

       
        addObject(new Challenger(), 1, 100);
        player=(Challenger) getObjects(Challenger.class).get(0);
        sign sign = new sign("Those white dots reset your double-jump!", 275, 27, 15, 2, "Times New Roman");
        addObject(sign,921,538);

    }

    public void act()
    {
       muteHandler();
 killinarea(0,1280,532,720);
    setWorldBorder();
    
            appletriggers(320,700,400,450);
            appletriggers2(790,850,0,450);
            
             moontriggers(230,425,0,600);
        if (checkExistence()==true)
        {
        if (appletriggered)
        {
                app.setVelocityX(-30);
                app.move();
            }
            if (appletriggered2)
        {   
            
            
                apple2.setVelocityY(-30);
                apple2.move();
            }
        if (moontriggered&&checkExistence()==true)
        {   
            if (pathcounter<20)
            {
                mon.setVelocityY(25);
                mon.move();
                pathcounter++;
            }
            else if (pathcounter<28)
            {
                mon.setVelocityX(-20);
                mon.setVelocityY(0);
                mon.move();
                pathcounter++;
            }
            else if (pathcounter<100)
            {mon.setVelocityX(0);
                mon.setVelocityY(-25);
                mon.move();
                pathcounter++;
            }
        }
        killself();
respawn();
        }
           else
        
        
        
    {
        respawn();}
        mutemusic();
    fpsComplete();
    }

    

   



    
    public void moontriggers(int x,int y,int z, int xx)
    {
if ((moontriggered==false) )
        {
            if ((withinArea(x,y,z,xx)))
            {
                moontriggered=true;

            }
            
    }}

    public void appletriggers(int x,int y,int z, int xx)
    {
if ((appletriggered==false) )
        {
            if ((withinArea(x,y,z,xx)))
            {
                appletriggered=true;

            }
          

    }}
    public void appletriggers2(int x,int y,int z, int xx)
    {
if ((appletriggered2==false) )
        {
            if ((withinArea(x,y,z,xx)))
            {
                appletriggered2=true;

            }
           
    }
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


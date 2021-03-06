import greenfoot.*;
/**
 * 
 * @author Koolkev246 a.k.a Kevin Kwan
 * @version 1.0.0
 */
public class Disco extends WorldsHandler
{
    
    private int colorchangetimer=15;
    private static int counter=0;
    private static int testtime=0;
    private static int timer=1800;private static int countdown=1800;
    private makecoloredtextnofill center;
    private GreenfootImage pic = new GreenfootImage(1280, 720);
    private static songPlayer song=new songPlayer("Anzo - Moonbound.mp3");
    private boolean added=false;
    public Disco()
    { 
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super();
        timer=1800;
        countdown=1800;
        counter=testtime;
        stopSounds();
        song.setLoud(30);
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

            addObject(new block("block.png"),x,559);
            center=new makecoloredtextnofill("Survive.","Courier New",375,110,255,255,255,false,false,90);
        addObject(center,640,360);
        showText("Time Left: "+(countdown/60)+" seconds",640,559);
    }

    public void act()
    {
        counter++;
        fpsComplete();
       if (checkExistence())
       {
        if (counter%colorchangetimer==0)
        {
pic.setColor(new Color(Greenfoot.getRandomNumber(255 + 1), Greenfoot.getRandomNumber(255 + 1), Greenfoot.getRandomNumber(255 + 1)));
pic.fill();
setBackground(pic);
       
}
if (counter%20==0&&counter<=300)
{
applevolley();
//possible so far, hide on left side alternate sides
}
if (counter%60==0&&counter<=1800)
        {countdown-=60;
             showText("Time Left: "+(countdown/60)+" seconds",640,559);
}
if (counter==301)
{
    ball jumpover=new ball(-10,0,true);
        jumpover.doscale(140,140);
        addObject(jumpover,1279,485);
}
if (counter>=340&&counter%30==0&&counter<=600)
{lightningvolley();
}
       muteHandler();
        if (checkExistence()==false)
        {
            stopLevelSong();
        }
        if (counter>=660&&counter%45==0&&counter<=timer)
        {applehell();
        }
        if (counter>timer&&added==false)
        {removeObject(center);
            center=new makecoloredtextnofill("Damn...","Courier New",375,110,255,255,255,false,false,90);
            addObject(center,640,360);
             door door = new door();
             addObject(door, 1265,512);
            added=true;
        }
 if (withinArea(0,1280,532,720))
 {
     dead();
    }
    setWorldBorder();
} 
            
        
        if(checkExistence()==true)
        {
    killself();
respawn();}
    else
    {
        respawn();}
        mutemusic();

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
    public void applevolley()
    {
        apple apple = new apple(-20,0,false);
addObject(apple,1260,520);

apple apple1 = new apple(20,0,false);
addObject(apple1,20,520);

apple apple2=new apple(20,20,false);
addObject(apple2,2,2);

apple apple3=new apple(-20,20,false);
addObject(apple3,1278,2);

apple apple4=new apple(0,20,false);
addObject(apple4,640,2);

}
public void lightningvolley()
    {
        lightning light = new lightning(0,30,true);
addObject(light,player.getX(),5);
lightning light2=new lightning(0,30,true);
addObject(light2,Greenfoot.getRandomNumber(1280),5);
lightning light3=new lightning(0,30,true);
addObject(light3,Greenfoot.getRandomNumber(1280),5);
lightning light5=new lightning(0,30,true);
addObject(light5,Greenfoot.getRandomNumber(1280),5);
lightning light4=new lightning(0,30,true);
addObject(light4,Greenfoot.getRandomNumber(1280),5);
}
public void applehell()
{applevolley();
     apple app = new apple(15,0,false);
addObject(app,20,player.getY());
 apple app1 = new apple(-15,0,false);
addObject(app1,1260,player.getY());
 apple app2 = new apple(0,12,false);
addObject(app2,player.getX(),5);
apple app3 = new apple(0,12,false);
addObject(app3,Greenfoot.getRandomNumber(1280),5);
apple app4 = new apple(0,12,false);
addObject(app4,Greenfoot.getRandomNumber(1280),5);
}
    
}


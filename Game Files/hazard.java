import greenfoot.*; 
/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */
public class hazard extends Collision
{
    private static songPlayer elundiscore=new songPlayer("5fa29647-37d3-49ed-8bc2-07d0cae5aac4.mp3"),seven=new songPlayer("b3e0e78b-712b-4b76-bad7-4027d5118bd7.mp3"), uurr=new songPlayer("ee99880d-4489-46e8-afca-2a78827ce56b.mp3"), LLLLL=new songPlayer("06c0e28e-5d06-4d30-9e1d-a164b703b860.mp3"),sans=new songPlayer("Sans Park.mp3");
    private boolean goodsong=WorldsHandler.goodsong;
    public static Challenger player=null;
    private int hp=-1;
    public static songPlayer death=new songPlayer("death.mp3");
    public void checkBoundaries()
   {if (this.isAtEdge())
       
            getWorld().removeObject(this);

        }
    public boolean withinArea(int x,int xx,int y, int yy)
{
    if ((player.getX()) >= x && player.getX() <= xx && player.getY() >= y && player.getY() <= yy)
        {
            return true;
            
            }
            else
            {
            return false;
        }
}
   
public void setHp(int i)
{hp=i;
}
public static void ClownStop()
{
    elundiscore.stopSong();
    seven.stopSong();
    uurr.stopSong();
    LLLLL.stopSong();
}
    public void destroyBullets(boolean allow)
   {if(allow==false)
       {if(this.getWorld()!=null&&(isTouching(RightBullet.class)||isTouching(LeftBullet.class)))
          { hp--;
              removeTouching(RightBullet.class);
              removeTouching(LeftBullet.class);
        }
        if (hp==0)
        {death=new songPlayer("death.mp3");
            death.setLoud(30);
        death.playOnce();
           getWorld().removeObject(this);}
        }
        else
        {
       if(isTouching(RightBullet.class))
            
           removeTouching(RightBullet.class);
           if(isTouching(LeftBullet.class))
            
           removeTouching(LeftBullet.class);
       }
      
        }
    
    public void setSkin(String skin)
        {
            setImage(new GreenfootImage(skin));
        }
    
public void hurt()
    {if (WorldsHandler.godmode==false)
        {
        if(this.getWorld()!=null&&touch(Challenger.class))
            {
                player=(Challenger) getOneTouchedObject(Challenger.class);
player.explode();
        WorldsHandler.stopSounds();
        WorldsHandler.setDeathVolumes();
        if (WorldsHandler.getMute()==false)
             {
         WorldsHandler.playDeathSongs();
    }
            
                getWorld().removeObjects(getWorld().getObjects(Challenger.class));
                    
                getWorld().addObject(new Gameover(), getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            
               
        }}}
   
        
           

     
    }
   


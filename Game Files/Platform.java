import greenfoot.*;
/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */
public class Platform extends Collision
{

    public Platform(){
    
}
    public void destroyBullets(boolean allow)
   {
       
       if(isTouching(RightBullet.class))
            
           removeTouching(RightBullet.class);
           if(isTouching(LeftBullet.class))
            
           removeTouching(LeftBullet.class);
       }
   
   public void setSkin(String skin)
        {
            setImage(skin);
        }
    }

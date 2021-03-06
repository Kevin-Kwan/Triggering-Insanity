import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Koolkev246 a.k.a Kevin Kwan
 * @version 1.0.0
 */
public class spike extends hazard
{
private boolean destruct=true;
        public spike()
    {
  setSkin("spike.png");
}
public spike(int rotate)
    {
  setSkin("spike.png");
  GreenfootImage image=getImage();
  image.rotate(rotate);
  setImage(image);
}
public void act()
{
   hurt();
    destroyBullets(destruct);
}
}
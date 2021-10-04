import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */
public class saw extends hazard
{private boolean destruct=true;
    private int i=0;
        public saw()
    {
  setSkin("biggersaw.png");
}
public void act()
{
    hurt();
    destroyBullets(destruct);
    setRotation(i);
    i++;
    if (i>=360)
    {i=0;
    }
}
public int rotate()
{
    return getRotation();
}

}

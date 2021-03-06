import greenfoot.*;
/**
 * 
 * @author Koolkev246 a.k.a Kevin Kwan
 * @version 1.0.0
 */
public class CountingDeaths
{
    private static int deaths=0;
    public CountingDeaths()
{
    showDeaths();
}
public static int showDeaths()
{
    return deaths;
}
public static void increaseDeath()
{
    deaths++;
}
}

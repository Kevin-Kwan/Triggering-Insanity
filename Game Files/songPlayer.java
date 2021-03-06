import greenfoot.*;
/**
 * 
 * @author Koolkev246 a.k.a Kevin Kwan
 * @version 1.0.0
 */
public class songPlayer  
{
public GreenfootSound backgroundMusic;
private boolean playing;
    public songPlayer(String song)
    {
        backgroundMusic=new GreenfootSound(song);
        playing=false;
    }
    
    public void playOnce()
    {
        backgroundMusic.play();
        playing=true;
    }
    public void playSong()
    {
        backgroundMusic.playLoop();
    }
public void stopSong()
    {
        backgroundMusic.stop();
    }
    public void setLoud(int volume)
    {
    backgroundMusic.setVolume(volume);
}
}

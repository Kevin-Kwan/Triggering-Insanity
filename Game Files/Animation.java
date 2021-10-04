import greenfoot.*;
import java.util.ArrayList;
/**
 * 
 * @author Kevin Kwan
 * @version 1.0.0
 */
public class Animation
{
    public static int Default = 5; //default number of images that will be in the animation
    private ArrayList<GreenfootImage> images; // image sequence to go through
    private int actCount = -1;  // current count for act
    private int imgIndex = 0;   // current index in image list
    private int imageDuration = Default; // time per image

    /**
     * Constructs a new animation.
     * Creates an empty arraylist for animation (images not added yet).
     * ArrayList will store objects of type GreenfootImage.
     */
    public Animation()
    {
        images = new ArrayList<GreenfootImage>();
    }
    /**
     * Change presumed number of images that will be in the ArrayList.
     * 
     * @param i estimated time per image.
     */
public static void setDefault(int i)
{
    Default=i;
}
    /**
     * Add a new image frame to this Animation.
     *
     * @param img image to display.
     */
    public void addImage(GreenfootImage img)
    {
        images.add(img);
    }

    /**
     * Gets the current image in the sequence.
     *
     * @return Current image at index or null if there are no images in the ArrayList image.
     */
    public GreenfootImage getImage()
    {
        if (images.size() == 0)
        {
            return null;
        }
        else
        {
            return (images.get(imgIndex));
        }
    }

    /**
     * Decide/Calculate which image to display.
     * 
     */
    public void update()
    {
        if (images.size() > 1) //ArrayList images is at least 2 
        {
            actCount++;
            if (actCount >= images.size() * imageDuration)
            {
                actCount = 0;
            }
        }
        // Calculate the current image to display
        imgIndex = actCount / imageDuration;
    }

    /**
     * Returns true when an animation has finished.
     * Returns false if animation is not finished yet.
     *
     * @return true when finished; otherwise returns false.
     */
    public boolean isFinished()
    {
        if (actCount == images.size() * imageDuration - 1)
        {
            return true;
        }
        return false;
    }

    /**
     * Sets the current duration that each image is displayed.
     *
     * @param perImageCount Number of counts that every image is displayed.
     * The value must be greater than zero.
     */
    public void setImageDuration(int perImageCount)
    {
        if (perImageCount > 0)
        {
            imageDuration = perImageCount;
        }
    }

    /**
     * Returns the number of update() calls or frames that each image is displayed.
     *
     * @return Number of counts that every image is displayed.
     */
    public int getImageDuration()
    {
        return imageDuration;
    }

    /**
     * Returns the number of images displayed for this Animation.
     *
     * @return Number of images displayed for this Animation.
     */
    public int getImageCount()
    {
        return images.size();
    }

    /**
     * Cause the image sequence to start over.
     */
    public void reset()
    {
        actCount = -1;
    }
}

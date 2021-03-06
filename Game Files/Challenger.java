import greenfoot.*;
/**
 * 
 * @author Koolkev246 a.k.a Kevin Kwan
 * @version 1.0.0
 */
    public class Challenger extends character
    {
        private static final double speed = 6;
        private static int jumpforce = 16;
        private static final double gravity = 1.5;
        private static final int maxfall = 15;
        private boolean canJump = true;
        private static boolean facingLeft=false;
        private boolean inair=false;
        private static final int walkcount=5;
        private static final int idlecount=4;
        private static final int jumpcount=2;
        public int doubleJump=0;
        public int start=0;
        private int guncooldown=5;

        private static final int NUM_FRAGMENTS=100;
        public static songPlayer death=new songPlayer("death.mp3");
        public static songPlayer shoot=new songPlayer("AWP Shooting - CSGO Sound Effect.mp3");
        public static songPlayer jump=new songPlayer("click1.mp3");
       
    private static GreenfootImage[] runRightImages;
    private static GreenfootImage[] runLeftImages;
    private static GreenfootImage[] idleRightImages;
    private static GreenfootImage[] idleLeftImages;
    private static GreenfootImage[] jumpRightImages;
    private static GreenfootImage[] jumpLeftImages;
    private static GreenfootImage[] fallRightImages;
    private static GreenfootImage[] fallLeftImages;
    private Animation idleLeft;
    private Animation idleRight;
    private Animation jumpLeft;
    private Animation jumpRight;
    private Animation runLeft;
    private Animation runRight;
    private Animation fallLeft;
    private Animation fallRight;

    public Challenger()
    {
        bringImages();
        runRight = new Animation();
        runLeft = new Animation();
        idleRight=new Animation();
        jumpRight=new Animation();
        idleLeft=new Animation();
        jumpLeft=new Animation();
        fallLeft=new Animation();
        fallRight=new Animation();
        for (int i = 0; i < runRightImages.length; i++)
        {
            runRight.addImage(runRightImages[i]);
            runLeft.addImage(runLeftImages[i]);
        }
        for (int k = 0; k < idleRightImages.length; k++)
        {
            idleRight.addImage(idleRightImages[k]);
            idleLeft.addImage(idleLeftImages[k]);
        }
        for (int k = 0; k < jumpRightImages.length; k++)
        {
            jumpRight.addImage(jumpRightImages[k]);
            jumpLeft.addImage(jumpLeftImages[k]);
        }
        for (int m = 0; m < fallRightImages.length; m++)
        {
            fallRight.addImage(fallRightImages[m]);
            fallLeft.addImage(fallLeftImages[m]);
        }
        setAnimation(idleRight);
    }
    
public void act()
        {
            if (((WorldsHandler) getWorld()).player!=null)
            {
                checkUp();
            checkKeys();
            checkCollision();
            manageJumping();
            move();
            fireGun();
            
            if (isOnGround())
            {
                doubleJump=0;
            }
            
    {
        
        if (Greenfoot.isKeyDown("k")){
            explode();
        }
    }
        }
    }

    public void checkCollision()
    
    {
        
        checkPlatformAbove();
        checkWalls();        
    }
    public boolean isOnGround()
    {
        boolean onGround = false;
                   
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight()/2 , moving.class);
         
        if(ground != null)       
        {
            doubleJump=0;
            goGround(ground);
            onGround = true;   
                   
        }        
        return onGround;
    }
     private void checkWalls()
    {        
        Actor rightWall = getOneObjectAtOffset(getImage().getWidth() / 2, 0, moving.class);
        Actor leftWall = getOneObjectAtOffset(getImage().getWidth() / -2, 0, moving.class);
         
        if(rightWall != null)
        {
            moveOutOfRightWall(rightWall);
        }
        else if(leftWall != null)
        {
            moveOutOfLeftWall(leftWall);            
        }                                
    }
    private void moveOutOfLeftWall(Actor wall)
    {
        int wallWidth = wall.getImage().getWidth();
        int newX = wall.getX()-11 + (wallWidth + getImage().getWidth())/2 ;
        setLocation(newX + speed, getY());           
    }
    private void moveOutOfRightWall(Actor wall)
    {
        int wallWidth = wall.getImage().getWidth();
        int newX = wall.getX()+11 - (wallWidth + getImage().getWidth())/2;
        setLocation(newX - speed, getY());                
    }
     private void checkPlatformAbove()
    {        
        Actor ceiling = getOneObjectAtOffset(0, getImage().getHeight() / -2, moving.class);
        
        if(ceiling != null)
        {       
           
            jumpforce = 16;            
            moveOutOfCeiling(ceiling);
            
        }
    }
     private void moveOutOfCeiling(Actor ceiling)
    {
        int ceilingHeight = ceiling.getImage().getHeight();
        int newY = ceiling.getY() + (ceilingHeight + getImage().getHeight())/2;
        
        setLocation(getX(), newY);   
    }
    private void checkFall()
    {
        if (isOnGround()) {
            jumpforce = 16;
        }
        else {
            applyGravity();
            jumpforce=0;
        }
    }
    public boolean isittouch()
    {
        if (this.isTouching(hazard.class))
        return true;
        else
        return false;
    }
    public static void bringImages()
    {
        if (runRightImages == null || runLeftImages == null)
        {
            runRightImages = new GreenfootImage[walkcount];
            runLeftImages = new GreenfootImage[walkcount];
            for (int i = 0; i<walkcount; i++)
            {
                String fileName = "walk" + (walkcount-i) + ".png";
                runRightImages[i] = new GreenfootImage(fileName);
  
                runLeftImages[i] = new GreenfootImage(runRightImages[i]);
                runLeftImages[i].mirrorHorizontally();
            }
        }
        if (idleRightImages == null || idleLeftImages == null)
        {   idleRightImages = new GreenfootImage[idlecount];
            idleLeftImages = new GreenfootImage[idlecount];
            for (int i = 0; i<idlecount; i++)
            {
                String fileName = "idle" + (i+1) + ".png";
                idleRightImages[i] = new GreenfootImage(fileName);
   
                idleLeftImages[i] = new GreenfootImage(idleRightImages[i]);
                idleLeftImages[i].mirrorHorizontally();
            }
        }
        if (jumpRightImages == null || jumpLeftImages == null)
        {   jumpRightImages = new GreenfootImage[jumpcount];
            jumpLeftImages = new GreenfootImage[jumpcount];
            for (int i = 0; i<jumpcount; i++)
            {
                String fileName = "jump" + (i+1) + ".png";
                jumpRightImages[i] = new GreenfootImage(fileName);
 
                jumpLeftImages[i] = new GreenfootImage(jumpRightImages[i]);
                jumpLeftImages[i].mirrorHorizontally();
            }
        }
        if (fallRightImages == null || fallLeftImages == null)
        {   fallRightImages = new GreenfootImage[jumpcount];
            fallLeftImages = new GreenfootImage[jumpcount];
            for (int i = 0; i<jumpcount; i++)
            {
                String fileName = "fall" + (i+1) + ".png";
                fallRightImages[i] = new GreenfootImage(fileName);

                fallLeftImages[i] = new GreenfootImage(fallRightImages[i]);
                fallLeftImages[i].mirrorHorizontally();
            }
        }
    }
   public void checkUp()
   {String key = Greenfoot.getKey();
       if ("up".equals(key)||"w".equals(key))
        {
            if (doubleJump<2)
            {
                jump=new songPlayer("click1.mp3");
                jump.setLoud(30);
                jump();
                jump.playOnce();
                doubleJump++;
            }
        }
    }
    public void checkKeys()
    {
        if (Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("d"))
        {
            moveRight();
            checkUp();
        }
        else if (Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("a"))
        {
            moveLeft();
            checkUp();
        }
        else
        {
            stopMoving();
        }
       }
       
public void fireGun()
{
    start++;
    if (Greenfoot.isKeyDown("space")&&start%guncooldown==0)
    {songPlayer shoot=new songPlayer("AWP Shooting - CSGO Sound Effect.mp3");
        shoot.setLoud(20);
        shoot.playOnce();
        
        {
        if (facingLeft==true)
        {
    getWorld().addObject(new LeftBullet(), getX()-40, getY());}
    else
        {
    getWorld().addObject(new RightBullet(), getX()+40, getY());}
}
if (Greenfoot.isKeyDown("space")==false)
{start=0;
}
}}
    public void moveRight()
    {
        setVelocityX(+speed);
        setAnimation(runRight);
        facingLeft=false;
    }
    public void moveLeft()
    {
        setVelocityX(-speed);
        setAnimation(runLeft);
        facingLeft=true;
    }
    public void stopMoving()
    {
        setVelocityX(0.0);
        if (facingLeft)
        {
            setAnimation(idleLeft);
        }
        else
        {
            setAnimation(idleRight);
        }
}
    public void jump()
    {
jump.playOnce();
        if (canJump)
        {
            
            setVelocityY(-jumpforce);

        }
    }
        private void manageJumping()
{
        double speedY = getVelocityY();
        int lookY = (int)(getHeight()/2 + speedY + gravity);
        Actor a = getOneObjectAtOffset(0, lookY, moving.class);
        if (a == null)
        {
            applyGravity();

            if (!facingLeft)
            {
            setAnimation(fallRight);
        }
            else
            {
            setAnimation(fallLeft);
        }
        }
        else if (speedY > 0||speedY<0)
        {
            goGround(a);
            if (!facingLeft)
            {
            setAnimation(fallRight);
        }
            else
            {
            setAnimation(fallLeft);
        }
            setVelocityY(0.0);  
        }
    }
    public void applyGravity()
    {if (!facingLeft)
            {
            setAnimation(jumpRight);
        }
            else
            {
            setAnimation(jumpLeft);
        }
        double speedY = getVelocityY() + gravity; 
        if (speedY > maxfall) speedY = maxfall; 
        setVelocityY(speedY); 
    }
    public void goGround(Actor target)
    {

        double speedY = getVelocityY();
        int newY=0;
        int targetHeight = target.getImage().getHeight();
        if (speedY > 0){
        newY = target.getY() -1- (targetHeight + getImage().getHeight())/2;
        setLocation(getX(), newY);
        setVelocityY(0.0);
canJump=true;
    }
}
public void explode()
    {int x=getX();
        int y=getY();
   WorldsHandler.stopSounds();
        if (this!=null){
            WorldsHandler.stopSounds();
            death.setLoud(30);
        death.playOnce();
        placeBlood (x, y, NUM_FRAGMENTS);}

    }
    
    private void placeBlood(int x, int y, int numFragments)
    {
        for (int i=0; i < numFragments; i++) {
           getWorld().addObject ( new Blood(), x, y );
        }
    }
}

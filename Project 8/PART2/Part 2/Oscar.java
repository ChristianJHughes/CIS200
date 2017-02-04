/**
* <Oscar.java>
* <Christian / Lab Josh Friday/11:30>
*
* <The Oscars stand still and wait for Nick to attain them.
* They turn into cold hard cash once touched. Once touched enough,
* Leo will appear and do a little show in the middle.> 
*/


import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Oscar extends Fighter
{
    
    private GreenfootImage image1;
    private GreenfootImage image2;
    private int counter = 0;
    
    public Oscar() { 
        image1 = new GreenfootImage("oscar.png");
        image2 = new GreenfootImage("money.png");
        
    }
    
    public void act() 
    {
        changeUp();
    }    
    
    public void changeUp() { 
        if (canSee(Nick.class)) { 
            setImage(image2);
            Greenfoot.playSound("kiss.wav");
            counter++;
        }
        if (counter == 20) { 
         getWorld().addObject( new Leo(), 280, 280 );   
    }
}
}

/**
* <Leaf.java>
* <Christian Hughes / Josh Friday/11:30>
*
* <The leaf sprite will move to northeast and rotate clockwise as the program is executed.> 
*/
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Leaf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Leaf extends Actor
{
    /**
     * Act - do whatever the Leaf wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //The leaf will move northeast.
        setLocation (getX()+7, getY()-3);
        // rotate 5 degrees EACH TIME from current location 
        setRotation(getRotation()+ 5);
    }    
}

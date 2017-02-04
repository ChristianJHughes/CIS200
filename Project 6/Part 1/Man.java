/**
* <Man.java>
* <Christian Hughes / Josh Friday/11:30>
*
* <The man sprite will move to the right as the program is executed.> 
*/

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Man here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Man extends Actor
{
    /**
     * Act - do whatever the Man wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // set the location of the man to a x,y position, 
        // relative to its current location - moves "forward"
        setLocation(getX()+7,getY());
    }    
}

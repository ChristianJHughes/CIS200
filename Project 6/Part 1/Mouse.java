/**
* <Mouse.java>
* <Christian Hughes / Josh Friday/11:30>
*
* <The Mouse sprite will move to up as the program is executed.> 
*/

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mouse extends Actor
{
    /**
     * Act - do whatever the Mouse wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       //The mouse moves upwards.
       setLocation (getX(), getY()-4);
    }    
}

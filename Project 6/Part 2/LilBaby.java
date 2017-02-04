/**
* <LilBaby.java>
* <Christian Hughes / Josh Friday/11:30  >
*
* <This sprite moves to the right and rotates clockwise.> 
*/

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LilBaby here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LilBaby extends Actor
{
    /**
     * Act - do whatever the LilBaby wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX()+5,getY()); 
        setRotation(getRotation()+5);
    }    
}

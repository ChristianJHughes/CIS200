/**
* <Sadness.java>
* <Christian Hughes / Josh Friday/11:30  >
*
* <This sprite moves to the left and rotates clockwise.> 
*/

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sadness here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sadness extends Actor
{
    /**
     * Act - do whatever the Sadness wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX()-10,getY()); 
        setRotation(getRotation()+20);
    }    
}

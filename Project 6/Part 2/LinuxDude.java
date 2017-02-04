/**
* <LinuxDude.java>
* <Christian Hughes / Josh Friday/11:30  >
*
* <This sprite down and rotates counter-clockwise.> 
*/

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LinuxDude here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LinuxDude extends Actor
{
    /**
     * Act - do whatever the LinuxDude wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(),getY()+5); 
        setRotation(getRotation()-5);
    }    
}

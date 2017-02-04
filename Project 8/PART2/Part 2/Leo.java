/**
* <Leo.java>
* <Christian / Lab Josh Friday/11:30>
*
* <Leo will appear and spin whenever Nick turns
* enough of the Oscars into money. Pressing the 1
* key will create more of him. Pressing the 2 key
* will create more monkeys.> 
*/

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Leo extends Fighter
{
    
    public void act() 
    {
        turnHim();
    }    
    
    public void turnHim() { 
        turn(20);
    }
}

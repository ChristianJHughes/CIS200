/**
* <Lobster.java>
* <Christian / Lab Josh Friday/11:30>
*
* <The Lobster Moves Randomly, and Eats the Crabs that it Touches.> 
*/

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lobster extends Animal
{
    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       turnAtEdge();
       randomTurn();
       move();
       lookForCrab();
    }
    //The lobster turns if touching an edge.
        public void turnAtEdge() 
        {
            if ( atWorldEdge() ) { 
                turn(17); 
            } 
        }    
        
        //The lobster turns at random between -45 degrees and 45 degrees.
        public void randomTurn() {
            if (Greenfoot.getRandomNumber(100) < 10) { 
                turn(Greenfoot.getRandomNumber(90)-45); 
            }
        }
        
        
        //Check whether we have stumbled upon a crab. If we have, eat it. Otherwise do nothing.   
        public void lookForCrab() { 
            if (canSee(Crab.class)) { 
            eat(Crab.class);
            Greenfoot.playSound("au.wav");
            Greenfoot.stop();
            }
        }
}



/**
* <Crab.java>
* <Christian / Lab Josh Friday/11:30>
*
* <The Crab is user controlled, and eats all of the worms that it touches.> 
*/

import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * This class defines a crab. Crabs live on the beach.
 */
public class Crab extends Animal
{
    public void act()
    {
       
       checkKeyPress();
       move();
       lookForWorm();
    }
    //The crab turns if touching an edge.
        public void turnAtEdge() 
        {
            if ( atWorldEdge() ) { 
                turn(17); 
            } 
        }    
        
        //The crab turns at random between -45 degrees and 45 degrees.
        public void randomTurn() {
            if (Greenfoot.getRandomNumber(100) < 10) { 
                turn(Greenfoot.getRandomNumber(90)-45); 
            }
        }
        
        
        //Check whether we have stumbled upon a worm. If we have, eat it. Otherwise do nothing.   
        public void lookForWorm() { 
            if (canSee(Worm.class)) { 
            eat(Worm.class);
            Greenfoot.playSound("slurp.wav");
            }
        }
        
        //Moves the Crab based on which arrow key is pressed on the keyboard. 
        public void checkKeyPress() { 
            if (Greenfoot.isKeyDown("left")) { 
                turn(-4); 
            } 
            
            if (Greenfoot.isKeyDown("right")) { 
                turn(4); 
            } 
        }
}



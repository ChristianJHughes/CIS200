/**
* <ObeseMan.java>
* <Christian Hughes / Lab Josh Friday/11:30>
*
* <ObeseMan is controlled via the left and right arrow keys. He has the ability to "eat" JackieChan once 
* he they intersect. He will then make a slurpy sound, and pause for between 1 and 2 seconds.> 
*/

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ObeseMan extends Fighter
{
    /**
     * Act - do whatever the ObeseMan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       checkKeyPress();
       move(4);
       lookForJackieChan();
    }
    //The object turns if touching an edge.
        public void turnAtEdge() 
        {
            if ( atWorldEdge() ) { 
                turn(17); 
            } 
        }    
        
        //The object turns at random between -45 degrees and 45 degrees.
        public void randomTurn() {
            if (Greenfoot.getRandomNumber(100) < 10) { 
                turn(Greenfoot.getRandomNumber(90)-45); 
            }
        }
        
        
        //Check whether we have stumbled upon a worm. If we have, eat it. Otherwise do nothing.   
        public void lookForJackieChan() { 
            if (canSee(JackieChan.class)) { 
            eat(JackieChan.class);
            Greenfoot.playSound("slurp.wav");
            Greenfoot.delay(75);
            }
        }
        
        //Moves the object based on which arrow key is pressed on the keyboard. 
        public void checkKeyPress() { 
            if (Greenfoot.isKeyDown("left")) { 
                turn(-3); 
            } 
            
            if (Greenfoot.isKeyDown("right")) { 
                turn(3); 
            } 
        }
    }    


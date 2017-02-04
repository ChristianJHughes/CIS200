/**
* <Nick.java>
* <Christian / Lab Josh Friday/11:30>
*
* <Nick is user controlled, and turns the Oscars into sweet cash.> 
*/

import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)


public class Nick extends Fighter
{
    public void act()
    {
       
       checkKeyPress();
       move();
       
    }
    //Nick turns if touching an edge.
        public void turnAtEdge() 
        {
            if ( atWorldEdge() ) { 
                turn(17); 
            } 
        }    
        
        //The Nick turns at random between -45 degrees and 45 degrees.
        public void randomTurn() {
            if (Greenfoot.getRandomNumber(100) < 10) { 
                turn(Greenfoot.getRandomNumber(90)-45); 
            }
        }
        
        //Moves the Nick based on which arrow key is pressed on the keyboard. 
        public void checkKeyPress() { 
            if (Greenfoot.isKeyDown("left")) { 
                setRotation(180); 
            } 
            
            if (Greenfoot.isKeyDown("right")) { 
                setRotation(0); 
            } 
            
            if (Greenfoot.isKeyDown("up")) { 
                setRotation(270);
            } 
            
            if (Greenfoot.isKeyDown("down")) { 
                setRotation(90);
            }
        }
       
}



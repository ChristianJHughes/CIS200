/**
* <SuperBaby.java>
* <Christian Hughes / Lab Josh Friday/11:30>
*
* <SuperBaby moves slowly along the background, and rotates 90 degrees when clicked on.> 
*/

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class SuperBaby extends Fighter
{
    /**
     * Act - do whatever the SuperBaby wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       mouseClicker();
       move(1);
       turnAtEdge();
       
    }
    //Rotates the object when clicked. 
    public void mouseClicker() { 
        if (Greenfoot.mouseClicked(this)) {
            setRotation(getRotation()+90); 
        }
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
                turn(Greenfoot.getRandomNumber(180)-90); 
            }
        }
        
        
        //Check whether we have stumbled upon a worm. If we have, eat it. Otherwise do nothing.   
        public void lookForJackieChan() { 
            if (canSee(JackieChan.class)) { 
            eat(JackieChan.class);
            Greenfoot.playSound("slurp.wav");
            }
        }
        
        //Moves the obect based on which arrow key is pressed on the keyboard. 
        public void checkKeyPress() { 
            if (Greenfoot.isKeyDown("left")) { 
                turn(-3); 
            } 
            
            if (Greenfoot.isKeyDown("right")) { 
                turn(3); 
            } 
        }
    }    
/**
* <Monkey.java>
* <Christian / Lab Josh Friday/11:30>
*
* <The Monkeys Moves Randomly, and kill Nick upon contact. 
* Pressing the 1 Key will create more Leos. Pressing the 2 
* key will create more monkeys.> 
*/

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Monkey extends Fighter
{
   
    private int counter = 1; 
    private int counter2 = 1;
    
    public void act()
    {
       turnAtEdge();
       randomTurn();
       move();
       lookForNick();
       checkIfKeyIsPressed();
       
    }
    //The monkey turns if touching an edge.
        public void turnAtEdge() 
        {
            if ( atWorldEdge() ) { 
                turn(17); 
            } 
        }    
        
        //The monkey turns at random between -45 degrees and 45 degrees.
        public void randomTurn() {
            if (Greenfoot.getRandomNumber(100) < 10) { 
                turn(Greenfoot.getRandomNumber(90)-70); 
            }
        }
        
        
        //Check whether we have stumbled upon a Nick. If we have, kill him. Otherwise do nothing.   
        public void lookForNick() { 
            if (canSee(Nick.class)) { 
            eat(Nick.class);
            Greenfoot.playSound("au.wav");
            Greenfoot.stop();
            }
        }
        
     public void checkIfKeyIsPressed() { 
        if (Greenfoot.isKeyDown("1") && counter == 1) { 
                getWorld().addObject( new Leo(), Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560)); 
                counter++;
            } 
            
        if (Greenfoot.isKeyDown("2") && counter2 == 1) { 
                getWorld().addObject( new Monkey(), Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560));
                counter2++;
        } 
    }
}



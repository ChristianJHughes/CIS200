/**
* <XtremeWorld.java>
* <Christian / Lab Josh Friday/11:30>
*
* <It's an adventure land for all of the actors to have fun in.> 
*/
import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)

public class XtremeWorld extends World
{
   
    public XtremeWorld() 
    {
        super(560, 560, 1);
        populateWorld();
    }
    
    public void populateWorld() { 
        addObject( new Nick(), 150, 100 );
        addObject( new Monkey(), Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560)); 
        addObject( new Monkey(), Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560)); 
        
        
      addObject( new Oscar(), Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560));
      addObject( new Oscar(), Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560));
      addObject( new Oscar(), Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560));
      addObject( new Oscar(), Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560));
    }
}
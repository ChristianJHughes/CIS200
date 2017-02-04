/**
* <CrabWorld.java>
* <Christian / Lab Josh Friday/11:30>
*
* <It's an underwater adventure land.> 
*/
import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)

public class CrabWorld extends World
{
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    public CrabWorld() 
    {
        super(560, 560, 1);
        populateWorld();
    }
    
    public void populateWorld() { 
        addObject( new Crab(), 150, 100 );
        addObject( new Lobster(), Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560)); 
        addObject( new Lobster(), Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560)); 
        addObject( new Lobster(), Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560)); 
        
        addObject( new Worm(), Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560));
        addObject( new Worm(), Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560));
        addObject( new Worm(), Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560));
        addObject( new Worm(), Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560));
        addObject( new Worm(), Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560));
        addObject( new Worm(), Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560));
        addObject( new Worm(), Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560));
        addObject( new Worm(), Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560));
        addObject( new Worm(), Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560));
        addObject( new Worm(), Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560));
    }
}
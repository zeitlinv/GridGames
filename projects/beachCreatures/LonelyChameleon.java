
import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

/*
The LonelyChameleon attempts to eat any nearby actors (as a normal critter does), but if 
no nearby actors are found, its color will darken.
*/
public class LonelyChameleon extends Critter{
    private static double DARKENING_FACTOR = 0.05;
    /*
    Determines whether the chameleon will eat surrounding actors or darken, based on the number
    of adjacent actors
    */
    public void processActors(ArrayList<Actor> actors)
    {
        if(actors.size() > 0){
            for (Actor a : actors)
            {
            if (!(a instanceof Rock) && !(a instanceof Critter))
                a.removeSelfFromGrid();
            }
        }
        else{
            //Taken from Flower: sets the critter's new color to the old color with all RGB values lowered
            Color c = getColor();
            int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
            int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
            int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));

            setColor(new Color(red, green, blue));
        }
        
    }

}

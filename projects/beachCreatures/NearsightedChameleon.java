
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

/*
The NearsightedChameleon will act as a regular LonelyChameleon does, but it will only decide
to darken/not darken based on the absence/presence of actors directly in front and behind it
*/
public class NearsightedChameleon extends LonelyChameleon{
    /*
    The chameleon will only act on actors positioned at the direction 0 (directly in front)
    and 180 (directly behind)
    */
    public ArrayList<Actor> getActors(){
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Actor n = findActor(0);
        Actor z = findActor(180);
        if(n != null){
            actors.add(n);
        }
        if(z != null){
            actors.add(z);
        }
        return actors;
    }

    /*
    Returns actor in a given direction, or null if none
    */
    private Actor findActor(int dir){
        Actor n = null;
        Location loc = getLocation();
        Location actorLoc = loc.getAdjacentLocation(dir);
        if(getGrid().isValid(actorLoc)){//Ensures checked location is valid
            n = getGrid().get(actorLoc);
        }
        return n;
    }
}
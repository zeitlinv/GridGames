import java.util.ArrayList;
import java.util.Random;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/*
The RockMason will attempt to create up to 2 rocks in adjacent locations; if none available
it will teleport to a random empty location in the bounded grid
*/
public class RockMason extends Critter {
    /*
    Accesses all empty, valid locations in the world as potential move locations
    */
    public ArrayList<Location> getMoveLocations(){
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid<Actor> gr = getGrid();
        if(locs.size() <= 0){
            for (int r = 0; r < gr.getNumRows(); r++){
                for (int c = 0; c < gr.getNumCols(); c++){
                    Location loc = new Location(r, c);
                    if(gr.get(loc) == null)
                        locs.add(loc);
                }
            }
        }
        return locs;
    }
    /*
    If empty adjacent locations are present, the RockMason will attempt to create up to 2 randomly 
    placed rocks and select the move location as the current one; if not, it will select a location 
    randomly chosen from its parameter array, or the present location
    */
    public Location selectMoveLocation(ArrayList<Location> locs){
        ArrayList<Location> rockLocs = new ArrayList<Location>();
        rockLocs = getGrid().getEmptyAdjacentLocations(getLocation());
        if(rockLocs.size() > 0){
            for(int i = 0; i < 2; i++){//Place up to 2 random rocks, if empty locations are available
                if(rockLocs.size() > 0){
                    Rock a = new Rock();
                    a.putSelfInGrid(getGrid(), selectRand(rockLocs));    
                }
            }        
        }
        else if(locs.size() > 0){
            return selectRand(locs);
        }
        //Executed if rocks are created or no move locations are open
        return getLocation(); 
    }
    /*
    Select a random location from a given Location ArrayList and remove it from the array
    */
    private Location selectRand(ArrayList<Location> locs){
        Random rand = new Random();
        int r = rand.nextInt(locs.size());
        Location l = locs.get(r);
        locs.remove(r);
        return l;
    }
}

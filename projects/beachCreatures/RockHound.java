import java.util.ArrayList;
import java.lang.Math;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/*
The RockHound will attempt to eat any adjacent Rock, and if none are present, it will
move in the direction of the Rock closest to (0,0) (or direction closest to the optimal one)
*/
public class RockHound extends Critter{
    private boolean ateRock;

    public RockHound(){
        ateRock = false;
    }

    /*
    Removes any adjacent Rock actors
    */
    public void processActors(ArrayList<Actor> actors){
        for (Actor a : actors){
            if(a instanceof Rock){
                a.removeSelfFromGrid();
                ateRock = true;
            }
                
        }
    }

    /*
    Selects the location to move as the empty, valid adjacent location in the direction of a Rock in the world,
    or as the current location if no adjacent locations are available, no Rocks are present, or 
    Rock(s) were already eaten
    */
    public Location selectMoveLocation(ArrayList<Location> locs){
        Grid<Actor> gr = getGrid();
        Actor nextRock = null;//Rock to move in the direction of 
        //Find Rock in the world closest to (0,0)
        for (int r = 0; r < gr.getNumRows(); r++){
            for (int c = 0; c < gr.getNumCols(); c++){
                Location loc = new Location(r, c);
                Actor a = gr.get(loc);
                if(a instanceof Rock){
                    nextRock = a;
                    break;
                }
            }
        }
        Location moveLoc = getLocation();
        /*
        If there is a Rock in the world and Rocks have not already been eaten, the location
        to move to will be selected as the empty, valid one in the direction of the selected Rock
        */
        if(nextRock != null && !ateRock){
            int rockDir = getLocation().getDirectionToward(nextRock.getLocation());//Direction towards Rock
            int moveDir = Math.abs(rockDir-180);//Direction to move in
            
            //Find the Location in locs with minimum difference from the direction towards the Rock
            for(Location l: locs){
                int currDir = getLocation().getDirectionToward(l);
                if(Math.abs(rockDir-currDir) < Math.abs(rockDir-moveDir)){
                    moveDir = currDir;
                    moveLoc = l;
                } 
            }
        }
        ateRock = false;
        return moveLoc;
        
    }
}

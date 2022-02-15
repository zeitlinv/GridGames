import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
/*
The AngryCrab will push any adjacent actors to the adjacent space away from itself
*/
public class AngryCrab extends CrabCritter{
    /*
    Accesses adjacent actors
    */
    public ArrayList<Actor> getActors()
    {
        return getGrid().getNeighbors(getLocation());
    }
    /*
    Moves away the given actors by one sapce
    */
    public void processActors(ArrayList<Actor> actors){
        for(Actor a : actors){
            int moveDir = getLocation().getDirectionToward(a.getLocation());//The direction away from the crab
            Location moveLoc = a.getLocation().getAdjacentLocation(moveDir);//Adjacent location in given directin
            if(getGrid().isValid(moveLoc)){
                a.moveTo(moveLoc);
            }
            else{
                a.removeSelfFromGrid();
            }
        }
    }
}

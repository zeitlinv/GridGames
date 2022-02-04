import java.util.ArrayList;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import java.awt.Color;

/*
The TownCrier turns green if greater than a param t Critters are present within 2 spaces, 
and turns red if fewer than t are present
*/
public class TownCrier extends Critter{
    private int t;

    public TownCrier(int tNum){
        t = tNum;
    }
    /*
    Accesses actors within the nearest 2 spaces
    */
    public ArrayList<Actor> getActors(){
        ArrayList<Actor> actors = new ArrayList<Actor>();
        int dirs[] = new int[8];//Contains every possible dir from curr location
        for(int i = 0; i < 8; i++){
            dirs[i] = 45*(i+1);
        }
        for (int dir : dirs){
            Actor a = findActors(getLocation(), dir);//The actor in the adjacent location in direction dir
            Actor b = findActors(getLocation().getAdjacentLocation(dir), dir);//The actor in the second adjacent location in the direction dir
            if (a != null){
                actors.add(a);
            }
            if(b != null){
                actors.add(b);
            }
        }
        /*
        Alternate using Grid class: 
        for x-2 -> x+2
            for y-2 -> y+2
                check valid
                check critter
                add actor @location
        */
        return actors;
    }
    /*
    Return Critter in the adjacent location in direction dir from specified startLoc, or null if
    none
    */
    private Actor findActors(Location startLoc, int dir){
        Location loc = startLoc.getAdjacentLocation(dir);
        Actor n = null;
        if(getGrid().isValid(loc) && getGrid().get(loc) instanceof Critter){
            n = getGrid().get(loc);   
        }
        return n;
    }
    /*
    Determines color based on number of actors in range
    */
    public void processActors(ArrayList<Actor> actors){
        if(actors.size() > t){
            setColor(new Color(0, 250, 0));
        }
        else{
            setColor(new Color(250, 0, 0));
        }
    }
    public void makeMove(Location loc){
        moveTo(getLocation());
    }
}

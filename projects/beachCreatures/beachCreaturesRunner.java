import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;

public class beachCreaturesRunner {
    public static void main(String[] args){
        ActorWorld world = new ActorWorld(new BoundedGrid<>(10,10));
        RockHound b = new RockHound();
        world.add(new Location(9, 8), b);
        Rock r = new Rock();
        world.add(new Location(9, 7), r);
        Rock r1 = new Rock();
        world.add(new Location(5, 8), r1);
        Rock r2 = new Rock();
        world.add(new Location(1, 0), r2);
        LonelyChameleon l = new LonelyChameleon();
        world.add(new Location(8, 8), l);
        world.show();
    }
}

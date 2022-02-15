import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

import java.util.Random;

public class BeachCreatureRunner {

  private static Random r = new Random();
  private static int turn = 0;

  public static void main(String[] args) {
    ActorWorld world = new ActorWorld(new BoundedGrid<>(8,8));
    // Add some rocks
    for (int i = 0; i < 8; i++){
      int x = r.nextInt(8);
      int y = r.nextInt(8);
      world.add(new Location(x,y), new Rock());
    }

    world.setMessage("");

    //world.add(new AngryCrab());
    world.add(new RockMason());

    world.show();
  }
}

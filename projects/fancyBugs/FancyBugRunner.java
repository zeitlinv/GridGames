import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

public class FancyBugRunner {
  public static void main(String[] args) {
    ActorWorld world = new ActorWorld(new UnboundedGrid<>());
    Bug[] bugs = {
        new CircleBug(3), new SpiralBug(3),
        new ZBug(3), new RectangleBug(2, 3), new RainbowBug(),
        new PolygonBug(3, 2), new PolygonBug(8, 4)
    };
    for (int i = 0; i < bugs.length; i++) {
      world.add(new Location(i * 5, i * 5), bugs[i]);
    }
    world.show();
  }
}

import java.util.ArrayList;
import java.util.Random;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class RockMason extends Actor {

  private static final Random random = new Random();

  public RockMason() {
    setColor(null);
  }

  /**
   * Try to spawn up to 2 Rocks in an empty
   * adjacent location. If surrounded, then
   * move to a random empty location. Do nothing
   * if no such location exists.
   */
  public void act() {
    System.out.println("RockMason act");
    ArrayList<Location> locations = getGrid().getEmptyAdjacentLocations(getLocation());

    // If surrounded try to find new empty location and move
    if (locations.isEmpty()) {
      Location newLoc = findEmptyLocation();
      if (newLoc != null) {
        moveTo(newLoc);
      }
    } else { // Try to spawn up to 2 rocks in empty adjacent location
      int rockCount = 0;
      while (rockCount < 2 && rockCount < locations.size()) {
        Rock r = new Rock();
        r.putSelfInGrid(getGrid(), locations.get(rockCount++));
      }
    }
  }

  /**
   * Returns a random empty location in the world
   * If that doesn't exist, return null
   */
  private Location findEmptyLocation() {
    // Get all occupied locations
    Grid<Actor> g = getGrid();
    int cols = g.getNumCols(), rows = g.getNumRows();
    ArrayList<Location> occupied = g.getOccupiedLocations();

    // Return null if all occupied
    if (occupied.size() == cols * rows) {
      return null;
    }

    // Otherwise generate random location until empty found
    Location newLoc;
    do {
      newLoc = new Location(random.nextInt(rows), random.nextInt(cols));
    } while (g.get(newLoc) != null);

    return newLoc;
  }
}

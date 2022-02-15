import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class RockHound extends Actor {

  private Location rockCompass;

  public RockHound() {
    setColor(null);
  }

  /**
   * Eat rocks in adjacent locations.
   * If no rocks are found, then move
   * toward a rock in the world.
   * If no rocks exist, then do nothing.
   */
  public void act() {
    System.out.println("RockHound act");
    int numRocksEaten = eatRocks();

    if (numRocksEaten == 0) {
      findRock();
    }

    if (rockCompass != null) {
      move();
    }
  }

  /**
   * Check for adjacent rocks and eat them
   * Return the number of rocks eaten
   */
  private int eatRocks() {
    Grid<Actor> g = getGrid();
    ArrayList<Location> neighbors = g.getOccupiedAdjacentLocations(getLocation());
    int numRocks = 0;
    for (Location neighbor : neighbors) {
      if (g.get(neighbor) instanceof Rock) {
        g.remove(neighbor);
        numRocks++;
      }
    }

    rockCompass = null; // Reset compass if rocks were eaten
    return numRocks;
  }

  /**
   * Find a rock in the world and set it as compass
   */
  private void findRock() {
    // Don't do anything if already moving toward rock
    if (rockCompass != null) {
      return;
    }

    Grid<Actor> g = getGrid();
    ArrayList<Location> occupied = g.getOccupiedLocations();
    for (Location l : occupied) {
      if (g.get(l) instanceof Rock) {
        rockCompass = l;
      }
    }
  }

  /**
   * Turn toward the rockCompass.
   * If the next step is valid and empty,
   * then move in that direction.
   */
  private void move() {
    setDirection(getLocation().getDirectionToward(rockCompass));
    Grid<Actor> g = getGrid();
    Location next = getLocation().getAdjacentLocation(getDirection());
    if (!g.isValid(next)){
      return;
    }
    if (g.get(next) != null){
      return;
    }
    moveTo(next);
  }

}

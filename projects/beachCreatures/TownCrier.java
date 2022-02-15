import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class TownCrier extends Critter {
  private int threshold;

  public TownCrier(int t) {
    this.threshold = t;
  }

  /**
   * Return an ArrayList of Actors that
   * are within 2 steps away from TownCrier.
   */
  public ArrayList<Actor> getActors() {
    ArrayList<Actor> actors = new ArrayList<>();
    Grid<Actor> g = getGrid();

    // Check for valid locations within distance 2
    Location loc = getLocation();
    int row = loc.getRow(), col = loc.getCol();
    for (int r = row - 2; r <= row + 2; r++) {
      for (int c = col - 2; c <= col + 2; c++) {
        Location tempLoc = new Location(r, c);
        if (g.isValid(tempLoc)) {

          // Add to actors if location occupied
          Actor target = g.get(tempLoc);
          if (target != this && target instanceof Critter) {
            actors.add(target);
          }
        }
      }
    }
    return actors;
  }

  /**
   * Counts all actors within distance 2.
   * Turn green if this count is above the threshold,
   * otherwise turn red.
   */
  public void processActors(ArrayList<Actor> actors){
    Color newColor = actors.size() > threshold ? Color.GREEN : Color.RED;
    setColor(newColor);
  }
}

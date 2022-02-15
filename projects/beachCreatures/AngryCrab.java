import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

public class AngryCrab extends CrabCritter {
  public AngryCrab() {
    setColor(null);
  }

  /**
   * Move the given actor one step away from AngryCrab
   * if that location is valid and empty;
   * otherwise remove it from the grid
   */
  private void processMove(Actor a) {
    // Get location one step away
    int direction = a.getLocation()
        .getDirectionToward(this.getLocation()) + 180;
    Location next = a.getLocation()
      .getAdjacentLocation(direction);

    // Move if valid
    if (getGrid().isValid(next) && getGrid().get(next) == null) {
      a.moveTo(next);
    } else {
      a.removeSelfFromGrid();
    }
  }

  /**
   * Move all adjacent actors one step away
   * If tne actor cannot move, it is removed
   */
  public void processActors(ArrayList<Actor> actors) {
    for (Actor a : actors) {
      processMove(a);
    }
  }
}

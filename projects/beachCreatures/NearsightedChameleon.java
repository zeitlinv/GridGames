import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

public class NearsightedChameleon extends LonelyChameleon {

  /**
   * Returns the actor (or null) in the given direction
   */
  private Actor getActorInDirection(int direction) {
    Location loc = getLocation().getAdjacentLocation(direction);
    if (getGrid().isValid(loc)) {
      return getGrid().get(getLocation().getAdjacentLocation(direction));
    } else {
      return null;
    }
  }

  /**
   * Returns an ArrayList of up to two Actors
   * that are either in front or behind
   */
  public ArrayList<Actor> getActors() {
    ArrayList<Actor> seen = new ArrayList<>();
    // Look ahead
    Actor ahead = getActorInDirection(getDirection());
    if (ahead != null) {
      seen.add(ahead);
    }
    // Look behind
    Actor behind = getActorInDirection(getDirection() + 180);
    if (behind != null) {
      seen.add(behind);
    }

    return seen;
  }
}

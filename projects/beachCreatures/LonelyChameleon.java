import java.util.ArrayList;
import java.awt.Color;

import info.gridworld.actor.Actor;


/**
 * LonelyChameleon behaves exactly like a ChameleonCritter,
 * except when there are noa ctors around it, it will darken.
 */
public class LonelyChameleon extends ChameleonCritter {

  private static final double DARKENING_FACTOR = 0.05;

  /**
   * Darken current color by DARKENING_FACTOR
   * and set that as the new color.
   */
  private void darken() {
    Color c = getColor();
    int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
    int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
    int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
    setColor(new Color(red, green, blue));
  }

  /**
   * Randomly selects a neighbor and changes this critter's color to be the
   * same as that neighbor's. If there are no neighbors, then it will darken
   * instead.
   */
  public void processActors(ArrayList<Actor> actors) {
    int n = actors.size();
    if (n == 0) {
      darken();
      return;
    } else {
      int r = (int) (Math.random() * n);

      Actor other = actors.get(r);
      setColor(other.getColor());
    }
  }
}

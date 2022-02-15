import info.gridworld.actor.Bug;
import java.awt.Color;

public class RainbowBug extends Bug{

  private static final Color[] rainbow = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE};
  private int step = 0;

  public RainbowBug(){
    updateColor();
  }

  private void updateColor(){
    setColor(rainbow[step++]);
    step %= rainbow.length;
  }

  public void act(){
    updateColor();
  }
}

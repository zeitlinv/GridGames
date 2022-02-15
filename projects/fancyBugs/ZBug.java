import info.gridworld.actor.Bug;

public class ZBug extends Bug {
  private int length;
  private int steps = 0;
  private int mode = 0; // 0 1 2 for three sides of Z

  public ZBug(int length) {
    this.length = length;
    setDirection(90);
  }

  public void act() {
    if (!canMove() || mode == 3)
      return;
    if (steps < length) {
      move();
      steps++;
    } else {
      int direction = mode == 0 ? 225 : 90;
      setDirection(direction);
      steps = 0;
      mode++;
    }
  }
}

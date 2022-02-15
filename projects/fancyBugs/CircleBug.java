import info.gridworld.actor.Bug;

public class CircleBug extends Bug {
  private int steps;
  private int sideLength;

  public CircleBug(int sideLength) {
    steps = 0;
    this.sideLength = sideLength;
  }

  public void act() {
    if (steps < sideLength && canMove()) {
      move();
      steps++;
    } else {
      turn();
      steps = 0;
    }
  }
}

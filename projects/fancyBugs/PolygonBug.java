import info.gridworld.actor.Bug;

public class PolygonBug extends Bug{
  private int steps;
  private int sideLength;
  private int turnAngle;
  public PolygonBug(int n, int s){
    this.turnAngle = (180*(n-2))/n;
    this.sideLength = s;
  }

  public void act(){
    if (steps < sideLength && canMove()){
      move();
      steps++;
    }else {
      setDirection(getDirection() + turnAngle);
      steps = 0;
    }
  }
}

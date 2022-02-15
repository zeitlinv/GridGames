import info.gridworld.actor.Bug;

public class RectangleBug extends Bug{
  private int width, length;
  private int steps = 0;
  private boolean onWidth = true;

  public RectangleBug(int width, int length){
    this.width = width;
    this.length = length;
  }

  public void act(){
    int threshold = onWidth ? width : length;
    if (steps < threshold && canMove()){
      move();
      steps++;
    }else {
      turn();
      turn();
      onWidth = !onWidth;
      steps = 0;
    }
  }
}

public class LaneWorldRunner {
  public static void main(String[] args) {
    Team L = new TeamLee(true);
    Team R = new TeamLee(false);

    LaneWorld world = new LaneWorld(L, R);
    world.show();

  }
}

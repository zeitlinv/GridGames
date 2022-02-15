/**
 * Hedgehog is a 3/2 pet
 * Faint: Deal 2 damage to all
 */
public class Hedgehog extends Pet {
  private int faintDamage = 2;

  public Hedgehog(int id, int direction, Team team) {
    super(id, "Hedgehog", 3, 2, direction, team);
  }

  public void onFaint(Team opponents) {
    for (Pet p : team.getPets()) {
      p.changeHp(-faintDamage);
    }
    for (Pet p : opponents.getPets()) {
      p.changeHp(-faintDamage);
    }
    LaneWorldLogger.log(String.format("\n%s deals 2 damage to all.", this));
  }
}

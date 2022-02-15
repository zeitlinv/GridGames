/**
 * Bluebird is a 2/1 pet
 * Start: Give the frontmost pet +1/0
 */
public class Bluebird extends Pet {

  private int bonusAtk = 1;

  public Bluebird(int id, int direction, Team team) {
    super(id, "Bluebird", 2, 1, direction, team);
  }

  public void onStart(Team opponents) {
    Pet friend = team.getFrontPet();
    if (friend != null) {
      LaneWorldLogger.log(String.format("%s gives %s +%d/0", this, friend, bonusAtk));
      friend.changeAttack(bonusAtk);
    }
  }
}

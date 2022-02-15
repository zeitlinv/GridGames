/**
 * Ants are a 2/1 Pet
 * Faint: Give +ATK/+HP to a random Pet on team
 */
public class Ant extends Pet {

  private int bonusHp = 1;
  private int bonusAtk = 2;

  public Ant(int id, int direction, Team team) {
    super(id, "Ant", 2, 1, direction, team);
  }

  public void onFaint(Team opponents) {
    Pet friend = team.getRandomPet(this);
    if (friend != null) {
      LaneWorldLogger.log(String.format("%s gains +%d/+%d.", friend, bonusAtk, bonusHp));
      friend.changeHp(bonusHp);
      friend.changeAttack(bonusAtk);
    }
  }
}

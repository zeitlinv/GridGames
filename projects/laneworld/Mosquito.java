/**
 * Mosquito is a 2/2 pet
 * Start: Deal 1 damage to random enemy
 */

public class Mosquito extends Pet {

  private int startDamage = 1;

  public Mosquito(int id, int direction, Team team) {
    super(id, "Mosquito", 2, 2, direction, team);
  }

  public void onStart(Team opponents) {
    Pet opponent = opponents.getRandomPet(this);
    if (opponent != null) {
      LaneWorldLogger.log(String.format("%s deals %d damage to %s.", this, startDamage, opponent));
      opponent.changeHp(-startDamage);
      opponents.checkForFaintedPets(team);
    }
  }
}

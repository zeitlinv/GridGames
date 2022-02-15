/**
 * Beaver is a 2/2 pet
 * Start: Give 2 random friends 0/+1
 */
public class Beaver extends Pet {

  private int bonusHp = 1;
  private int numFriends = 2;

  public Beaver(int id, int direction, Team team) {
    super(id, "Beaver", 2, 2, direction, team);
  }

  private void helpFriend() {
    /* TODO */
  }

  public void onStart(Team opponents) {
    for (int i = 0; i < numFriends; i++) {
      helpFriend();
    }
  }
}

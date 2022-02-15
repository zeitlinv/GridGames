import info.gridworld.actor.Actor;

public abstract class Pet extends Actor {
  int id;
  String name;
  int hp;
  int attack;
  Team team;

  public Pet(int id, String name, int attack, int hp, int direction, Team team) {
    this.id = id;
    this.name = name;
    this.hp = hp;
    this.attack = attack;
    this.team = team;
    setColor(null);
    setDirection(direction);
  }

  public String toString() {
    return String.format("%s#%d|%s", name, id, getStats());
  }

  /* Getters */
  public String getName() {
    return this.name;
  }

  public int getHp() {
    return this.hp;
  }

  public int getAttack() {
    return this.attack;
  }

  public String getStats() {
    return String.format("%d/%d", attack, hp);
  }

  public boolean fainted() {
    return hp <= 0;
  }

  /* Setters */
  public void changeHp(int delta) {
    this.hp += delta;
  }

  public void changeAttack(int delta) {
    this.attack += delta;
  }

  /* Battle */

  /**
   * Deal damage to the opponent pet
   */
  public void attack(Pet opponent) {
    int damage = this.calculateDamage(opponent);
    opponent.changeHp(-damage);
    LaneWorldLogger.log(String.format("%s attacks %s for %d damage", this, opponent, damage));
  }

  /**
   * For now just returns attack; can modify in the future
   */
  public int calculateDamage(Pet opponent) {
    return this.attack;
  }

  /**
   * Remove this pet from the grid
   */
  public void faint() {
    removeSelfFromGrid();
    LaneWorldLogger.log(this + " has fainted.");
  }

  /* Abilities */
  /* These abilities are empty and should be overridden where applicable */

  public void onFaint(Team opponents) {
  }

  public void onStart(Team opponents) {
  }

}
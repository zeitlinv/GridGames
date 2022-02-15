import java.util.ArrayList;
import java.util.Random;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/**
 * A Team holds up to 5 Pets and contains
 * the logic necessary to manage all pets
 */
public abstract class Team {
  private ArrayList<Pet> pets;
  private boolean isLeft;
  private static final Random random = new Random();

  public Team(boolean isLeft) {
    this.isLeft = isLeft;
    pets = new ArrayList<>();
  }

  /**
   * @return a string of stats for each pet
   */
  public String toString() {
    String team = "";
    // Has to go backward for the left team
    if (isLeft) {
      for (int i = pets.size() - 1; i >= 0; i--) {
        team += pets.get(i).getStats() + "  ";
      }
    } else {
      for (Pet p : pets) {
        team += p.getStats() + "  ";
      }
    }
    return team;

  }

  /* Getters */
  public ArrayList<Pet> getPets() {
    return pets;
  }

  public boolean isAllFainted() {
    return pets.isEmpty();
  }

  /**
   * @return the first pet in the team
   *         if no such pet exists, then return null
   */
  public Pet getFrontPet() {
    if (pets.isEmpty()) {
      return null;
    }
    return pets.get(0);
  }

  /**
   * @return a random pet distinct from the given pet
   *         if no such pet exists, then return null
   */
  public Pet getRandomPet(Pet p) {
    if (pets.isEmpty() || pets.size() == 1) {
      return null;
    }

    int index;
    do {
      index = random.nextInt(pets.size());
    } while (pets.get(index).equals(p));

    return pets.get(index);
  }

  /* Setters */
  public void addPet(Pet p) {
    pets.add(p);
  }

  /* Actions */

  /**
   * Place pets in grid depending on
   * side of this team
   */
  public void placePets(Grid<Actor> grid) {
    for (int i = 0; i < pets.size(); i++) {
      Pet p = pets.get(i);
      Location loc = this.isLeft ? new Location(0, 4 - i) : new Location(0, 6 + i);
      p.putSelfInGrid(grid, loc);
    }
  }

  /**
   * Go through pets in team to check for fainted pets
   * Activate onFaint abilities as well
   * Then remove all fainted pets
   */
  public void checkForFaintedPets(Team opponents) {
    for (Pet p : pets) {
      if (p.fainted()) {
        p.faint();
        p.onFaint(opponents);
      }
    }
    pets.removeIf(p -> p.fainted());
    movePets();
  }

  /**
   * Move each pet (except first) one step forward
   */
  public void movePets() {
    int ahead = this.isLeft ? Location.EAST : Location.WEST;
    for (int i = 0; i < pets.size(); i++) {
      Pet p = pets.get(i);
      Grid<Actor> gr = p.getGrid();
      Location next = p.getLocation().getAdjacentLocation(ahead);
      // Prevent pets from moving into middle spot
      if (next.getCol() != 5 && gr.isValid(next) && gr.get(next) == null) {
        p.moveTo(next);
      }
    }
  }

  /**
   * Call each pet's onStart ability and log what happens
   */
  public void activateStartAbilities(Team opponents) {
    for (Pet p : pets) {
      p.onStart(opponents);
    }
  }

}

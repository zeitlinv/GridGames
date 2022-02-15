import info.gridworld.grid.Location;

/**
 * Team Lee consists of 3 ants.
 */
public class TeamLee extends Team{
  public TeamLee(boolean isLeft){
    super(isLeft);
    int direction = isLeft ? Location.EAST : Location.WEST;
    for (int i = 0; i < 2; i++){
      addPet(new Ant(i, direction, this));
    }
    for (int i = 0; i < 2; i++){
      addPet(new Beaver(i, direction, this));
    }
    for (int i = 0; i < 1; i++){
      addPet(new Bluebird(i, direction, this));
    }
  }
}

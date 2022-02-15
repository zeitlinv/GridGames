import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;

/**
 * LaneWorld is the main game engine;
 * it is in charge of keeping track of the teams
 * as well as updating game state.
 */
public class LaneWorld extends ActorWorld {

  private Team teamLeft;
  private Team teamRight;
  private boolean gameOver;

  /* Setup */

  /**
   * Creates and places the given teams into the world
   */
  public LaneWorld(Team left, Team right) {
    super(new BoundedGrid<Actor>(1, 11));
    this.teamLeft = left;
    this.teamRight = right;
    LaneWorldLogger.createGUI();
    placeTeams();
    activateStartAbilities();
    updateMessage();
  }

  /**
   * Place all pets from both teams into grid
   */
  private void placeTeams() {
    Grid<Actor> grid = getGrid();
    teamLeft.placePets(grid);
    teamRight.placePets(grid);
  }

  /**
   * Activate all abilities that happen at the start
   */
  private void activateStartAbilities() {
    teamLeft.activateStartAbilities(teamRight);
    teamRight.activateStartAbilities(teamLeft);
    checkForFaintedPets();
  }

  /**
   * Update the message to show status
   */
  private void updateMessage() {
    if (gameOver) {
      return;
    }

    String message = "";
    message += String.format("\t%s\t\t%s", teamLeft, teamRight);
    setMessage(message);
  }

  /* Battle Engine */
  public void step() {
    if (gameOver) {
      return;
    }
    battle();
    updateMessage();
  }

  /**
   * Front pets of both teams fight each other
   * Then check for fainted pets
   */
  private void battle() {
    /* TODO */
  }

  /**
   * Check if any pets have fainted
   */
  private void checkForFaintedPets() {
    teamLeft.checkForFaintedPets(teamRight);
    teamRight.checkForFaintedPets(teamLeft);
    checkWin();
  }

  /**
   * Checks if any team is wiped out
   * And end the game if so by
   * setting the appropriate message
   * and preventing further steps.
   */
  private void checkWin() {
    /* TODO */

    if (leftKO || rightKO) {
      gameOver = true;
    }
    if (leftKO && rightKO) {
      setMessage("Draw!");
    }
    if (leftKO && !rightKO) {
      setMessage("Right wins!");
    }
    if (!leftKO && rightKO) {
      setMessage("Left wins!");
    }
  }
}

package csci.ooad.arcane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Arcane {

    public static final Logger logger = LoggerFactory.getLogger(Arcane.class);
   //  private static final Marker GAME_STATUS = MarkerFactory.getMarker("Game_Status");

    // ---------- Member Variables ---------- //
    private Maze maze;
    private List<Adventurer> adventurers = new ArrayList<>();
    private List<Adventurer> initialAdventurers = new ArrayList<>();
    private List<Creature> creatures = new ArrayList<>();
    private List<Creature> initialCreatures = new ArrayList<>();
    private List<Food> foods = new ArrayList<>();
    private List<Food> initialFoods = new ArrayList<>();
    private boolean gameOver = false;

    private int turnCount = 0;

    // ---------- Constructors ---------- //

    // maze(), creatures, adventurers, foods

    // csci.ooad.arcane.Maze:
    // Initial Creatures
    // Initial Adventurers
    // Initial Foods

    // TODO: Rememeber to remove the new food random thing

    // Below is a great example of dependency injection! Look at how the constructor accepts several dependencies!
    public Arcane (Maze maze, List<Adventurer> initialAdventurers, List<Creature> initialCreatures, List<Food> initialFoods) {

        logger.info("Starting Arcane:" + "\n");

        this.maze = maze;
        this.initialAdventurers = initialAdventurers;
        this.initialCreatures = initialCreatures;
        this.initialFoods = initialFoods;

        resetGame();
    }

    // Checkout how this reset game function demonstrates information hiding!
    // We abstract away the details of resetting the game and call this happy little function!
    public void resetGame() {

        logger.info("Resetting Game ..." + "\n");

        this.adventurers = this.initialAdventurers;
        this.creatures = this.initialCreatures;
        this.foods = this.initialFoods;

        // Make sure adventurers are always sorted by hp
        sortAdventurersByHealth();

        gameOver = false;
        turnCount = 0;

        // Populate csci.ooad.arcane.Maze:
        this.maze.populate(this.adventurers, this.creatures, this.foods);

    }

    public void play() {

        logger.info("Starting Play..." + "\n");

        while (!checkGameOver()) {

            // Prints in a way to make a new line before every gameStateInfo() print.
            // Breaking the line lets the logger lose the color property,
            // allowing for all maze info to log white, like the homework guidelines.
            logger.info("ARCANE MAZE - Turn " + this.turnCount + ":\n" + gameStateInfo());

            takeTurn();

            logger.info("\n");

        }

        // Log who won
        if (adventurers.isEmpty()) {
            // Creatures won
            logger.info("Creatures number 1 victory royale!!!!" + "\n");

        } else if (creatures.isEmpty()) {
            // adventurers won
            logger.info("Adventurers got the dub!" + "\n");

        } else {
            // This probably shouldn't be reached
            logger.warn("Warning, potential error, neither adventurers nor creatures won." + "\n");
        }
    }

    public void sortAdventurersByHealth() {
        this.adventurers.sort(Comparator.comparingDouble(Adventurer::getHealth).reversed());
    }

    public void takeTurn() {

        // Add adventurers to flee list to act as delayed update of movement
        // (Prevents double updating positions)
        // This has been removed, will do a better solution with observer pattern next homework

        // Delayed movement update to avoid double updating conflicts
        // (TODO: Refactor to use observer pattern next homework

        for (Adventurer adventurer : this.adventurers) {
            adventurer.doAction();
        }

        // After all hp updates, make sure adventurers health order is updated
        sortAdventurersByHealth();

        this.turnCount ++;

    }

    public String gameStateInfo() {
        return this.maze.getInfo("\t");
    }

    // ---------- Getters / Setters ---------- //

    public void fight(Adventurer adventurer, Creature creature) {

    }

    public boolean checkGameOver() {

        // Remove all dead adventurers
        List<Adventurer> adventurersToRemove = new ArrayList<>();
        for (Adventurer adventurer : adventurers) {
            if (!adventurer.isAlive()) {
                adventurersToRemove.add(adventurer);
            }
        }

        // Remove all dead adventurers from the list
        this.adventurers.removeAll(adventurersToRemove);

        // Remove all dead creatures
        List<Creature> creaturesToRemove = new ArrayList<>();
        for (Creature creature : creatures) {
            if (!creature.isAlive()) {
                creaturesToRemove.add(creature);
            }
        }

        // Remove all dead creatures from the list
        this.creatures.removeAll(creaturesToRemove);

        this.gameOver = adventurers.isEmpty() || creatures.isEmpty();
        return this.gameOver;
    }

}



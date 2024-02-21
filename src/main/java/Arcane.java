import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Arcane {

    public static final Logger logger = LoggerFactory.getLogger(Arcane.class);

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

    // Maze:
    // Initial Creatures
    // Initial Adventurers
    // Initial Foods

    // TODO: Rememeber to remove the new food random thing

    // Below is a great example of dependency injection! Look at how the constructor accepts several dependencies!
    public Arcane (Maze maze, List<Adventurer> initialAdventurers, List<Creature> initialCreatures, List<Food> initialFoods) {

        logger.info("Creating new arcane");

        this.maze = maze;

        this.initialAdventurers = initialAdventurers;
        this.initialCreatures = initialCreatures;
        this.initialFoods = initialFoods;

        resetGame();

    }

    // Checkout how this reset game function demonstrates information hiding!
    // We abstract away the details of resetting the game and call this happy little function!
    public void resetGame() {
        this.adventurers = this.initialAdventurers;
        this.creatures = this.initialCreatures;
        this.foods = this.initialFoods;

        // Make sure adventurers are always sorted by hp
        sortAdventurersByHealth();

        gameOver = false;
        turnCount = 0;

        // Populate Maze:
        this.maze.populate(this.adventurers, this.creatures, this.foods);

    }

    public void play() {

        logger.info("Starting Play... Turn 0\n");

        logger.info(gameStateInfo());



        while (!gameOver) {


            takeTurn();

            logger.info("ARCANE MAZE: Turn " + this.turnCount);

            logger.info(gameStateInfo());

            if (checkGameOver()) break;

        }

        // Log who won
        if (adventurers.isEmpty()) {

            // Creatures won
            logger.info("Creatures number 1 victory royale!!!!");

        } else if (creatures.isEmpty()) {

            // adventurers won
            logger.info("Adventurers got the dub!");

        } else {

            // this shouln't be reached
            logger.warn("Error");

        }

    }

    public void sortAdventurersByHealth() {
        this.adventurers.sort(Comparator.comparingDouble(Adventurer::getHealth).reversed());
    }

    public void takeTurn() {

        // Add adventurers to flee list to act as delayed update of movement
        // (Prevents double updating positions)
        List<Adventurer> toMove = new ArrayList<>();

        for (Adventurer adventurer : this.adventurers) {
            // Case 1.a: (Fight)
            if (adventurer.isHealthiestInRoom() && adventurer.creaturePresentInRoom()) {

                logger.info("Adventurer " + adventurer.getInfo() + " just fought " + adventurer.getFightableCreature().getInfo());

                fight(adventurer, adventurer.getFightableCreature());

            } // Case 2: (Eat)
            else if (!(adventurer.creaturePresentInRoom()) && adventurer.foodPresentInRoom()) {
                adventurer.eat();

            }// Case 1.b and 3: (Move)
            else {
                toMove.add(adventurer);
            }
        }

        // Delayed movement update to avoid double updating conflicts
        for (Adventurer adventurer : toMove) {
            adventurer.flee();
        }

        // After all hp updates, make sure adventurers health order is updated
        sortAdventurersByHealth();

        this.turnCount ++;

    }

    public String gameStateInfo() {
        return this.maze.getInfo();
    }

    // ---------- Getters / Setters ---------- //

    public void fight(Adventurer adventurer, Creature creature) {
        double playerNumber = adventurer.playerRoll();
        double creatureNumber = creature.Creature_Roll();

        if (playerNumber == creatureNumber) {
            //System.out.println("Its a tie");
        } else if (playerNumber < creatureNumber) {
            //System.out.println("Player lost battle.");
            double playerHealth = adventurer.getHealth() - (creatureNumber - playerNumber);
            adventurer.setHealth(playerHealth);
        } else {
            //System.out.println("Player Won battle.");
            double creatureHealth = creature.getHealth() - (playerNumber - creatureNumber);
            creature.setHealth(creatureHealth);
        }

        adventurer.takeDamage(0.5);
        creature.takeDamage(0.5);

        // If creature is dead:
        if (!creature.isAlive()) {
            creatures.remove(creature);
        }

        // If adventurer is dead:
        if (!adventurer.isAlive()) {
            adventurers.remove(adventurer);
        }
    }

    public boolean checkGameOver() {
        this.gameOver = adventurers.isEmpty() || creatures.isEmpty();
        return this.gameOver;
    }

}



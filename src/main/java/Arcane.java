import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Arcane {

    private static final Logger logger = LoggerFactory.getLogger(Adventurer.class);

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

    public Arcane (Maze maze, List<Adventurer> initialAdventurers, List<Creature> initialCreatures, List<Food> initialFoods) {

        this.maze = maze;

        this.initialAdventurers = initialAdventurers;
        this.initialCreatures = initialCreatures;
        this.initialFoods = initialFoods;

        resetGame();

    }

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
        while (!gameOver) {
            takeTurn();
            logger.info(gameStateInfo());
        }

        // Log who won

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
                System.out.println(adventurer.getInfo() + " Fight!!!!");
                // fight(adventurer)


            } // Case 2: (Eat)
            else if (!(adventurer.creaturePresentInRoom()) && adventurer.foodPresentInRoom()) {
                System.out.println(adventurer.getInfo() + " EATTTTT");
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
    }

    public String gameStateInfo() {
        return this.maze.getInfo();
    }

    // ---------- Getters / Setters ---------- //

    public void fight(Adventurer adventurer, Creature creature) {
        double playerNumber = adventurer.playerRoll();
        double creatureNumber = creature.Creature_Roll();

        System.out.println("Player Rolled a " + playerNumber);
        System.out.println("Creature Rolled a " + creatureNumber);
        if (playerNumber == creatureNumber) {
            System.out.println("Its a tie");
        } else if (playerNumber < creatureNumber) {
            System.out.println("Player lost battle.");
            double playerHealth = adventurer.getHealth() - (creatureNumber - playerNumber);
            adventurer.setHealth(playerHealth);
        } else {
            System.out.println("Player Won battle.");
            double creatureHealth = creature.getHealth() - (playerNumber - creatureNumber);
            creature.setHealth(creatureHealth);
        }
    }





}



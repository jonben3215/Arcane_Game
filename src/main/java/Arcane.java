import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
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
        this.maze.populate(this.adventurers, this.creatures,this.foods);
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

        // After all hp updates, make sure adventurers health order is updated
        sortAdventurersByHealth();
    }

    public String gameStateInfo() {
        return this.maze.getInfo();
    }

    // ---------- Factory Methods for Default Settings ---------- //



    // ---------- Getters / Setters ---------- //





}



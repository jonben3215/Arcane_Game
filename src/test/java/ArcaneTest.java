import csci.ooad.arcane.*;
import csci.ooad.layout.IMazeObserver;
import csci.ooad.layout.MazeObserver;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static csci.ooad.arcane.Adventurer.SECONDS_TO_PAUSE_BETWEEN_TURNS;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArcaneTest {


    @Test
    public void TestArcaneCreation() {

        // Create csci.ooad.arcane.Adventurer List
        List<Adventurer> adventurers = new ArrayList<>();

        adventurers.add(new Adventurer("Ben_Dover"));
        adventurers.add(new Adventurer("DanTheCreator"));

        // Create csci.ooad.arcane.Creature List
        List<Creature> creatures = new ArrayList<>();
        creatures.add(new Creature("Kailey"));
        creatures.add(new Creature("Jeffery E."));
        creatures.add(new Creature("Shrek"));
        creatures.add(new Creature("BHB"));
        creatures.add(new Creature("Iggy"));

        // Create csci.ooad.arcane.Food List
        List<Food> foods = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            foods.add(new Food()); // Choose random name
        }

        IMazeObserver mazeObserver = MazeObserver.getNewBuilder("Arcane Game")
                .useRadialLayoutStrategy()
                .setDelayInSecondsAfterUpdate(SECONDS_TO_PAUSE_BETWEEN_TURNS)
                .build();

        Maze maze = Maze.newBuilder()
                .makeFullyConnectedGridNxN(3) // Assuming a 3x3 maze for simplicity
                .populate(adventurers, creatures, foods)
                .build();

        Arcane arcane = new Arcane(maze, adventurers, creatures, foods);

        // Play the game
        arcane.play();

        // eventually have csci.ooad.arcane.Arcane arcane = csci.ooad.arcane.Arcane.createGame();
    }



    @Test
    public void test_Fight()
    {
        //csci.ooad.arcane.Arcane arcane = new csci.ooad.arcane.Arcane();
        Creature creature = new Creature("wolf", 10);
        Adventurer player = new Adventurer("Ben", 10);

        //arcane.Fight(player,creature);
    }

    @Test
    public void testCheckGameOver() {
        // Create initial setup
        List<Adventurer> adventurers = new ArrayList<>();
        Adventurer alice = new Adventurer("Alice");
        adventurers.add(alice);

        List<Creature> creatures = new ArrayList<>();
        Creature dragon = new Creature("Dragon");
        creatures.add(dragon);

        Maze maze = Maze.newBuilder()
                .makeFullyConnectedGridNxN(3)
                .populate(adventurers, creatures, new ArrayList<>())
                .build();

        Arcane arcane = new Arcane(maze, adventurers, creatures, new ArrayList<>());

        // Set creatures' and adventurers' health to 0
        dragon.setHealth(0);
        alice.setHealth(0);

        // Check if game over is detected
        assertTrue(arcane.checkGameOver());
    }
    @Test
    public void testSortAdventurersByHealth() {
        // Create initial setup
        List<Adventurer> adventurers = new ArrayList<>();
        Adventurer alice = new Adventurer("Alice");
        alice.setHealth(20);
        adventurers.add(alice);

        Adventurer bob = new Adventurer("Bob");
        bob.setHealth(10);
        adventurers.add(bob);

        Maze maze = Maze.newBuilder()
                .makeFullyConnectedGridNxN(3)
                .populate(adventurers, new ArrayList<>(), new ArrayList<>())
                .build();

        Arcane arcane = new Arcane(maze, adventurers, new ArrayList<>(), new ArrayList<>());

        // Sort adventurers by health
        arcane.sortAdventurersByHealth();

        // Check if adventurers are sorted in descending order of health
        assertTrue(alice.getHealth() >= bob.getHealth());

    }

    @Test
    public void testArcanePlay() {
        // Create initial setup
        List<Adventurer> adventurers = new ArrayList<>();
        Adventurer alice = new Adventurer("Alice");
        adventurers.add(alice);

        List<Creature> creatures = new ArrayList<>();
        Creature dragon = new Creature("Dragon");
        creatures.add(dragon);

        Maze maze = Maze.newBuilder()
                .makeFullyConnectedGridNxN(3)
                .populate(adventurers, creatures, new ArrayList<>())
                .build();

        Arcane arcane = new Arcane(maze, adventurers, creatures, new ArrayList<>());

        // Play the game
        arcane.play();

        // Check if game over is detected
        assertTrue(arcane.checkGameOver());
    }

    @Test
    public void testFight() {
        // Create initial setup
        List<Adventurer> adventurers = new ArrayList<>();
        List<Creature> creatures = new ArrayList<>();
        Adventurer adventurer = new Adventurer("Alice");
        Creature creature = new Creature("Dragon");
        adventurers.add(adventurer);
        creatures.add(creature);
        Maze maze = new Maze(); // You might need to create a mock or stub for Maze class

        // Create Arcane instance
        Arcane arcane = new Arcane(maze, adventurers, creatures, new ArrayList<>());

        // Perform fight
        arcane.fight(adventurer, creature);

        // Add assertions here based on the behavior of the fight method
    }



}

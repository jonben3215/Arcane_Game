import csci.ooad.arcane.*;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

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

        Maze maze = Maze.newBuilder().defaultEmpty3x3().build();
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



}

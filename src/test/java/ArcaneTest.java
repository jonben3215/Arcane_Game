import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

public class ArcaneTest {


    @Test
    public void TestArcaneCreation() {

        // Create Adventurer List
        List<Adventurer> adventurers = new ArrayList<>();

        adventurers.add(new Adventurer("Ben_Dover"));
        adventurers.add(new Adventurer("DanTheCreator"));

        // Create Creature List
        List<Creature> creatures = new ArrayList<>();
        creatures.add(new Creature("Kailey"));
        creatures.add(new Creature("Jeffery E."));
        creatures.add(new Creature("Shrek"));
        creatures.add(new Creature("BHB"));
        creatures.add(new Creature("Iggy"));

        // Create Food List
        List<Food> foods = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            foods.add(new Food()); // Choose random name
        }

        String[] roomNames3x3 = {"Northwest", "North", "Northeast", "West", "Center", "East", "Southwest", "South", "Southeast"};
        Maze maze = new Maze(3,roomNames3x3);
        Arcane arcane = new Arcane(maze, adventurers, creatures, foods);

        arcane.play();

        // eventually have Arcane arcane = Arcane.createGame();
    }



    @Test
    public void test_Fight()
    {
        //Arcane arcane = new Arcane();
        Creature creature = new Creature("wolf", 10);
        Adventurer player = new Adventurer("Ben", 10);

        //arcane.Fight(player,creature);
    }



}

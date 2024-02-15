import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MazeTest {

    // Use as input for 3x3 maze room names for clear debugging

    @Test
    public void TestMazeConstruction() {

        Maze maze = new Maze();
        assertNotNull(maze);

        // TODO Check Default Values
    }

    @Test
    public void testNxNMazeCreation() {

        Maze maze = new Maze();
        assertNotNull(maze);

        int n = 20;

        maze.generateNxN(n);

        assertNull(maze.getRoomByID(-1));

        ArrayList<Room> rectRoomArray = maze.getRooms();

        Room nwCorner = rectRoomArray.get(0);
        Room neCorner = rectRoomArray.get(n-1);
        Room swCorner = rectRoomArray.get(rectRoomArray.size()-n);
        Room seCorner = rectRoomArray.get(rectRoomArray.size()-1);

    }

    @Test
    public void testDisplay2DMaze() {
        Maze maze2x2 = Maze.defaultEmpty2x2();
        maze2x2.display2D();

        Maze maze3x3 = Maze.defaultEmpty3x3();
        maze3x3.display2D();
    }

    @Test
    public void TestFoodSpawn() {
        Maze maze = Maze.defaultEmpty3x3();

        // Create Food List
        List<Food> foods = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            foods.add(new Food()); // Choose random name
        }

        // Spawn food items at random locations
        maze.populateFood(foods);

        // Display the maze to inspect the distribution of food items
        maze.display2D();
    }
    @Test
    public void TestAdventurerCreatureSpawn() {
        Maze maze = Maze.defaultEmpty3x3();

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

        maze.populateAdventurers(adventurers);
        maze.populateCreatures(creatures);

    }


    @Test
    public void TestEmptyNxNGetInfo() {

        Maze maze3x3 = Maze.defaultEmpty3x3();
        Maze maze2x2 = Maze.defaultEmpty2x2();

        String mazeInfo3x3 = maze3x3.getInfo();
        String mazeInfo2x2 = maze2x2.getInfo();

        // TODO: Remake expected info

        System.out.println(maze3x3.getInfo());

//        assertEquals(mazeInfo2x2, expectedInfo2x2);
//        assertEquals(mazeInfo3x3, expectedInfo3x3);
    }

    @Test
    public void TestDefault3x3PopulateCreation() {

        Maze maze = Maze.defaultEmpty3x3();

        String mazeInfo = maze.getInfo();
        System.out.println(mazeInfo);

    }
}
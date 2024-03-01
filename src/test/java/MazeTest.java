import csci.ooad.arcane.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MazeTest {

    // Use as input for 3x3 maze room names for clear debugging

    public static final Maze emptyMaze = new Maze();

    @Test
    public void testNxNMazeCreation() {

        Maze m = Maze.newBuilder()
                .makeFullyConnectedGridNxN(3)
                .build();

        System.out.print(m.getInfo());
        assertNotNull(m);


    }

    // TODO: Will need to finish the display 2D Function in maze to run this test
    @Test
    public void testDisplay2DMaze() {
//        String[] roomNames2x2 = {"Northwest", "Northeast", "Southwest", "Southeast"};
//        Maze maze2x2 = new Maze(2, roomNames2x2);
//        maze2x2.display2D();
//        String[] roomNames3x3 = {"Northwest", "North", "Northeast", "West", "Center", "East", "Southwest", "South", "Southeast"};
//        Maze maze3x3 = new Maze(3, roomNames3x3);
//        maze3x3.display2D();
    }

    @Test
    public void TestFoodSpawn() {

//        List <Food> foods = new ArrayList<>();
//        foods.add(new Food("Apple"));
//        foods.add(new Food("Banana"));
//        foods.add(new Food("Carrot"));
//        foods.add(new Food("Cucumber"));
//
//    Maze m = Maze.newBuilder()
//            .makeFullyConnectedGridNxN(3)
//            .populateFoods(foods);
//            .build();
//
//        int roomsWithFood = 0;
//        for (Room room : m.getRooms()) {
//            if (room.getFoods().stream().anyMatch(entity -> entity instanceof Food)) {
//                roomsWithFood++;
//            }
//        }
//
//        System.out.println(roomsWithFood);
//
//        assertEquals(foods.size(), roomsWithFood);

    }
    @Test
    public void TestAdventurerCreatureSpawn() {
//        String[] roomNames3x3 = {"Northwest", "North", "Northeast", "West", "Center", "East", "Southwest", "South", "Southeast"};
//        Maze maze = new Maze(3,roomNames3x3);
//
//        // Create csci.ooad.arcane.Adventurer List
//        List<Adventurer> adventurers = new ArrayList<>();
//        adventurers.add(new Adventurer("Ben_Dover"));
//        adventurers.add(new Adventurer("DanTheCreator"));
//
//        // Create csci.ooad.arcane.Creature List
//        List<Creature> creatures = new ArrayList<>();
//        creatures.add(new Creature("Kailey"));
//        creatures.add(new Creature("Jeffery E."));
//        creatures.add(new Creature("Shrek"));
//        creatures.add(new Creature("BHB"));
//        creatures.add(new Creature("Iggy"));
//
//        maze.populateAdventurers(adventurers);
//        maze.populateCreatures(creatures);

    }


    @Test
    public void TestEmptyNxNGetInfo() {

//        String[] roomNames3x3 = {"Northwest", "North", "Northeast", "West", "Center", "East", "Southwest", "South", "Southeast"};
//        Maze maze3x3 = new Maze(3,roomNames3x3);
//
//        String[] roomNames2x2 = {"Northwest", "Northeast", "Southwest", "Southeast"};
//        Maze maze2x2 = new Maze(2,roomNames2x2);
//
//        String mazeInfo3x3 = maze3x3.getInfo();
//        String mazeInfo2x2 = maze2x2.getInfo();
//
//        // TODO: Remake expected info
//
//        System.out.println(maze3x3.getInfo());

//        assertEquals(mazeInfo2x2, expectedInfo2x2);
//        assertEquals(mazeInfo3x3, expectedInfo3x3);

        String[] roomNames3x3 = {"Northwest", "North", "Northeast", "West", "Center", "East", "Southwest", "South", "Southeast"};
        Maze maze3x3 = Maze.newBuilder()
                .makeFullyConnectedGridNxN(3)
                .nameRooms(roomNames3x3).build();

        String expectedInfo3x3 = maze3x3.getInfo();

//        System.out.println(expectedInfo3x3);
//        System.out.println();
//        System.out.println(maze3x3.getInfo());

        assertEquals(expectedInfo3x3, maze3x3.getInfo());
    }

    @Test
    public void TestDefault3x3PopulateCreation() {

         Maze m = Maze.newBuilder()
                 .makeFullyConnectedGridNxN(10)
                 .numberRooms()
                 .build();

         System.out.print(m.getInfo());
         System.out.println(m.getRoomByName("Room 5").getNeighbors());
    }
}
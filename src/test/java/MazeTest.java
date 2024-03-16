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
    public void TestEmptyNxNGetInfo() {



        String[] roomNames3x3 = {"Northwest", "North", "Northeast", "West", "Center", "East", "Southwest", "South", "Southeast"};
        Maze maze3x3 = Maze.newBuilder()
                .makeFullyConnectedGridNxN(3)
                .nameRooms(roomNames3x3).build();

        String expectedInfo3x3 = maze3x3.getInfo();

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
    @Test
    public void testRoomConnection() {
        Maze m = Maze.newBuilder()
                .makeFullyConnectedGridNxN(3)
                .build();

        // Iterate over rooms and check if neighbors are correctly connected
        for (Room room : m.getRooms()) {
            for (Direction dir : Direction.values()) {
                Room neighbor = room.getNeighbor(dir);
                if (neighbor != null) {
                    assertEquals(room, neighbor.getNeighbor(dir.getOpposite()), "Neighbor connection mismatch");
                }
            }
        }
    }

    @Test
    public void testEmptyMazeCreation() {
        Maze emptyMaze = new Maze();
        assertNotNull(emptyMaze);
        assertEquals(0, emptyMaze.getNumRooms());
    }

    @Test
    public void testSequentialDistribution() {
        String[] expectedRoomNames = {"Northwest", "North", "Northeast", "West", "Center", "East", "Southwest", "South", "Southeast"};

        Maze m = Maze.newBuilder()
                .makeFullyConnectedGridNxN(3)
                .nameRooms(expectedRoomNames) // Explicitly assign room names
                .build();

        assertNotNull(m);

        ArrayList<Room> rooms = m.getRooms();
        for (int i = 0; i < rooms.size(); i++) {
            assertEquals(expectedRoomNames[i], rooms.get(i).getName());
        }
    }

    @Test
    public void testEntityAdditionToSpecificRoom() {
        Maze maze = Maze.newBuilder()
                .makeFullyConnectedGridNxN(3)
                .numberRooms()
                .build();

        // Assuming you have methods to add entities directly to Rooms
        Room targetRoom = maze.getRoomByName("Room 5");
        Adventurer adventurer = new Adventurer("Hero");
        Creature creature = new Creature("Goblin");
        Food food = new Food("Apple");

        targetRoom.addAdventurer(adventurer);
        targetRoom.addCreature(creature);
        targetRoom.addFood(food);

        assertTrue(targetRoom.getAdventurers().contains(adventurer));
        assertTrue(targetRoom.getCreatures().contains(creature));
        assertTrue(targetRoom.getFoods().contains(food));
    }

    @Test
    public void testMazeInfoStringConsistency() {
        Maze maze = Maze.newBuilder()
                .makeFullyConnectedGridNxN(2) // Simpler 2x2 maze for this test
                .numberRooms()
                .build();

        // The expected info string will depend on how you've implemented getInfo()
        // For simplicity, assuming getInfo() returns a string with room names
        String info = maze.getInfo();
        assertTrue(info.contains("Room 1"));
        assertTrue(info.contains("Room 2"));
        assertTrue(info.contains("Room 3"));
        assertTrue(info.contains("Room 4"));
        // Add checks for specific formatting or contents as needed
    }

    @Test
    public void testBehaviorWithNoRooms() {
        Maze emptyMaze = new Maze(new ArrayList<>()); // Explicitly creating an empty maze

        assertNull(emptyMaze.getRoomByName("Any Room"), "Expected null when fetching a room from an empty maze.");
        assertTrue(emptyMaze.getRooms().isEmpty(), "Expected no rooms in an empty maze.");
    }




}
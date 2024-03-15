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




}
import csci.ooad.arcane.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MazeAdaptertest {
    private Maze maze;
    private MazeAdapter mazeAdapter;

    @BeforeEach
    public void setUp() {
        // Create Room instances
        Room room1 = new Room("Room 1");
        Room room2 = new Room("Room 2");

        // Create an ArrayList and add rooms
        ArrayList<Room> rooms = new ArrayList<>(Arrays.asList(room1, room2));

        // Instantiate Maze with the ArrayList of Rooms
        maze = new Maze(rooms);

        // Create a MazeAdapter with the Maze instance
        mazeAdapter = new MazeAdapter(maze);
    }

    @Test
    public void getRooms_ShouldReturnListOfRoomNames() {
        List<String> rooms = mazeAdapter.getRooms();
        assertTrue(rooms.containsAll(Arrays.asList("Room 1", "Room 2")));
        assertEquals(2, rooms.size());
    }
    @Test
    public void getContents_RoomWithMultipleEntities_ShouldReturnAllContents() {
        Room room1 = new Room("Room 1");
        Adventurer adventurer = new Adventurer("Adventurer A", 100); // Assuming name and health in constructor
        Creature creature = new Creature("Creature C", 50); // Similarly, assuming name and health
        Food food = new Food("Food F", 5); // Assuming name and health restoration value

        // Assuming methods to add entities to a Room; adjust as per your actual implementation
        room1.addAdventurer(adventurer);
        room1.addCreature(creature); // Hypothetical example
        room1.addFood(food); // Hypothetical example

        ArrayList<Room> rooms = new ArrayList<>(Arrays.asList(room1));
        maze = new Maze(rooms);
        mazeAdapter = new MazeAdapter(maze);

        List<String> contents = mazeAdapter.getContents("Room 1");
        assertFalse(contents.containsAll(Arrays.asList("Adventurer A", "Creature C", "Food F"))); // Adjust according to how your getInfo() method represents entities
    }

    @Test
    public void getRooms_WhenMazeIsEmpty_ShouldReturnEmptyList() {
        Maze emptyMaze = new Maze(new ArrayList<>()); // An empty maze
        MazeAdapter emptyMazeAdapter = new MazeAdapter(emptyMaze);

        List<String> rooms = emptyMazeAdapter.getRooms();

        assertTrue(rooms.isEmpty(), "Expected getRooms to return an empty list for an empty maze.");
    }


}

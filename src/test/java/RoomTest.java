import csci.ooad.arcane.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;



public class RoomTest
{

    // Test Rooms
    Room default_room = new Room();

    @Test
    public void TestRoomDefaultConstructor() {
        assertNotNull(default_room);
    }

    @Test
    public void testRoomID() {
        // Generate Sample Default Rooms
        Room room1 = new Room();
        Room room2 = new Room();
        Room room3 = new Room();
        Room room4 = new Room();

        // Check that IDs are set (>0)
        assertNotEquals(room1.getID(), -1);
        assertNotEquals(room2.getID(), -1);
        assertNotEquals(room3.getID(), -1);
        assertNotEquals(room4.getID(), -1);

        // Check that IDs are unique
        assertNotEquals(room1.getID(), room2.getID());
        assertNotEquals(room2.getID(), room3.getID());
        assertNotEquals(room3.getID(), room4.getID());
        assertNotEquals(room4.getID(), room1.getID());
        assertNotEquals(room1.getID(), room3.getID());
        assertNotEquals(room2.getID(), room4.getID());
    }

    @Test
    public void TestRoomGetSetName() {

        // .getName DEFAULT
        Room r = new Room();
        String default_name = r.getName();
        int r_id = r.getID(); // Default name == ID
        assertEquals(default_name, Integer.toString(r_id));

        // .setName
        String new_name = "North West";
        r.setName(new_name);
        assertEquals(r.getName(), new_name);

        // Primitive Tests (legacy)
        String room1ExpectedName = "Starting csci.ooad.arcane.Room";
        String room2ExpectedName = "Second csci.ooad.arcane.Room";
        String room3ExpectedName = "Third csci.ooad.arcane.Room";
        String room4ExpectedName = "Last csci.ooad.arcane.Room";

        Room room1 = new Room("Starting csci.ooad.arcane.Room");
        Room room2 = new Room("Second csci.ooad.arcane.Room");
        Room room3 = new Room("Third csci.ooad.arcane.Room");
        Room room4 = new Room("Last csci.ooad.arcane.Room");

        assertEquals(room1ExpectedName, room1.getName());
        assertEquals(room2ExpectedName, room2.getName());
        assertEquals(room3ExpectedName, room3.getName());
        assertEquals(room4ExpectedName, room4.getName());

    }

    @Test
    public void TestGetSetNeighbors() {

        Room room = new Room();
        Room north = new Room();
        Room south = new Room();
        Room east = new Room();
        Room west = new Room();

        room.addNeighbor(Direction.N, north);
        room.addNeighbor(Direction.S, south);
        room.addNeighbor(Direction.E, east);
        room.addNeighbor(Direction.W, west);

        Map<Direction, Room> neighbors = room.getNeighbors();

        System.out.println(neighbors);

        assertEquals(north, room.getNeighbor(Direction.N));
        assertEquals(south, room.getNeighbor(Direction.S));
        assertEquals(east, room.getNeighbor(Direction.E));
        assertEquals(west, room.getNeighbor(Direction.W));

        Room removed_north = room.removeNeighbor(Direction.N);
        assertEquals(removed_north, north);
        assertNull(room.getNeighbor(Direction.N));
        removed_north = room.removeNeighbor(Direction.N);
        assertNull(removed_north);

        Room removed_south = room.removeNeighbor(south);
        assertEquals(removed_south, south);
        assertNull(room.getNeighbor(Direction.S));
        removed_south = room.removeNeighbor(south);
        assertNull(removed_south);

    }

    @Test
    public void TestGetAddAdventurers() {

        Room room = new Room();
        List<Adventurer> expectedAdventurers = new ArrayList<>();
        assertTrue(room.getAdventurers().isEmpty());

        Adventurer a = new Adventurer("Bob", 5);
        room.addAdventurer(a);
        expectedAdventurers.add(a);
        assertEquals(expectedAdventurers, room.getAdventurers());

        room.removeAdventurer(a);
        assertTrue(room.getAdventurers().isEmpty());


    }

    @Test
    public void TestAddSortRemoveAdventurers() {

        Room room = new Room();

        // Add adventurers in unsorted order
        room.addAdventurer(new Adventurer("lower_quartile", 3));
        room.addAdventurer(new Adventurer("low", 1));
        room.addAdventurer(new Adventurer("high", 10));
        room.addAdventurer(new Adventurer("upper_quartile", 8));
        room.addAdventurer(new Adventurer("middle", 5));

        // Check if they sorted by highest hp
        String[] expected = {"high", "upper_quartile", "middle", "lower_quartile", "low"};
        ArrayList<Adventurer> sorted_adventurers = (ArrayList<Adventurer>) room.getAdventurers();
        boolean match = true;
        for(int i=0; i< expected.length; i++) {
            // If expected and sorted do not match, break and return false
            if (!(expected[i].equals(sorted_adventurers.get(i).getName()))) {
                match = false;
                break;
            }
        }

        // Assert check
        assertTrue(match);

        // TODO if linked list approach does not work
        // room.removeAdventurer(a);

    }

    @Test
    public void TestGetAddRemoveCreatures() {
        Room room = new Room();
        List<Creature> expectedCreatures = new ArrayList<>();
        assertTrue(room.getCreatures().isEmpty());

        Creature c = new Creature("Bob", 5);
        room.addCreature(c);
        expectedCreatures.add(c);
        assertEquals(expectedCreatures, room.getCreatures());

        // TODO if linked list approach does not work
         room.removeCreature(c);
         assertTrue(room.getCreatures().isEmpty());
    }

    @Test
    public void TestSortCreatures() {

        Room room = new Room();

        // Add creatures in unsorted order
        room.addCreature(new Creature("lower_quartile", 3));
        room.addCreature(new Creature("low", 1));
        room.addCreature(new Creature("high", 10));
        room.addCreature(new Creature("upper_quartile", 8));
        room.addCreature(new Creature("middle", 5));

        // Check if they sorted by highest hp
        String[] expected = {"high", "upper_quartile", "middle", "lower_quartile", "low"};
        ArrayList<Creature> sorted_creatures = (ArrayList<Creature>) room.getCreatures();
        boolean match = true;
        for(int i=0; i< expected.length; i++) {
            // If expected and sorted do not match, break and return false
            if (!(expected[i].equals(sorted_creatures.get(i).getName()))) {
                match = false;
                break;
            }
        }

        // Assert check
        assertTrue(match);
    }

    @Test
    public void TestGetAddFoods() {
        Room room = new Room();
        List<Food> expectedFood = new ArrayList<>();
        assertTrue(room.getFoods().isEmpty());

        Food f = new Food("Apple");
        room.addFood(f);
        expectedFood.add(f);
        assertEquals(expectedFood, room.getFoods());
        room.removeFood(f);
        assertTrue(room.getFoods().isEmpty());
    }

    @Test
    public void TestGetInfo () {
        //String expected = default_room.getName() + ":\n\tAdventurers:\n\tCreatures:\n\tFood:";
        //assertEquals(default_room.getInfo(), expected);
        //default_room.addFood(new csci.ooad.arcane.Food());
        System.out.println(default_room.getInfo());
    }

    @Test
    public void testNameConstructor() {
        Room room1 = new Room("Room1");
        Room room2 = new Room("Room2");
        Room room3 = new Room("Room3");
        Room room4 = new Room("Room4");

        assertNotNull(room1);
        assertNotNull(room2);
        assertNotNull(room3);
        assertNotNull(room4);
    }

    @Test
    public void DescriptionTest () {

        // Test Static Description and Dynamic Description

        // TODO wait until actually know how text file behavior will be done

        String file_name_2 = "/todo/todo/actual_to_be_used_path_name.txt";  // Should Work
        String file_name_1 = "description_file_name.txt";                   // Should Work
        String file_name_3 = "ewoijwofepqwjief";                            // Bad File
        String file_name_4 = "file.poop";                                   // Bad File

        // Test file_name_1 - Good File
        Room.setDescriptionFileName(file_name_1);
        assertEquals(file_name_1, Room.getDescriptionFileName());

        // Test file_name_2 - Good File
        Room.setDescriptionFileName(file_name_2);
        assertEquals(file_name_2, Room.getDescriptionFileName());

//        // Test file_name_3 - Bad File
//        csci.ooad.arcane.Room.setDescriptionFileName(file_name_3);
//        assertNotEquals(file_name_3, csci.ooad.arcane.Room.getDescriptionFileName());
//
//        // Test file_name_4 - Bad File
//        csci.ooad.arcane.Room.setDescriptionFileName(file_name_4);
//        assertNotEquals(file_name_4, csci.ooad.arcane.Room.getDescriptionFileName());

        // TODO LowPrio Add file proofing so only valid txt files in the correct format can be used for the description file
    }

}

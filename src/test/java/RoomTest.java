import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class RoomTest
{

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
//        Room.setDescriptionFileName(file_name_3);
//        assertNotEquals(file_name_3, Room.getDescriptionFileName());
//
//        // Test file_name_4 - Bad File
//        Room.setDescriptionFileName(file_name_4);
//        assertNotEquals(file_name_4, Room.getDescriptionFileName());

        // TODO LowPrio Add file proofing so only valid txt files in the correct format can be used for the description file
    }

    @Test
    public void DefaultRoomCreation() {
        Room room = new Room();
        assertNotNull(room);

        // TODO Check ALL Default Values

        // TODO Check default neighbors are all null

        // TODO Once description is better implemented, check if good description

        assertNotNull(room.getDescription());


    }

    @Test
    public void testRoomIDGeneration() {

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
    public void testRoomCreation()
    {
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
    public void testRoomName()
    {
        String room1ExpectedName = "Starting Room";
        String room2ExpectedName = "Second Room";
        String room3ExpectedName = "Third Room";
        String room4ExpectedName = "Last Room";

        Room room1 = new Room("Starting Room");
        Room room2 = new Room("Second Room");
        Room room3 = new Room("Third Room");
        Room room4 = new Room("Last Room");

        assertEquals(room1ExpectedName, room1.getName());
        assertEquals(room2ExpectedName, room2.getName());
        assertEquals(room3ExpectedName, room3.getName());
        assertEquals(room4ExpectedName, room4.getName());
    }
}

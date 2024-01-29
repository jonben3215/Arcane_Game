import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RoomTest
{
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
    public void ConfirmName()
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

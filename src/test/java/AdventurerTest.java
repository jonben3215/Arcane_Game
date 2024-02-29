import csci.ooad.arcane.Adventurer;
import csci.ooad.arcane.Direction;
import csci.ooad.arcane.Maze;
import csci.ooad.arcane.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdventurerTest {

    String[] roomNames3x3 = {"Northwest", "North", "Northeast", "West", "Center", "East", "Southwest", "South", "Southeast"};

    @Test
    public void TestAdventurerCreation() {
       String Name  = "Ben";
       int health = 10;

       Adventurer player1 = new Adventurer(Name, health);

       assertNotNull(player1);
    }
    @Test
    public void TestGetHealth() {
        String Name  = "Ben";
        int health = 10;

        Adventurer player1 = new Adventurer(Name, health);
       assertEquals(health, player1.getHealth());
    }
    @Test
    public void TestSetHealth() {

        String Name  = "Ben";
        int health = 10;
        int new_Health = 8;

        Adventurer player1 = new Adventurer(Name, health);
        player1.setHealth(new_Health);
        assertEquals(new_Health, player1.getHealth());
    }
    @Test
    public void TestGetName() {
        String Name  = "Ben";
        int health = 10;

        Adventurer player1 = new Adventurer(Name, health);
        assertNotNull(player1.getName());
    }
    @Test
    public void TestSetName() {
        String Name  = "Ben";
        String newName = "William";
        int health = 10;

        Adventurer player1 = new Adventurer(Name, health);
        player1.setName(newName);

        assertEquals(newName, player1.getName());
    }

    @Test
    public void TestRoom() {

        Room r = new Room();
        Adventurer a = new Adventurer();
        a.setName("Billy");
        a.setHealth(999.999);
        a.setRoom(r);

        assertEquals(r, a.getRoom());
    }

    //Thats a lot damage
    @Test
    public void TestTakeDamage() {
        Adventurer a1 = new Adventurer();
        a1.setHealth(5);
        assertTrue(a1.isAlive());

        a1.takeDamage(-4);
        assertTrue(a1.isAlive());
        assertEquals(5, a1.getHealth());

        a1.takeDamage(3);
        assertTrue(a1.isAlive());
        assertEquals(2, a1.getHealth());

        a1.takeDamage(3);
        assertFalse(a1.isAlive());

    }

    @Test
    public void TestIsAlive() {
        String Name  = "Ben";
        double health = 0;
        double new_Health = 8;

        Adventurer a1 = new Adventurer(Name, health);
        //assertTrue(player1.isAlive());

        a1.setHealth(0);
        assertFalse(a1.isAlive());

    }

    @Test
    public void test_player_Movement() {

        Adventurer a1 = new Adventurer("Ben Dover", 5);

        Maze m = Maze.newBuilder().defaultEmpty3x3().build();
        Room r = m.getRooms().get(4); // 3,3 i think
        a1.setRoom(r);
        a1.move(Direction.N);

        //assertEquals(a1.getRoom(), m.getRooms().get(1));
    }

    @Test
    public void TestFlee () {

        Adventurer a1 = new Adventurer("Ben Dover", 5);

        Maze m = Maze.newBuilder().defaultEmpty3x3().build();// 0 1 2, 3 4 5, 6 7 8
        Room r = m.getRooms().get(4); // 3,3 i think

        boolean different_behavior = false;
        for (int i=0; i<10; i++) {
            a1.setRoom(r);
            
        }
    }

    @Test
    public void test_PlayerRoll() {
        Adventurer player1 = new Adventurer("Ben", 10);

        double roll_Number = player1.calcDamage();

        //Making sure the Generated number is within 1 and 6
        if(roll_Number >= 1 && roll_Number <= 6)
            assert true;
        else
            assert false;
    }

    @Test
    public void test_AdventureDeath()
    {
        Adventurer player1 = new Adventurer("Bruh", 0);
        assertTrue(player1.isAlive());

    }
}

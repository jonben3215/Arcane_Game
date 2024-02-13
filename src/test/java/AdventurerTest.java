import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdventurerTest {

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
        String Name  = "Ben";
        int health = 0;
        // int health = 1;
        int new_Health = 8;

        Adventurer player1 = new Adventurer(Name, health);

        int roomIdx= 1;
        Maze m= new Maze();
        m.GenerateRectangleMaze(3, 3);

        m.Display(3,3);
        //System.out.println(m.roomExists(roomIdx,3,3));

        player1.player_Movement(m, 2);
        player1.player_Movement(m, 3);
    }

    @Test
    public void test_PlayerRoll() {
        Adventurer player1 = new Adventurer("Ben", 10);

        int roll_Number = player1.playerRoll();

        //Making sure the Generated number is within 1 and 6
        if(roll_Number >= 1 && roll_Number <= 6)
            assert true;
        else
            assert false;
    }
}

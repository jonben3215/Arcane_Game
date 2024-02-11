import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void PlayerCreation()
    {
       String Name  = "Ben";
       int health = 10;

       Player player1 = new Player(Name, health);

       assertNotNull(player1);
    }

    @Test
    public void Test_getname()
    {
        String Name  = "Ben";
        int health = 10;

        Player player1 = new Player(Name, health);
        assertNotNull(player1.getName());
    }
    @Test
    public void Test_getHealth()
    {
        String Name  = "Ben";
        int health = 10;

        Player player1 = new Player(Name, health);
       assertEquals(health, player1.getHealth());
    }
    @Test
    public void Test_setName()
    {
        String Name  = "Ben";
        String newName = "William";
        int health = 10;

        Player player1 = new Player(Name, health);
        player1.setName(newName);

        assertEquals(newName, player1.getName());
    }

    @Test
    public void Test_setHealth()
    {
        String Name  = "Ben";
        int health = 10;
        int new_Health = 8;

        Player player1 = new Player(Name, health);
        player1.setHealth(new_Health);
        assertEquals(new_Health, player1.getHealth());
    }

    @Test
    public void test_isAlive()
    {
        String Name  = "Ben";
        int health = 0;
       // int health = 1;
        int new_Health = 8;

        Player player1 = new Player(Name, health);
        //assertTrue(player1.isAlive());

        player1.setHealth(0);
        assertFalse(player1.isAlive());

    }

    @Test
    public void test_player_Movement()
    {

        int roomIdx= 200;
        Maze m= new Maze();
        m.GenerateRectangleMaze(3, 3);
        System.out.println(m.roomExists(roomIdx,3,3));

    }

}

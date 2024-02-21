import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void PlayerCreation()
    {
       String Name  = "Ben";
       int health = 10;

       Adventurer player1 = new Adventurer(Name, health);

       assertNotNull(player1);
    }

    @Test
    public void Test_getname()
    {
        String Name  = "Ben";
        int health = 10;

        Adventurer player1 = new Adventurer(Name, health);
        assertNotNull(player1.getName());
    }
    @Test
    public void Test_getHealth()
    {
        String Name  = "Ben";
        int health = 10;

        Adventurer player1 = new Adventurer(Name, health);
       assertEquals(health, player1.getHealth());
    }
    @Test
    public void Test_setName()
    {
        String Name  = "Ben";
        String newName = "William";
        int health = 10;

        Adventurer player1 = new Adventurer(Name, health);
        player1.setName(newName);

        assertEquals(newName, player1.getName());
    }

    @Test
    public void Test_setHealth()
    {
        String Name  = "Ben";
        int health = 10;
        int new_Health = 8;

        Adventurer player1 = new Adventurer(Name, health);
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

        Adventurer player1 = new Adventurer(Name, health);
        //assertTrue(player1.isAlive());

        player1.setHealth(0);
        assertFalse(player1.isAlive());

    }

    @Test
    public void test_player_Movement()
    {
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
        System.out.println(player1.getPosition());
    }

    @Test
    public void test_PlayerRoll()
    {
        Adventurer player1 = new Adventurer("Ben", 10);

        int roll_Number = player1.playerRoll();

        //Making sure the Generated number is within 1 and 6
        if(roll_Number >= 1 && roll_Number <= 6)
            assert true;
        else
            assert false;
    }

}

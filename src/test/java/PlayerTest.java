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

}

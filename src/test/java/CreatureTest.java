import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreatureTest {

    @Test
    public void CreatureCreation()
    {
        Creature Creature_1 = new Creature("Goblin", 10);
        assertNotNull(Creature_1);
    }

    @Test

    public void Test_getName()
    {

        Creature Creature_1 = new Creature("Goblin", 10);
        assertEquals("Goblin", Creature_1.getName());
    }

    @Test
    public void test_isAlive()
    {
        String Name  = "Ben";
        int health = 0;
        // int health = 1;
        int new_Health = 8;

        Creature creature1 = new Creature (Name, health);
        //assertTrue(player1.isAlive());

        assertFalse(creature1.isAlive());

    }

}

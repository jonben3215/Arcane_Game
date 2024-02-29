import csci.ooad.arcane.Creature;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreatureTest {

    @Test
    public void CreatureCreation() {
        Creature Creature_1 = new Creature("Goblin", 10);
        assertNotNull(Creature_1);
    }

    @Test

    public void Test_getName() {

        Creature Creature_1 = new Creature("Goblin", 10);
        assertEquals("Goblin", Creature_1.getName());
    }

    @Test
    public void test_isAlive() {
        String Name  = "Ben";
        int health = 0;
        // int health = 1;
        int new_Health = 8;

        Creature creature1 = new Creature (Name, health);
        //assertTrue(player1.isAlive());

        assertFalse(creature1.isAlive());
    }

    @Test
    public void test_CreatureRoll() {
        Creature creature1 = new Creature ("Ogre", 10);

        double roll_Number = creature1.calcDamage();

        //Making sure the Generated number is within 1 and 6
        if(roll_Number >= 1 && roll_Number <= 6)
            assert true;
        else
            assert false;
    }
}


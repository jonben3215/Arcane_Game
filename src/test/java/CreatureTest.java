import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @Test
    public void test_CreatureRoll()
    {
        Creature creature1 = new Creature ("Oger", 10);

        int roll_Number = creature1.Creature_Roll();

        //Making sure the Generated number is within 1 and 6
        if(roll_Number >= 1 && roll_Number <= 6)
            assert true;
        else
            assert false;
    }
    @Test
    public void testSpawnAndDisplayCreaturePosition() {
        // Create a maze
        Maze maze = new Maze();
        maze.GenerateRectangleMaze(3, 3); // Assuming a 3x3 maze

        // Create a creature
        Creature creature = new Creature("CreatureName", 10);

        // Spawn creatures in the maze
        creature.spawnCreature(maze);

        // Display creature positions
       // creature.displayCreaturePosition();
        creature.checkIfCreature(5);
    }


}

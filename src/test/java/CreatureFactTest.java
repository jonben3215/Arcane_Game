import csci.ooad.arcane.Creature;
import csci.ooad.arcane.CreatureFactory;
import csci.ooad.arcane.Demon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreatureFactTest {

    @Test
    public void testCreateCreature() {
        // Create a CreatureFactory instance
        CreatureFactory factory = new CreatureFactory();

        // Define a creature name
        String creatureName = "Goblin";

        // Create a creature using the factory method
        Creature creature = factory.createCreature(creatureName);

        // Assert that the creature is not null
        assertNotNull(creature);

        // Assert that the creature has the correct name
        assertEquals(creatureName, creature.getName());
    }
    @Test
    public void testCreateDemon() {
        // Create a CreatureFactory instance
        CreatureFactory factory = new CreatureFactory();

        // Define a demon name
        String demonName = "Demon";

        // Create a demon using the factory method
        Demon demon = factory.createDemon(demonName);

        // Assert that the demon is not null
        assertNotNull(demon);

        // Assert that the demon has the correct name
        assertEquals(demonName, demon.getName());
    }

}

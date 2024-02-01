import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreatureTest {

    @Test
    public void CreatureCreation()
    {
        Creature Creature_1 = new Creature("Goblin");
        assertNotNull(Creature_1);
    }

    @Test

    public void Test_getName()
    {
        Creature Creature_1 = new Creature("Goblin");
        assertEquals("Goblin", Creature_1.getName());
    }

}

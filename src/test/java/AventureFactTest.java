import csci.ooad.arcane.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AventureFactTest {
    @Test
    public void testCreateAdventurer() {
        AdventurerFactory factory = new AdventurerFactory();
        String adventurerName = "John";

        Adventurer adventurer = factory.createAdventurer(adventurerName);

        assertNotNull(adventurer);
        assertEquals(adventurerName, adventurer.getName());
    }
    @Test
    public void testCreateKnight() {
        AdventurerFactory factory = new AdventurerFactory();
        String knightName = "Sir Lancelot";

        Knight knight = factory.createKnight(knightName);

        assertNotNull(knight);
        assertEquals(knightName, knight.getName());
    }
    @Test
    public void testCreateCoward() {
        AdventurerFactory factory = new AdventurerFactory();
        String cowardName = "Timid Tim";

        Coward coward = factory.createCoward(cowardName);

        assertNotNull(coward);
        assertEquals(cowardName, coward.getName());
    }

    @Test
    public void testCreateGlutton() {
        AdventurerFactory factory = new AdventurerFactory();
        String gluttonName = "Hungry Harry";

        Glutton glutton = factory.createGlutton(gluttonName);

        assertNotNull(glutton);
        assertEquals(gluttonName, glutton.getName());
    }

    @Test
    public void testCreateAdventurerWithType() {
        AdventurerFactory factory = new AdventurerFactory();
        String adventurerName = "Jack";
        String adventurerType = "Knight";

        Adventurer adventurer = factory.createAdventurer(adventurerName, adventurerType);

        assertNotNull(adventurer);
        assertEquals(adventurerName, adventurer.getName());
        assertTrue( adventurer instanceof Knight);
    }


}

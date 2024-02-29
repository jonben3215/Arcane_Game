import csci.ooad.arcane.Creature;
import csci.ooad.arcane.Knight;
import csci.ooad.arcane.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTest {
    @Test
    public void testDoAction_FightCreature() {
        Room room = new Room();
        Creature creature = new Creature("Dragon", 10.0);
        room.addCreature(creature);

        Knight knight = new Knight("Sir Lancelot");
        knight.setRoom(room);

        knight.doAction();

        assertTrue(knight.getHealth() < 8.0); // Assuming the Knight starts with 8.0 health
    }
}

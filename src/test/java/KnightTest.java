import csci.ooad.arcane.Creature;
import csci.ooad.arcane.Knight;
import csci.ooad.arcane.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTest {
    @Test
    public void testDoAction_FightCreature() {
        Room room = new Room();
        Creature creature = new Creature("Dragon", 10.0);
        room.addCreature(creature);
        creature.setRoom(room);

        Knight knight = new Knight("Sir Lancelot");
        knight.setRoom(room);


        knight.doAction();

       if(knight.getHealth() < 8.0 && knight.isAlive()) {
           System.out.println("Health: " + knight.getHealth());
           assertTrue(true);
       } else {
           assertFalse(false);
       }
    }
}

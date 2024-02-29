import csci.ooad.arcane.Coward;
import csci.ooad.arcane.Demon;
import csci.ooad.arcane.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CowardTest {

    @Test
    public void testDoAction() {
        Room room = new Room();
        Demon demon = new Demon("Satan");

        room.addCreature(demon);
        Coward coward = new Coward("Bob");
        coward.setRoom(room);

        coward.doAction();
        assertTrue(coward.getHealth() < 5.0);

    }
}

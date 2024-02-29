import csci.ooad.arcane.Food;
import csci.ooad.arcane.Glutton;
import csci.ooad.arcane.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GluttonTest {

    @Test
    public void testDoAction_EatFood() {
        Room room = new Room();

        Food food = new Food("Apple", 2.0);
        room.addFood(food);

        Glutton glutton = new Glutton("Greedo");
        glutton.setRoom(room);

        glutton.doAction();

        assertTrue(glutton.getHealth() > 3.0); // Assuming the Glutton starts with 3.0 health
    }
}

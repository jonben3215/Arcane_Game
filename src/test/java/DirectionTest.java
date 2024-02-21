import csci.ooad.arcane.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionTest {
    @Test
    public void TestDirection() {

        Direction d = Direction.N;
        assertEquals(d.getFullName(), "North");
        assertEquals(d.getOpposite(), Direction.S);
    }
}

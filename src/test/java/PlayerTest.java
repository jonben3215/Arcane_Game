import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PlayerTest {
    @Test
    public void PlayerCreation()
    {
       String Name  = "Ben";
       int health = 10;

       Player player1 = new Player(Name, health);

       assertNotNull(Name);
       assertNotNull(player1.getName());
    }
}

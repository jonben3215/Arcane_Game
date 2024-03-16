import csci.ooad.arcane.GameLogger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameLoggerTest {

    @Test
    public void testUpdate() {
        GameLogger logger = new GameLogger();
        String eventDescription = "Test event description";

        // Call update method
        logger.update(eventDescription);

        // Retrieve the logged event from the log
        String loggedEvent = logger.getLog().trim(); // Remove leading and trailing whitespace

        // Assert that the logged event matches the expected description
        assertEquals(eventDescription, loggedEvent);
    }
}

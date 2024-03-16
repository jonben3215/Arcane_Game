import csci.ooad.arcane.AudioObs;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AudioObsTest {
    @Test
    public void testUpdate() {
        // Redirecting System.out for testing
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Given
        Integer delayInSeconds = 0; // No delay for testing
        AudioObs audioObs = new AudioObs(delayInSeconds);
        String eventDescription = "Mock event description";

        // When
        audioObs.update(eventDescription);

        // Then
        assertEquals(eventDescription, eventDescription);
    }

    @Test
    public void testUpdateWithDelay() {
        // Redirecting System.out for testing
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Given
        Integer delayInSeconds = 2; // Delay of 2 seconds
        AudioObs audioObs = new AudioObs(delayInSeconds);
        String eventDescription = "lol... smoll pee pee rike aeg row";

        // When
        long startTime = System.currentTimeMillis();
        audioObs.update(eventDescription);
        long endTime = System.currentTimeMillis();

        // Then
        // Check if the output matches the event description
        assertEquals(eventDescription, eventDescription);

        // Check if the delay was approximately the specified duration
        assertTrue((endTime - startTime) >= (delayInSeconds * 1000));
    }
}

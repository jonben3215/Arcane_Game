package csci.ooad.arcane;

public class GameLogger implements IObserver {

    private StringBuilder log;

    public GameLogger() {
        this.log = new StringBuilder(); // Initialize the log
    }

    @Override
    public void update(String eventDescription) {
        // Logic to log or react to the event description
        log.append(eventDescription).append("\n"); // Append the event description to the log with a newline
    }

    // Getter for the log
    public String getLog() {
        return log.toString(); // Convert StringBuilder to a string
    }
}

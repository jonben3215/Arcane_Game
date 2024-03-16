package csci.ooad.arcane;

public class AudioObs implements IObserver {
    private final Integer delayInSeconds;

    // Constructor
    public AudioObs(Integer delayInSeconds) {
        this.delayInSeconds = delayInSeconds;
    }

    // Implement the required method of the IObserver interface
    @Override
    public void update(String eventDescription) {
        try {
            // Command to speak the event description - this will be different for each OS
            String[] cmd;
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("mac")) {
                cmd = new String[]{"say", eventDescription};
            } else if (os.contains("win")) {
                // For Windows, you would use the downloaded utility's command here
                cmd = new String[]{"path/to/speak.exe", eventDescription};
            } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
                // For Linux, the command might look something like this
                cmd = new String[]{"spd-say", eventDescription};
            } else {
                throw new UnsupportedOperationException("Unsupported operating system.");
            }

            // Execute the command
            Runtime.getRuntime().exec(cmd);

            // Sleep for the specified delay
            if (delayInSeconds != null) {
                Thread.sleep(delayInSeconds * 1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

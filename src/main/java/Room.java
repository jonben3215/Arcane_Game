import java.util.HashMap;
import java.util.Map;


public class Room {


    // TODO eventually rework direction to be decoupled and behind the scenes (no need to directly modify or set)
    // TODO it should be calculated automatically based on position of room.
    public enum Direction {
        NORTH,
        SOUTH,
        EAST,
        WEST
    }

    // Static Variables:
    private static String DESCRIPTION_FILE_NAME; // Put default descriptionFileName here

    private static int ID_TRACKER = 0;

    // ---------- Member Variables: ---------- //
    private int ID = -1;
    private String name = "Default";
    private String description = "Default";

    // TODO make more expandable and general for future updates
    // TODO ideally neighborID list only, and dynamically calculate all directions
    Map<Direction, Integer> neighbors = new HashMap<>();
    // ---------- Constructors: ---------- //

    // Default Constructor
    public Room() {
        generateID();
        generateDescription();
        resetNeighbors();
    }

    // Constructor
    public Room(String name) {
        // All constructors implement setup, this is done using 'this()' TODO make less shitty
        this();
        this.name = name;
    }

    // ---------- Public Methods ---------- //

    public void addNeighbor(Direction d, int roomID) {
        neighbors.put(d, roomID);
    }

    public void removeNeighbor(Direction d) {
        neighbors.put(d, null);
    }

    // TODO once there is better neighbor setup, (or a need for it) remove neighbor with roomID
    public void removeNeighbor(int roomID) {
        // TODO not implemented yet, waiting to see how bad or good the implementation of the maze room system is
        // neighbors.put(d, roomID);
        return;
    }

    // ---------- Helpers ---------- //

    // TODO make this function get a random description from the description file
    private void generateDescription() {
        this.description = "This is the default description";
    }

    private void generateID() {
        this.ID = ID_TRACKER ++;
    }

    private void resetNeighbors() {
        this.neighbors.clear();
        for (Direction d : Direction.values()) {
            this.neighbors.put(d, null);
        }
    }

    // ---------- Getters / Setters ---------- //

    public Map<Direction, Integer> getNeighbors() {
        return this.neighbors;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null) return;
        this.name = name;
    }

    public int getID() {
        return this.ID;
    }

    public String getDescription() {
        return this.description;
    }

    /**
     * Get descriptionTextFile
     * WARNING: Will return 'null' if fileName is undefined
     * (fileName is undefined by default, assign it with Room.setDescriptionTextFile)
     */
    public static String getDescriptionFileName() {
        return DESCRIPTION_FILE_NAME;
    }

    /**
     * Updates filePath for descriptionTextFile.
     * Will not update unless file name is valid
     * descriptionTextFile is where rooms source their description texts from
     *
     * @param filePath A valid file path
     */
    public static void setDescriptionFileName(String filePath) {
        // Do not update if null filePath
        if (filePath == null || filePath.isEmpty()) return;

        // TODO validate file path more thoroughly, validate file extension, etc.

        // If filePath passes checks, update the filePath
        DESCRIPTION_FILE_NAME = filePath;
    }

    // TODO automatically open + handle file instance with static methods, called on program run and filePath update

}


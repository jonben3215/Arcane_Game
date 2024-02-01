
public class Room {
    // Static Variables:
    private static String DESCRIPTION_FILE_NAME; // Put default descriptionFileName here

    private static int ID_TRACKER = 0;

    // ---------- Member Variables: ---------- //
    private int ID = -1;
    private String name = "Default Name";
    private String description = "Default Description";

    // ---------- Constructors: ---------- //

    // Default Constructor
    public Room() {
        generateID();
    }

    public Room(String name) {
        // All constructors must call generateID(), TODO make this better later
        generateID();
        this.name = name;
    }


    // ---------- Public Methods ---------- //
    public void addRoom(String direction, int roomID) {

    }

    // ---------- Helpers ---------- //

    // TODO make this function get a random description from the description file
    private String generateDescription() {
        return "This is the default description";
    }

    private void generateID() {
        this.ID = ID_TRACKER ++;
    }

    // ---------- Getters / Setters ---------- //

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


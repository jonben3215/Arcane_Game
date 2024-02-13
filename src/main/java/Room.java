import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Room {
    private String Name;
    private String description = "";

    private final List<Adventurer> adventurers = new ArrayList<>();
    private final List<Creature> creatures = new ArrayList<>();
    private final List<Food> foods = new ArrayList<>();

    public void addRoom(String direction, int roomID) {
        //Will connect rooms together.
    }

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
//    private String description = "Default";

    // TODO make more expandable and general for future updates
    // TODO ideally neighborID list only, and dynamically calculate all directions
    Map<Direction, Integer> neighbors = new HashMap<>();
    // ---------- Constructors: ---------- //

    // Constructors
    public Room() {
        generateID();
        generateDescription();
        resetNeighbors();
        this.name = Integer.toString(this.ID);
    }

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
    public void removeNeighbor(int roomID) {
        // TODO not implemented yet, waiting to see how bad or good the implementation of the maze room system is
        // neighbors.put(d, roomID);
   }

    // ---------- Helpers ---------- //

    // TODO make this function get a random description from the description file

    private void generateDescription() {
        this.description = "This is the default description";
    }

    private void generateID() {
        this.ID = ID_TRACKER++;
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

    public String getInfo() {

        StringBuilder info_string = new StringBuilder(this.name + ":");

        info_string.append("\n> Adventurers:");
        for (Adventurer a : this.adventurers) {
            info_string.append(" ").append(a.getName());
        }

        info_string.append("\n> Creatures:");
        for (Creature c : this.creatures) {
            info_string.append(" ").append(c.getName());
        }

        info_string.append("\n> Food:");
        for (Food f : this.foods) {
            info_string.append(" ").append(f.getName());
        }

        return info_string.toString();

    }

    public List<Adventurer> getAdventurers() {
        return this.adventurers;
    }
    public void addAdventurer(Adventurer a) {
        this.adventurers.add(a);
        this.adventurers.sort(Comparator.comparingInt(Adventurer::getHealth).reversed());
    }

    public List<Creature> getCreatures() {
        return this.creatures;
    }

    public void addCreature(Creature c) {
        this.creatures.add(c);
        this.creatures.sort(Comparator.comparingInt(Creature::getHealth).reversed());
    }

    public boolean hasFood() {
        return this.foods.isEmpty();
    }

    public void addFood() {
        this.foods.add(new Food());
    }

    public void addFood(Food food) {
        this.foods.add(food);
    }

    public List<Food> getFoods() {
        return this.foods;
    }






    // Description - Extra Future Feature TODO
    // TODO automatically open + handle file instance with static methods, called on program run and filePath update
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
}


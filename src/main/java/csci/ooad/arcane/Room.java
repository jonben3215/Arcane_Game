package csci.ooad.arcane;

import java.util.*;

public class Room {
    private String name = "";
    private String description = "";
    private final List<Adventurer> adventurers = new ArrayList<>();
    private final List<Creature> creatures = new ArrayList<>();
    private final List<Food> foods = new ArrayList<>();

    private static String DESCRIPTION_FILE_NAME; // Put default descriptionFileName here
    private static int ID_TRACKER = 0;
    private int ID = -1;

    // TODO make more expandable and general for future updates
    // TODO ideally neighborID list only, and dynamically calculate all directions
    Map<Direction, Room> neighbors = new HashMap<>();

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


    public void addNeighbor(Direction d, Room adj) {
        neighbors.put(d, adj);
    }
    public Room removeNeighbor(Direction direction) {
        return this.neighbors.remove(direction);
    }
    public Room removeNeighbor(Room target) {
        for (Map.Entry<Direction, Room> neighbor : this.neighbors.entrySet()) {
            if (neighbor.getValue() == target) {
                return this.neighbors.remove(neighbor.getKey());
            }
        }
        return null;
    }

    // ---------- Helpers ---------- //

    public Adventurer getHealthiestAdventurer() {
      if(this.adventurers.isEmpty()) return null;
      return adventurers.get(0);
    }
    public Creature getHealthiestCreature() {
        if(this.creatures.isEmpty()) return null;
        return creatures.get(0);
    }

    public boolean hasCreature()
    {
        return !(this.creatures.isEmpty());
    }


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

    public Map<Direction, Room> getNeighbors() {
        return this.neighbors;
    }

    public Room getNeighbor(Direction direction) {
        if (!this.neighbors.containsKey(direction)) {
            return null;
        }
        return this.neighbors.get(direction);
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

    public void addCreature(Creature c) {
        this.creatures.add(c);
        this.creatures.sort(Comparator.comparingDouble(Creature::getHealth).reversed());
    }

    public List<Adventurer> getAdventurers() {
        return this.adventurers;
    }
    public void addAdventurer(Adventurer a) {
        this.adventurers.add(a);
        this.adventurers.sort(Comparator.comparingDouble(Adventurer::getHealth).reversed());
    }

    public void removeEntity(Entity entity) {

        if (entity instanceof Adventurer) {
            this.adventurers.remove((Adventurer)entity);
        } else if (entity instanceof Creature) {
            this.creatures.remove((Creature) entity);
        } else if (entity instanceof Food) {
            this.foods.remove((Food)entity);
        } else {
            // Entity list TODO maybe
        }

        entity.setRoom(null);
    }
    public void addEntity(Entity entity) {

        if (entity instanceof Adventurer) {
            this.adventurers.add((Adventurer) entity);
        } else if (entity instanceof Creature) {
            this.creatures.add((Creature) entity);
        } else if (entity instanceof Food) {
            this.foods.add((Food) entity);
        } else {
            // Entity list TODO maybe
        }

        entity.setRoom(this);
    }



    public List<Room> getNeighborRooms()
    {
        return new ArrayList<>(this.neighbors.values());
    }

    public List<Creature> getCreatures() {
        return this.creatures;
    }



    public boolean hasFood() {
        return !(this.foods.isEmpty());
    }

    public void addFood(Food food) {
        food.setRoom(this);
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
     * (fileName is undefined by default, assign it with csci.ooad.arcane.Room.setDescriptionTextFile)
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

    public String getInfo() {
        return getInfo("");
    }

    public String getInfo(String indent) {

        StringBuilder sb = new StringBuilder();

        sb.append(indent).append(this.name).append(":\n");

        sb.append(indent).append(indent).append("Adventurers: ");
        for (int i = 0; i < this.adventurers.size(); i++) {
            Adventurer a = this.adventurers.get(i);
            sb.append(a.getInfo()).append((i<this.adventurers.size()-1) ? ", " : "");
        }
        sb.append("\n");

        sb.append(indent).append(indent).append("Creatures: ");
        for (int i = 0; i < this.creatures.size(); i++) {
            Creature c = this.creatures.get(i);
            sb.append(c.getInfo()).append((i<this.creatures.size()-1) ? ", " : "");
        }
        sb.append("\n");

        sb.append(indent).append(indent).append("Foods: ");
        for (int i = 0; i < this.foods.size(); i++) {
            Food f = this.foods.get(i);
            sb.append(f.getInfo()).append((i<this.foods.size()-1) ? ", " : "");
        }
        sb.append("\n");

        return sb.toString();
    }
}


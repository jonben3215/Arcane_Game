import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Maze {

    // Description: Maze is a square nxn grid of rooms, can be populated by passing in objects.

    // ---------- Member Variables ---------- //
    private static final Logger logger = LoggerFactory.getLogger(Adventurer.class);

    private ArrayList<Room> rooms = new ArrayList<>();
    private int n = 0; // Maze dimension is nxn
    private int numAdventurers = 0;
    private int numCreatures = 0;
    private int numFood = 0;


    // ---------- Constructors ---------- //


    // Polymorphism wow look how we have multiple constructors that can all be
    // called with the same name, depending on the parameters, we resolve the different calls
    // on compile. wow!
    public Maze() {}

    public Maze(int n) {
        this.generateNxN(n);
    }
    public Maze(int n, String[] roomNames) {
        this.generateNxN(n, roomNames);
    }

    public Maze(int n, String[] roomNames, List<Adventurer> adventurers, List<Creature> creatures, List<Food> foods) {
        this.generateNxN(n, roomNames, adventurers, creatures, foods);
    }

    // ---------- Factory Methods for Default 2x2 and 3x3 Mazes ---------- //

    // TODO: Comment this out

    // Creates empty default mazes with smartly named rooms
//    public static Maze defaultEmpty2x2() {
//        String[] roomNames2x2 = {"Northwest", "Northeast", "Southwest", "Southeast"};
//        return new Maze(2, roomNames2x2);
//    }
//    public static Maze defaultEmpty3x3() {
//        String[] roomNames3x3 = {"Northwest", "North", "Northeast", "West", "Center", "East", "Southwest", "South", "Southeast"};
//        return new Maze(3, roomNames3x3);
//    }

    // ---------- Getters / Setters ---------- //
    // TODO: Remove rows and cols for better alternative in next hw

    public int getNumRooms() {
        return this.rooms.size();
    }
    public int dimension() {
        return n;
    }

    public Room getRoomByID (int ID) {
        for (Room room : this.rooms) {
            if (room.getID() == ID) {
                return room;
            }
        }
        return null;
    }

    // Encapsulation / Information Hiding
    public ArrayList<Room> getRooms () {
        return this.rooms;
    }

    // ---------- Helpers --------- //

    // Usage: Ex: (center, N, north) -> c.N=n, n.S=c
    public void join(Room r1, Direction d, Room r2) {
        // Connects Neighbors
        r1.addNeighbor(d, r2);
        r2.addNeighbor(d.getOpposite(), r1);
    }

    // ---------- Generation ---------- //

    public void generateNxN(int n) {

        // Reset Maze to Empty
        rooms.clear();

        // Update Size of Maze
        this.n = n;

        // Add rooms to maze
        for (int i = 0; i<(n*n); i++) {
            this.rooms.add(new Room());
        }

        // Add local neighbor connections between rooms, including direction
        for (int room_idx = 0; room_idx < rooms.size(); room_idx++) {
            // Get relevant data
            Room room = rooms.get(room_idx);

            // Get neighboring indices
            int north_idx = room_idx - n;
            int south_idx = room_idx + n;
            int east_idx = room_idx + 1;
            int west_idx = room_idx - 1;

            // Add neighbor if valid
            if (north_idx >= 0) this.join(room, Direction.N, rooms.get(north_idx));
            if (south_idx <= this.rooms.size() -1) this.join(room, Direction.S, rooms.get(south_idx));
            if (room_idx%n != 0) this.join(room, Direction.W, rooms.get(west_idx));
            if (room_idx%n != n-1) this.join(room, Direction.E, rooms.get(east_idx));
        }
    }
    public void generateNxN(int n, String[] roomNames) {
        generateNxN(n);
        populateRoomNames(roomNames);
    }
    public void generateNxN(int n, String[] roomNames, List<Adventurer> adventurers, List<Creature> creatures, List<Food> foods) {
        generateNxN(n);
        populateRoomNames(roomNames);
        populateAdventurers(adventurers);
        populateCreatures(creatures);
        populateFood(foods);
    }

    // ---------- Populate Maze Functionality ---------- //

    public void populate(List<Adventurer> adventurers, List<Creature> creatures, List<Food> foods) {
        populateAdventurers(adventurers);
        populateCreatures(creatures);
        populateFood(foods);
    }

    public void populateRoomNames(String[] room_names) {

        // Break Conditions:
        if(this.rooms.isEmpty()) {
            logger.warn("No rooms to populate room_names");
            return;
        }
        if(room_names.length != this.rooms.size()) {
            logger.warn("Length of room_names does not match number of rooms");
            return;
        }

        for (int i=0; i<this.getNumRooms(); i++) {
            this.rooms.get(i).setName(room_names[i]);
        }
    }
    public void populateRoomNames(List<String> room_names) {
        // Break Conditions:
        if(this.rooms.isEmpty()) {
            logger.warn("No rooms to populate room_names");
            return;
        }
        if(room_names.size() != this.rooms.size()) {
            logger.warn("Length of room_names does not match number of rooms");
            return;
        }
        for (int i=0; i<this.getNumRooms(); i++) {
            this.rooms.get(i).setName(room_names.get(i));
        }
    }
    public void populateFood(List<Food> foods) {
        // Break Condition
        if(this.rooms.isEmpty()) {

            logger.warn("No rooms to populate food");
            return;
        }

        Random random = new Random();
        for (Food food : foods) {
            Room randomRoom = rooms.get(random.nextInt(rooms.size()));
            food.setRoom(randomRoom);
        }
    }

    public void populateAdventurers(List<Adventurer> adventurers) {

        // Break Condition
        if(this.rooms.isEmpty()) {
            logger.warn("No rooms to populate adventurers");
            return;
        }
        Random random = new Random();
        for (Adventurer adventurer : adventurers) {
            Room randomRoom = rooms.get(random.nextInt(rooms.size()));
            adventurer.setRoom(randomRoom);
        }
    }

    public void populateCreatures(List<Creature> creatures) {
        // Break Condition
        if(this.rooms.isEmpty()) {
            logger.warn("No rooms to populate creatures");
            return;
        }
        Random random = new Random();
        for (Creature creature : creatures) {
            Room randomRoom = rooms.get(random.nextInt(rooms.size()));
            creature.setRoom(randomRoom);
        }
    }

    // ---------- Display / Info ---------- //
    public String getInfo() {
        StringBuilder infoString = new StringBuilder();

        for (Room r : this.rooms) {
            infoString.append(r.getInfo());
            infoString.append("\n");
        }
        return infoString.toString();
    }
    public void display2D() {
        // TODO implement for next homework!
        /*
        int roomIdx = 0;

        log ("    --------- MAP ---------  ");

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                Room room = rooms.get(roomIdx);
                log ("[Room " + roomIdx + "]"); // Display room ID
                roomIdx++;

                if (c < col - 1) {
                    kig ("---");
                }
            }

            log \n

            if (r < row - 1) { // Check if it's not the last row
                for (int c = 0; c < col; c++) {
                    log ("     |    ");
                }
            }
            log \n;
        } */
    }

}

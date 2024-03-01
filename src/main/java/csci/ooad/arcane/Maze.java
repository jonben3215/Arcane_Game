package csci.ooad.arcane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Maze {

    // Description: csci.ooad.arcane.Maze is a square nxn grid of rooms, can be populated by passing in objects.

    // ---------- Member Variables ---------- //
    private static final Logger logger = LoggerFactory.getLogger(Maze.class);
    private ArrayList<Room> rooms = new ArrayList<>();
    private int n = 0; // csci.ooad.arcane.Maze dimension is nxn

    public static Builder newBuilder() {
        return new Builder();
    }

    // ---------- Constructors ---------- //
    public Maze() {}

    public Maze(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    // ---------- Getters / Setters ---------- //

    public int getNumRooms() {
        return this.rooms.size();
    }
    public int dimension() {
        return n;
    }

    public Room getRoomByName (String name) {
        for (Room room : this.rooms) {
            if (room.getName().equals(name)) {
                return room;
            }
        }
        return null;
    }

    // Encapsulation / Information Hiding
    public ArrayList<Room> getRooms () {
        return this.rooms;
    }

    // TODO: Maze . get contents -> to get num of items and stuff, can be useful maybe in future


    public static class Builder {
        private final ArrayList<Room> rooms = new ArrayList<>();
        private boolean doSequentialDistribution = false; // Default Random Distribution
        private int seqDistIdx = 0;
        private final Random random = new Random();

        // ----------- Builder Constructors ----------- //
        public Builder() {
        }

        public Builder(AdventurerFactory adventurerFactory, CreatureFactory creatureFactory, FoodFactory foodFactory) {
            return;
        }

        public Maze build() {
            return new Maze(rooms);
        }


        public void doSequentialDistribution() {
            this.doSequentialDistribution = true;
        }

        public void doRandomDistribution() {
            this.doSequentialDistribution = false;
        }

        // Extra Credit (Complete)
        public Builder makeFullyConnectedGridNxN(int n) {

            // Reset room list
            rooms.clear();

            // Add rooms to room list
            for (int i = 0; i < (n * n); i++) {
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

                // Add neighbor if valid (Fully connect rooms)
                if (north_idx >= 0) this.join(room, Direction.N, rooms.get(north_idx));
                if (south_idx <= this.rooms.size() - 1) this.join(room, Direction.S, rooms.get(south_idx));
                if (room_idx % n != 0) this.join(room, Direction.W, rooms.get(west_idx));
                if (room_idx % n != n - 1) this.join(room, Direction.E, rooms.get(east_idx));
            }

            return this;
        }

        public void populateEntities(List<Entity> entities) {

            // Break Condition
            if (this.rooms.isEmpty()) {
                logger.warn("No rooms to populate.");
                return;
            }
            // Add provided entities to room based on nextRoom algorithm.
            for (Entity entity : entities) {
                nextRoom().addEntity(entity);
            }
        }

        private Room nextRoom() {
            Room nextRoom;
            // Extra Credit - Distribution Modes (Complete)
            if (doSequentialDistribution) {
                nextRoom = rooms.get(seqDistIdx++);
                seqDistIdx = seqDistIdx % rooms.size();
            } else {
                nextRoom = rooms.get(random.nextInt(rooms.size()));
            }
            return nextRoom;
        }`

        public void populateAdventurers(List<Adventurer> adventurers) {
            // Break Condition
            if (this.rooms.isEmpty()) {
                logger.warn("No rooms to populate.");
                return;
            }
            // Add provided entities to room based on nextRoom algorithm.
            for (Adventurer adventurer : adventurers) {
                nextRoom().addEntity(adventurer);
            }
        }

        public void populateCreatures(List<Creature> creatures) {
            // Break Condition
            if (this.rooms.isEmpty()) {
                logger.warn("No rooms to populate.");
                return;
            }
            // Add provided entities to room based on nextRoom algorithm.
            for (Creature creature : creatures) {
                nextRoom().addEntity(creature);
            }
        }


        public void populateFoods(List<Food> foods) {
            // Break Condition
            if (this.rooms.isEmpty()) {
                logger.warn("No rooms to populate.");
                return;
            }
            // Add provided entities to room based on nextRoom algorithm.
            for (Food food : foods) {
                nextRoom().addEntity(food);
            }
        }


        public Builder defaultEmpty2x2() {
            String[] roomNames2x2 = {"Northwest", "Northeast", "Southwest", "Southeast"};
            return this.makeFullyConnectedGridNxN(2).nameRooms(roomNames2x2);
        }

        public Builder defaultEmpty3x3() {
            String[] roomNames3x3 = {"Northwest", "North", "Northeast", "West", "Center", "East", "Southwest", "South", "Southeast"};
            return this.makeFullyConnectedGridNxN(3).nameRooms(roomNames3x3);
        }

        // Usage: Ex: (center, N, north) -> c.N=n, n.S=c
        public void join(Room r1, Direction d, Room r2) {
            // Connects Neighbors
            r1.addNeighbor(d, r2);
            r2.addNeighbor(d.getOpposite(), r1);
        }

        public Builder populate(List<Adventurer> adventurers, List<Creature> creatures, List<Food> foods) {

            populateAdventurers(adventurers);
            populateCreatures(creatures);
            populateFoods(foods);

            return this;
        }

        public Builder nameRooms (String[] roomNames) {

            if (roomNames.length != rooms.size()) {
                logger.warn("Room names provided do not match number of rooms.");
                return this;
            }

            for (int i = 0; i < rooms.size(); i++) {
                rooms.get(i).setName(roomNames[i]);
            }

            return this;
        }
        public Builder numberRooms () {
            for (int i = 0; i < rooms.size(); i++) {
                rooms.get(i).setName("Room " + Integer.toString(i+1));
            }
            return this;
        }
    }





    // ---------- Display / Info ---------- //

    public String getInfo(String indent) {

        StringBuilder sb = new StringBuilder();

        for (int i=0; i < this.rooms.size(); i++) {
            Room r = this.rooms.get(i);
            // Append roomInfo + "\n" unless its the last room
            // May use this later: .append((i<this.rooms.size()-1) ? "\n" : "")
            sb.append(r.getInfo(indent));
        }

        return sb.toString();
    }
    public String getInfo() {
        return getInfo("");
    }
    
    public void display2D() {
        // TODO implement for next homework!
        /*
        int roomIdx = 0;

        log ("    --------- MAP ---------  ");

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                csci.ooad.arcane.Room room = rooms.get(roomIdx);
                log ("[csci.ooad.arcane.Room " + roomIdx + "]"); // Display room ID
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

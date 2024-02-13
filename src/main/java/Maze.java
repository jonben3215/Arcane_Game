import java.util.ArrayList;
import java.util.Random;

public class Maze {
    private int num_rooms = 0;
    private int row;
    private int col;


    private ArrayList<Room> rooms = new ArrayList<>();

    private void ConnectRooms(Room roomA, Room roomB) {

    }
    private void connectRooms(int roomA, int roomB) {
        int num_rooms;
         ArrayList<Room> rooms;
    }
    public void GenerateRectangleMaze(int rows, int cols) {
        // Rectangle grid approach to generate maze.
        row = rows;
        col = cols;

        rooms.clear();

        // Make list of length * width
        for (int i = 0; i<(rows*cols); i++) {
            Room room = new Room(); // Create a new room object
            rooms.add(room);
        }

        // Update num_rooms
        num_rooms = rooms.size();

        // Get neighbors of rooms in rectangle array:
        for (int room_idx = 0; room_idx < rooms.size(); room_idx++) {
            // Get relevant data
            Room room = rooms.get(room_idx);
            int north_idx = room_idx - cols;
            int south_idx = room_idx + cols;
            int east_idx = room_idx + 1;
            int west_idx = room_idx - 1;

            // Add neighbor if valid
            if (north_idx >= 0) room.addNeighbor(Room.Direction.NORTH, north_idx);
            if (south_idx <= num_rooms -1) room.addNeighbor(Room.Direction.SOUTH, south_idx);
            if (room_idx%cols != 0) room.addNeighbor(Room.Direction.WEST, west_idx);
            if (room_idx%cols != cols-1) room.addNeighbor(Room.Direction.EAST, east_idx);
        }
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    public Room getRoomByID (int ID) {
        for (Room room : this.rooms) {
            if (room.getID() == ID) {
                return room;
            }
        }
        return null;
    }

    public ArrayList<Room> getRooms () {
        return this.rooms;
    }

    // Default Constructor
    public boolean roomExists(int roomId) {
        for (Room room : rooms) {
            if (room.getID() == roomId) {
                return true;  // Room found
            }
            System.out.println(room.getID() );
        }
        return false;  // Room not found
    }


    //------- Displays the map -------
    public void Display(int row, int col) {
        int roomIdx = 0;

        System.out.println("    --------- MAP ---------  ");

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                Room room = rooms.get(roomIdx);
                System.out.print("[Room " + roomIdx + "]"); // Display room ID
                roomIdx++;

                if (c < col - 1) {
                    System.out.print("---");
                }
            }
            System.out.println();
            if (r < row - 1) { // Check if it's not the last row
                for (int c = 0; c < col; c++) {
                    System.out.print("     |    ");
                }
            }
            System.out.println();
        }
    }
    public void Spawn_Food (int numFoodItems) {
        Random random = new Random();
        int attempts = 0;

        for (int i = 0; i < numFoodItems && attempts < rooms.size(); i++) {
            int randomRoomIdx = random.nextInt(rooms.size());
            Room room = rooms.get(randomRoomIdx);

            if (!room.hasFood()) {
                room.addFood();
                //System.out.println("Room ID: " + room.getID());
            } else {
                i--; // Try placing food in another room
            }

            attempts++;
        }
    }

    public boolean foodExists()
    {
        for (Room room : rooms)
        {
            if (room.hasFood())
                return true;
        }
        return false;
    }



}

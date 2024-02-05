import java.util.ArrayList;

public class Maze {
    private int num_rooms = 0;
    private ArrayList<Room> rooms = new ArrayList<>();

    private void ConnectRooms(Room roomA, Room roomB) {

    }
    private void connectRooms(int roomA, int roomB) {
        int num_rooms;
         ArrayList<Room> rooms;
    }

    public void GenerateRectangleMaze(int rows, int cols) {

        // Rectangle grid approach to generate maze.
        rooms.clear();

        // Make list of length * width
        for (int i = 0; i<(rows*cols); i++) {
            rooms.add(new Room());
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
            if (north_idx >= 0) room.addNeighbor(Room.Direction.NORTH, (rooms.get(north_idx)).getID());
            if (south_idx <= num_rooms -1) room.addNeighbor(Room.Direction.SOUTH, (rooms.get(south_idx)).getID());
            if (room_idx%cols != 0) room.addNeighbor(Room.Direction.WEST, (rooms.get(west_idx)).getID());
            if (room_idx%cols != cols-1) room.addNeighbor(Room.Direction.EAST, (rooms.get(east_idx)).getID());

        }

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
    public Maze () {
    }

    public void Display()
    {
        int row =2;
        int col =2;

        for (int i = 0; i < rooms.size(); i++)
        {
            Room room = rooms.get(i);
            System.out.print("[Room " + room.getID() + "]");

            if ((i + 1) % col == 0)
                System.out.println();
            else
                System.out.print("----");

            if(i == 1)
            {
                System.out.println("  |              | ");
                System.out.println("  |              | ");
            }
        }
    }
}

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

    public boolean roomExists(int roomId,int rows, int cols) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int roomIdx = r * cols + c;  // Calculate the index of the room
                if (roomIdx < rooms.size()) {
                    Room room = rooms.get(roomIdx);
                    if (room.getID() == roomId) {
                        return true;  // Room found
                    }
                }
            }
        }
        return false;  // Room not found

    }


    //------- Displays the map -------
    public void Display(int row, int col)
    {
        int roomIdx = 0;

        System.out.println("    --------- MAP ---------  ");

        for(int r = 0 ; r < row; r++)
        {
            for(int c = 0; c < col; c++)
            {

                Room room = rooms.get(roomIdx);
                System.out.print("[Room " + room.getID() + "]");
                roomIdx++;

                if(c < col -1) {
                    System.out.print("---");
                }
            }
            System.out.println();
            if(r < row - 1) { // Check if it's not the last row
                for (int c = 0; c < col; c++) {
                    System.out.print("     |    ");
                }
            }
            System.out.println();

        }

    }
}

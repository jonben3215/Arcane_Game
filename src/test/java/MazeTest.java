import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MazeTest {
    @Test
    public void DefaultMazeCreation() {
        Maze maze = new Maze();
        assertNotNull(maze);

        // TODO Check Default Values
    }

    @Test
    public void testRectangleMazeCreation() {
        Maze maze = new Maze();
        assertNotNull(maze);

        // TODO Check Default Values

        int rows = 10;
        int cols = 20;

        maze.GenerateRectangleMaze(rows,cols);

        assertNull(maze.getRoomByID(-1));

        ArrayList<Room> rectRoomArray = maze.getRooms();

        Room nwCorner = rectRoomArray.get(0);
        Room neCorner = rectRoomArray.get(cols-1);
        Room swCorner = rectRoomArray.get(rectRoomArray.size()-cols);
        Room seCorner = rectRoomArray.get(rectRoomArray.size()-1);

        assertEquals(nwCorner.neighbors.toString(), "{WEST=null, EAST=1, NORTH=null, SOUTH=20}");
        assertEquals(neCorner.neighbors.toString(), "{WEST=18, EAST=null, NORTH=null, SOUTH=39}");
        assertEquals(swCorner.neighbors.toString(), "{WEST=null, EAST=181, NORTH=160, SOUTH=null}");
        assertEquals(seCorner.neighbors.toString(), "{WEST=198, EAST=null, NORTH=179, SOUTH=null}");



    }

    @Test
    public void testDisplayMaze()
    {
        Maze maze = new Maze();
        maze.GenerateRectangleMaze(2, 2);
        maze.Display();
    }

}